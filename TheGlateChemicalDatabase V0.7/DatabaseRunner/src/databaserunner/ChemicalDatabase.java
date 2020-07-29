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
    private boolean madeChanges;
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
    
    public boolean getMadeChanges() {
        return this.madeChanges;
    }
    public void setMadeChanges(boolean madeChanges) {
        this.madeChanges = madeChanges;
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
        this.madeChanges = false;
    }
    
    ///
    //METHODS
    ///
    
    //File I/O
    public boolean load(String elementsFile, String binaryCompoundsFile, String reactionsFile, int firstValence, int increment) {
        String line;
        
        try {
            //Load Elements File
            BufferedReader in = new BufferedReader(new FileReader(elementsFile));
            
            while((line = in.readLine()) != null){
                Element newElement = new Element(line, Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine());
                this.addElement(newElement);
            }
            in.close();
            
            this.periodicTable = new PeriodicTable(firstValence, increment, this.sortElements());
        }catch(IOException iox){
            return false;
        }
        
        try{
            //Load Binary Compound File
            BufferedReader in = new BufferedReader(new FileReader(binaryCompoundsFile));
            
            while((line = in.readLine()) != null){
                BinaryCompound newBinaryCompound = new BinaryCompound(line, Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), new FormulaComponent((Element)searchChemicalsByName(in.readLine()), Integer.parseInt(in.readLine())), new FormulaComponent((Element)searchChemicalsByName(in.readLine()), Integer.parseInt(in.readLine())));
                this.addBinaryCompound(newBinaryCompound);
            } 
            in.close();
        }catch(IOException iox){
            System.out.println("Warning: Compounds File NOT FOUND");
        }
            
        try{
            //Load Reactions File
            BufferedReader in = new BufferedReader(new FileReader(reactionsFile));
            
            while((line = in.readLine()) != null){
                Reaction newReaction = new Reaction(Integer.parseInt(line), (Element)searchChemicalsByName(in.readLine()), (Element)searchChemicalsByName(in.readLine()), (BinaryCompound)searchChemicalsByName(in.readLine()));
                this.reactionManager.getReactionList().add(newReaction);
            }
            
        } catch(IOException iox) {
            System.out.println("Warning: Reactions File NOT FOUND");
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
        if(this.numProtonRepeats(newElement.getNumProton()) || this.commonNameRepeats(newElement.getCommonName()) || this.elementMolecularFormulaRepeats(newElement.getMolecularFormula()))
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
        this.removeChemical(elementToBeEdited.getCommonName());
        
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
    
    //remove a chemical specified by its name
    public boolean removeChemical(String name) {
        Chemical toBeRemoved = searchChemicalsByName(name);
        if(toBeRemoved == null) {
             
            return false;}

        if (toBeRemoved instanceof Element) {
            Element elementToBeRemoved = (Element)toBeRemoved;
            int length = elementToBeRemoved.getCompoundsInvolved().size();
            for (int i = 0 ; i < length ; i++) {
                this.removeChemical(elementToBeRemoved.getCompoundsInvolved().get(0).getCommonName());
            }
        }

        if (toBeRemoved instanceof BinaryCompound) {
            
            BinaryCompound compoundToBeRemoved = (BinaryCompound)toBeRemoved;
            compoundToBeRemoved.getComponent1().getComponent().getCompoundsInvolved().remove(compoundToBeRemoved);
            compoundToBeRemoved.getComponent2().getComponent().getCompoundsInvolved().remove(compoundToBeRemoved);
        }
        
        
        
        //Remove Reactions related to chemical
        int length = toBeRemoved.getReactionsInvolved().size();
        for (int i = 0 ; i < length ; i++) {
            this.reactionManager.removeByIndex(toBeRemoved.getReactionsInvolved().get(0).getID());
        }
                
        this.chemicals.remove(toBeRemoved);
       
        
        return true;
    }
    //remove a reaction by its index/ID
    public void removeReaction(int index){
        if(index >= 0){
            //If we are to expand reaction so that compounds can create more complicated reactions
            //we would need to check that the product was not created by any other reactions before we remove it.
            //However since our current reaction algorithm only allows for one unique reaction combo for each product
            //we can safely remove the entire reaction + product all the time.
            this.removeChemical(this.reactionManager.getReactionList().get(index).getProduct().getCommonName());
        }
    }
    
    //Searching Methods
    public Reaction searchReactionsByID(int id) {
        return this.reactionManager.searchReactionsByID(id);
    }
    public int searchReactionIndicesByID(int id) {
        return this.reactionManager.searchReactionIndicesByID(id);
    }
    public Chemical searchChemicalsByName(String name) {
        Chemical curChemical;
        for (int i = 0 ; i < chemicals.size() ; i++) {
            curChemical = this.chemicals.get(i);
            if (curChemical.getCommonName().toLowerCase().equals(name.toLowerCase())) 
                return curChemical;
        }
        return null;
    }
    public int searchChemicalIndicesByName(String name) {
        Chemical curChemical;
        for (int i = 0 ; i < chemicals.size() ; i++) {
            curChemical = this.chemicals.get(i);
            if (curChemical.getCommonName().toLowerCase().equals(name.toLowerCase())) 
                return i;
        }
        return -1;
    }
    public Element searchElementByMolecularFormula(String formula){
        Element curElement;
        for (int i = 0 ; i < chemicals.size() ; i++) {
            if (this.chemicals.get(i) instanceof Element) {
                curElement = (Element)this.chemicals.get(i);
                if (curElement.getMolecularFormula().equals(formula))
                    return curElement;
            }
        }
        if(formula.equals(Chemical.DEFAULT_MOLECULAR_FORMULA))
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
        nameToCheck = nameToCheck.toLowerCase().replaceAll(DatabaseGUI.SPACE, DatabaseGUI.EMPTY_STRING);
        for(int i = 0; i < chemicals.size(); i++){
            if(chemicals.get(i).getCommonName().toLowerCase().equals(nameToCheck))
                return true;
        }
        return false;
    }
    public boolean elementMolecularFormulaRepeats(String formulaToCheck){
        List<Element> sortedElements = this.sortElements();
        for(int i = 0; i < sortedElements.size(); i++){
            if(sortedElements.get(i).getMolecularFormula().equals(formulaToCheck))
                return true;
        }
        return false;
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
    
    //returns a list of all reactions
    public List<Reaction> listReactions(){
        return reactionManager.getReactionList();
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
    
    //updating/creating periodicTable
    public void updateTable() {
        this.periodicTable = new PeriodicTable(this.periodicTable.getFirstValence(), this.periodicTable.getIncrement(), this.sortElements());
    }
    
}
