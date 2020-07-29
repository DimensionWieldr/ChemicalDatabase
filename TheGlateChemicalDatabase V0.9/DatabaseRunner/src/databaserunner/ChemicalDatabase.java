/*
    ChemicalDatabase.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: To provide all functionalities of the database, including storage, searching, and sorting.
*/

package databaserunner;

import java.util.*;
import java.io.*;

public class ChemicalDatabase {
    
    ///
    //FIELDS
    ///
    
    public static final double STANDARD_TEMPERATURE = 25.0;
    
    private List<Chemical> chemicals;
    private ReactionManager reactionManager;
    private PeriodicTable periodicTable;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public List<Chemical> getChemicals() {
        return this.chemicals;
    } 
    public void setChemicals(List<Chemical> chemicals) {
        this.chemicals = chemicals;
    }  
    
    public PeriodicTable getPeriodicTable() {
        return this.periodicTable;
    }
    public void setPeriodicTable(PeriodicTable periodicTable) {
        this.periodicTable = periodicTable;
    }
    
    public ReactionManager getReactionManager(){
        return this.reactionManager;
    }
    public void setReactionManager(ReactionManager reactionManager){
        this.reactionManager = reactionManager;
    }
    
    ///
    //CONSTRUCTOR
    ///
    
    public ChemicalDatabase() {
        this.chemicals = new ArrayList();
        this.reactionManager = new ReactionManager();
    }
    
    ///
    //METHODS
    ///
    
    //File I/O
    public boolean load(String elementsFile, String binaryCompoundsFile, String reactionsFile, int firstValence, int increment, boolean periodicTrendsChanged) {
        String line;
        boolean noElements = false;
        
        try {
            //Load Elements File
            BufferedReader in = new BufferedReader(new FileReader(elementsFile));
            
            while((line = in.readLine()) != null){
                Element newElement = new Element(line, Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine());
                this.addElement(newElement);
            }
            in.close();
            
            
        }catch(IOException iox){
            System.out.println("Warning: Elements File NOT FOUND");
            noElements = true;
        }
        
        this.periodicTable = new PeriodicTable(firstValence, increment, this.sortElements());
        
        if (!noElements) {
            try{
                    //Load Binary Compound File
                BufferedReader in = new BufferedReader(new FileReader(binaryCompoundsFile));
                if (!periodicTrendsChanged) {
                    while((line = in.readLine()) != null){
                        BinaryCompound newBinaryCompound = new BinaryCompound(line, Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), new FormulaComponent((Element)searchChemicalsByName(in.readLine()), Integer.parseInt(in.readLine())), new FormulaComponent((Element)searchChemicalsByName(in.readLine()), Integer.parseInt(in.readLine())));
                        this.addBinaryCompound(newBinaryCompound);
                    }
                }
                in.close();
            }catch(IOException iox){
                System.out.println("Warning: Compounds File NOT FOUND");
            }

            try{
                //Load Reactions File
                BufferedReader in = new BufferedReader(new FileReader(reactionsFile));
                if (periodicTrendsChanged) {
                    while((line = in.readLine()) != null){
                        Reaction newReaction = this.simulateReaction((Element)searchChemicalsByName(in.readLine()), (Element)searchChemicalsByName(in.readLine()));
                        newReaction.getProduct().setCommonName(in.readLine());
                        this.reactionManager.getReactionList().add(newReaction);
                    }
                } else {
                    while((line = in.readLine()) != null){
                        Reaction newReaction = new Reaction(Integer.parseInt(line), (Element)searchChemicalsByName(in.readLine()), (Element)searchChemicalsByName(in.readLine()), (BinaryCompound)searchChemicalsByName(in.readLine()));
                        this.reactionManager.getReactionList().add(newReaction);
                    }
                }
                in.close();
            } catch(IOException iox) {
                System.out.println("Warning: Reactions File NOT FOUND");
            }
        }
        return true;
    }
    public boolean save(String elementsFile, String binaryCompoundsFile, String reactionsFile) {
        try {
            //Output Element File
            BufferedWriter out = new BufferedWriter(new FileWriter(elementsFile, false));
            
            for(int i = 0 ; i < this.chemicals.size() ; i++){
                if(chemicals.get(i) instanceof Element) {
                    Element outputElement = (Element)chemicals.get(i);
                    out.write(outputElement.toString());
                }
            } 
            out.close();
            
            //Output BinaryCompound File
            out = new BufferedWriter(new FileWriter(binaryCompoundsFile, false));
            
            for(int i = 0 ; i < this.chemicals.size() ; i++){
                if(chemicals.get(i) instanceof BinaryCompound) {
                    BinaryCompound outputBinaryCompound = (BinaryCompound)chemicals.get(i);
                    int numReactionsInvolved = outputBinaryCompound.reactionsInvolved.size();
                    
                    out.write(outputBinaryCompound.toString());
                }
            }
            out.close();
            
            //Output Reaction File
            out = new BufferedWriter(new FileWriter(reactionsFile, false));
            
            for(int i = 0 ; i < this.reactionManager.getReactionList().size() ; i++){
                out.write(this.reactionManager.getReactionList().get(i).toString());
            }
            out.close();
            
        } catch(IOException e) {
            return false;
        }
        
        return true;
    }
    
    //adding objects into database
    public boolean addElement(Element newElement){
        if(this.numProtonRepeats(newElement.getNumProton()) || this.commonNameRepeats(newElement.getCommonName()) || this.elementMolecularFormulaRepeats(newElement.getAtomicSymbol()))
            return false;
        this.chemicals.add(newElement);
        return true;
    }
    public boolean addBinaryCompound(BinaryCompound newBinaryCompound){
        if(this.commonNameRepeats(newBinaryCompound.getCommonName()))
            return false;
        this.chemicals.add(newBinaryCompound);
        return true;
    }
    public void addReaction(Reaction newReaction){
        this.reactionManager.addReaction(newReaction);
    }
    
    //simulate a new Reaction
    public Reaction simulateReaction(Element reactant1, Element reactant2) {
        Reaction newReaction = this.reactionManager.simulateReaction(reactant1, reactant2);

        if (newReaction.getID() != Reaction.getIMPOSSIBLE_REACTION_ID()) {
            if (!isNewReaction(newReaction))
                newReaction.setID(Reaction.getREPEATED_REACTION_ID());

            if (newReaction.getID() != Reaction.getREPEATED_REACTION_ID()) {
                this.reactionManager.addReaction(newReaction);
                this.chemicals.add(newReaction.getProduct());
            }
        }

        return newReaction;
    }
    
    //editing existing objects in the database
    public boolean editElements(Element elementToBeEdited, String commonName, double stpDensity, double bp, double mp, String colour, String molecularFormula, int numProton, double electronegativity, int numNeutron, double molarMass, double ionizationEnergy){
        //Save temporary variables from toBeEdited element before removal
        List<Reaction> oldReactionsInvolved = elementToBeEdited.getReactionsInvolved();
        
        int length = oldReactionsInvolved.size();
        Element[] reactant1Array = new Element[length];
        String[] reactant1Names = new String[length];
        Element[] reactant2Array = new Element[length];
        String[] reactant2Names = new String[length];
        String[] productNames = new String[length];
        boolean successful = false;
                
        for (int i = 0 ; i < length ; i++) {
            reactant1Names[i] = oldReactionsInvolved.get(i).getReactant1().getCommonName();
            reactant1Array[i] = oldReactionsInvolved.get(i).getReactant1();
            reactant2Names[i] = oldReactionsInvolved.get(i).getReactant2().getCommonName();
            reactant2Array[i] = oldReactionsInvolved.get(i).getReactant2();
            productNames[i] = oldReactionsInvolved.get(i).getProduct().getCommonName();
        }
        
        //Remove chemical to allow for repeat checks
        this.removeChemical(elementToBeEdited);
        
        //Only edit the element if information is valid
        if(!(this.numProtonRepeats(numProton) || this.commonNameRepeats(commonName) || this.elementMolecularFormulaRepeats(molecularFormula))){
            elementToBeEdited = new Element(commonName, stpDensity, molarMass, bp, mp, colour, numProton, numNeutron, ionizationEnergy, electronegativity, molecularFormula);
            successful = true;
        }
        
        //Add back chemical
        this.chemicals.add(elementToBeEdited);
        this.updateTable();
        
        //Re-simulate reactions
        Reaction newReaction;
        for (int i = 0 ; i < length ; i++) {
            if (elementToBeEdited.getCommonName().equals(reactant1Names[i]) && elementToBeEdited.getCommonName().equals(reactant2Names[i])) {
                newReaction = this.simulateReaction(elementToBeEdited, elementToBeEdited);
                newReaction.getProduct().setCommonName(productNames[i]);
            } else if (elementToBeEdited.getCommonName().equals(reactant1Names[i])) {
                newReaction = this.simulateReaction(elementToBeEdited, reactant2Array[i]);
                newReaction.getProduct().setCommonName(productNames[i]);
            } else if (elementToBeEdited.getCommonName().equals(reactant2Names[i])) {
                newReaction = this.simulateReaction(reactant1Array[i], elementToBeEdited);
                newReaction.getProduct().setCommonName(productNames[i]);
            }   
        }
        
        return successful;
    }
    public boolean editBinaryCompounds(BinaryCompound binaryCompoundToBeEdited, String commonName, double stpDensity, double bp, double mp, String colour){
        this.chemicals.remove(binaryCompoundToBeEdited);
        binaryCompoundToBeEdited.getComponent1().getComponent().getCompoundsInvolved().remove(binaryCompoundToBeEdited);
        binaryCompoundToBeEdited.getComponent2().getComponent().getCompoundsInvolved().remove(binaryCompoundToBeEdited);
        
        if(this.commonNameRepeats(commonName)){
            this.chemicals.add(binaryCompoundToBeEdited);
            return false;
        }
        
        List<Reaction> oldReactionsInvolved = binaryCompoundToBeEdited.getReactionsInvolved();
        
        binaryCompoundToBeEdited = new BinaryCompound(commonName, stpDensity, binaryCompoundToBeEdited.getMolarMass(), bp, mp, colour, binaryCompoundToBeEdited.getCharge(), binaryCompoundToBeEdited.getComponent1(), binaryCompoundToBeEdited.getComponent2());
        binaryCompoundToBeEdited.setReactionsInvolved(oldReactionsInvolved);
        
        for (int i = 0 ; i < binaryCompoundToBeEdited.getReactionsInvolved().size() ; i++) {
            binaryCompoundToBeEdited.getReactionsInvolved().get(i).setProduct(binaryCompoundToBeEdited);
        }
        
        this.chemicals.add(binaryCompoundToBeEdited);
        return true;
    }
    
    //remove the specified object
    public boolean removeChemical(Chemical chemicalToBeRemoved) {

        if(chemicalToBeRemoved == null) 
            return false;

        if (chemicalToBeRemoved instanceof Element) {
            Element elementToBeRemoved = (Element)chemicalToBeRemoved;
            int length = elementToBeRemoved.getCompoundsInvolved().size();
            for (int i = 0 ; i < length ; i++) {
                this.removeChemical(elementToBeRemoved.getCompoundsInvolved().get(0));
            }
        }

        if (chemicalToBeRemoved instanceof BinaryCompound) {
            
            BinaryCompound compoundToBeRemoved = (BinaryCompound)chemicalToBeRemoved;
            compoundToBeRemoved.getComponent1().getComponent().getCompoundsInvolved().remove(compoundToBeRemoved);
            compoundToBeRemoved.getComponent2().getComponent().getCompoundsInvolved().remove(compoundToBeRemoved);
        }
        
        //Remove Reactions related to chemical
        int length = chemicalToBeRemoved.getReactionsInvolved().size();
        for (int i = 0 ; i < length ; i++) {
            this.reactionManager.removeReaction(chemicalToBeRemoved.getReactionsInvolved().get(0));
        }
                
        this.chemicals.remove(chemicalToBeRemoved);
       
        return true;
    }
    public void removeReaction(Reaction reactionToBeRemoved){
        if(reactionToBeRemoved != null){
            //If we are to expand reaction so that compounds can create more complicated reactions
            //we would need to check that the product was not created by any other reactions before we remove it.
            //However since our current reaction algorithm only allows for one unique reaction combo for each product
            //we can safely remove the entire reaction + product all the time.
            this.removeChemical(reactionToBeRemoved.getProduct());
        }
    }
    
    //Searching Methods
    public Reaction searchReactionsByID(int id) {
        return this.reactionManager.searchReactionsByID(id);
    }
    public Chemical searchChemicalsByName(String name) {
        Chemical curChemical;
        for (int i = 0 ; i < chemicals.size() ; i++) {
            curChemical = this.chemicals.get(i);
            if (curChemical.getCommonName().toLowerCase().trim().equals(name.toLowerCase().trim())) 
                return curChemical;
        }
        return null;
    }
    public int searchChemicalIndicesByName(String name) {
        Chemical curChemical;
        for (int i = 0 ; i < chemicals.size() ; i++) {
            curChemical = this.chemicals.get(i);
            if (curChemical.getCommonName().toLowerCase().trim().equals(name.toLowerCase().trim())) 
                return i;
        }
        return -1;
    }
    public Element searchElementByAtomicSymbol(String symbol){
        Element curElement;
        for (int i = 0 ; i < chemicals.size() ; i++) {
            if (this.chemicals.get(i) instanceof Element) {
                curElement = (Element)this.chemicals.get(i);
                if (curElement.getAtomicSymbol().equals(symbol))
                    return curElement;
            }
        }
        if(symbol.equals(Element.DEFAULT_ATOMIC_SYMBOL))
            return PeriodicTable.getUNKNOWN_ELEMENT();
        return null;
    }
    public Element searchElementByAtomicNum(int num) {
        List<Element> sortedElements = this.sortElements();
        
        int upperBound = sortedElements.size()-1, lowerBound = 0;
        int index = -1;
        boolean found = false;
        
        while (!found && upperBound >= lowerBound) {
            index = (upperBound + lowerBound) / 2;
            if (sortedElements.get(index).getNumProton() == num) 
                found = true;
            else if (sortedElements.get(index).getNumProton() > num)
                upperBound = index - 1;
            else
                lowerBound = index + 1;
        }
        if(found)
            return sortedElements.get(index);
        return null;
    }
    public int searchElementIndicesByAtomicNum(int num) {  
        Element curElement;
        for (int i = 0 ; i < chemicals.size() ; i++) {
            if (this.chemicals.get(i) instanceof Element) {
                curElement = (Element)this.chemicals.get(i);
                if (curElement.getNumProton() == num) 
                    return i;
            }
        }
        return -1;
    }
    
    //Sorting Methods (Selection Sort). Returns a list after sorting.
    public List<Chemical> sortChemicalsByName() {
        List<Chemical> sortedChemicals = new ArrayList(chemicals);
        
        //sort chemicals by name alphabetically
        int index;
        for(int i = sortedChemicals.size()-1; i >= 1; i--){
            index = i;
            for(int j = 0; j <= i; j++){
                if(sortedChemicals.get(j).getCommonName().toLowerCase().compareTo(sortedChemicals.get(index).getCommonName().toLowerCase()) > 0) {
                    index = j;
                }
            }
            Collections.swap(sortedChemicals, i, index);
        }
        
        return sortedChemicals;
    }
    public List<Chemical> sortChemicalsByMeltingPoint() {
        List<Chemical> sortedChemicals = new ArrayList();
        
        //sift out valid chemicals
        for(Chemical x : chemicals){
            if(x.getMP() != Chemical.DEFAULT_STATE_CHANGE_TEMP){
                sortedChemicals.add(x);
            }
        }
        
        //sort chemicals by melting point (lowest to highest melting point)
        int index;
        for(int i = sortedChemicals.size()-1; i >= 1; i--){
            index = i;
            for(int j = 0; j <= i; j++){
                if(sortedChemicals.get(j).getMP() > sortedChemicals.get(index).getMP()) {
                    index = j;
                }
            }
            Collections.swap(sortedChemicals, i, index);
        }
        
        return sortedChemicals;
    }
    public List<Chemical> sortChemicalsByBoilingPoint() {
        List<Chemical> sortedChemicals = new ArrayList();
        
        //sift out valid chemicals
        for(Chemical x : chemicals){
            if(x.getBP() != Chemical.DEFAULT_STATE_CHANGE_TEMP){
                sortedChemicals.add(x);
            }
        }
        
        //sort chemicals by boiling point (lowest to highest boiling point)
        int index;
        for(int i = sortedChemicals.size()-1; i >= 1; i--){
            index = i;
            for(int j = 0; j <= i; j++){
                if(sortedChemicals.get(j).getBP() > sortedChemicals.get(index).getBP()) {
                    index = j;
                }
            }
            Collections.swap(sortedChemicals, i, index);
        }
        
        return sortedChemicals;
    }
    public List<Chemical> sortChemicalsByStpState(char state) {
        List<Chemical> sortedChemicals = new ArrayList();
        
        //sift out valid chemicals
        for(Chemical x : chemicals){
            if(x.getStpState() == state){
                sortedChemicals.add(x);
            }
        }
        
        return sortedChemicals;
    }
    public List<Chemical> sortChemicalsByStpDensity(){
        List<Chemical> sortedChemicals = new ArrayList();
        
        //sift out valid chemicals
        for(Chemical x : chemicals){
            if(x.getStpDensity() != Chemical.DEFAULT_DENSITY){
                sortedChemicals.add(x);
            }
        }
        
        //sort chemicals by density (lowest to highest density)
        int index;
        for(int i = sortedChemicals.size()-1; i >= 1; i--){
            index = i;
            for(int j = 0; j <= i; j++){
                if(sortedChemicals.get(j).getStpDensity() > sortedChemicals.get(index).getStpDensity()) {
                    index = j;
                }
            }
            Collections.swap(sortedChemicals, i, index);
        }
        
        return sortedChemicals;
    }
    public List<Chemical> sortChemicalsByMolarMass(){
        List<Chemical> sortedChemicals = new ArrayList();
        
        //sift out valid chemicals
        for(Chemical x : chemicals){
            if(x.getMolarMass() != Chemical.DEFAULT_MOLAR_MASS){
                sortedChemicals.add(x);
            }
        }
        
        //sort chemicals by molar mass (lowest to highest molar mass)
        int index;
        for(int i = sortedChemicals.size()-1; i >= 1; i--){
            index = i;
            for(int j = 0; j <= i; j++){
                if(sortedChemicals.get(j).getMolarMass() > sortedChemicals.get(index).getMolarMass()) {
                    index = j;
                }
            }
            Collections.swap(sortedChemicals, i, index);
        }
        
        return sortedChemicals;
    }
    public List<Element> sortElements(){
        List<Element> elements = new ArrayList();
        
        if(!chemicals.isEmpty()){
            //sift out elements
            for(Chemical x : chemicals){
                if(x instanceof Element){
                    elements.add((Element)x);
                }
            }

            //sort elements by atomic number
            int index;
            for(int i = elements.size()-1; i >= 1; i--){
                index = i;
                for(int j = 0; j <= i; j++){
                    if(elements.get(j).getNuclearProp().getNumProton() > elements.get(index).getNuclearProp().getNumProton()){
                        index = j;
                    }
                }
                Collections.swap(elements, i, index);
            }

            //insert unknown elements where missing atomic numbers exist
            for(int i = 0; i < elements.get(elements.size()-1).getNumProton(); i++){
                if(elements.get(i).getNumProton() != i + 1)
                    elements.add(i, PeriodicTable.getUNKNOWN_ELEMENT());
            }
        }
        
        return elements;
    }
    
    //checking for repeats
    public boolean numProtonRepeats(int numProtonToCheck){
        List<Element> sortedElements = this.sortElements();
        for(int i = 0; i < sortedElements.size(); i++){
            if(sortedElements.get(i).getNumProton() == numProtonToCheck)
                return true;
        }
        return false;
    }
    public boolean commonNameRepeats(String nameToCheck){
        nameToCheck = nameToCheck.toLowerCase().trim();
        for(int i = 0; i < chemicals.size(); i++){
            if(chemicals.get(i).getCommonName().toLowerCase().trim().equals(nameToCheck))
                return true;
        }
        return false;
    }
    public boolean elementMolecularFormulaRepeats(String formulaToCheck){
        List<Element> sortedElements = this.sortElements();
        for(int i = 0; i < sortedElements.size(); i++){
            if(sortedElements.get(i).getAtomicSymbol().equals(formulaToCheck))
                return true;
        }
        return false;
    }
    
    //Checks if a reaction created a new product
    public boolean isNewReaction(Reaction reaction) {
        BinaryCompound tempChem = reaction.getProduct();
        for(int i = 0; i < chemicals.size(); i++) {
            if (chemicals.get(i) instanceof BinaryCompound) {
                if(tempChem.equals((BinaryCompound)chemicals.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    //returns a list of a specified object
    public List<BinaryCompound> listBinaryCompounds(){
        List<BinaryCompound> compounds = new ArrayList();
        
        for(int i = 0; i < chemicals.size(); i++){
            if(chemicals.get(i) instanceof BinaryCompound)
                compounds.add((BinaryCompound)chemicals.get(i));
        }
        
        return compounds;
    }
    public List<Reaction> listReactions(){
        return reactionManager.getReactionList();
    }
    
    //updating/creating periodicTable
    public void updateTable() {
        //System.out.println(this.periodicTable);
        this.periodicTable = new PeriodicTable(this.periodicTable.getFirstValence(), this.periodicTable.getIncrement(), this.sortElements());
    }
    
    //returns a randomized permutation of the characters of a chemical name
    public String[] chemicalNamePermutation(){
        int random;
        String[] nameAndPermutation = new String[2];
        List<String> scrambledNames = new ArrayList();

        random = (int)(Math.random() * this.chemicals.size());
        nameAndPermutation[0] = this.chemicals.get(random).getCommonName().toLowerCase();

        permuteString(DatabaseGUI.EMPTY_STRING, nameAndPermutation[0], scrambledNames);
        random = (int)(Math.random() * scrambledNames.size());
        nameAndPermutation[1] = scrambledNames.get(random);

        return nameAndPermutation;
    }
    private void permuteString(String soFar, String used, List<String> scrambledNames){
        if(used.length() == 0){
           scrambledNames.add(soFar);
           return;
        }
        String repeats = DatabaseGUI.EMPTY_STRING;
        boolean isRepeat;
        char c;
        for(int i = 0; i < used.length(); i++){
            isRepeat = false;
            c = used.charAt(i);
            for(int j = 0; j < repeats.length(); j++){
                if(repeats.charAt(j) == c)
                    isRepeat = true;
            }
            if(!isRepeat){
                permuteString(soFar+c, used.substring(0, i)+used.substring(i+1), scrambledNames);
                repeats += c;
            }
        }
    }
}