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
    
    public ChemicalDatabase(String elementsFile, String binaryCompoundsFile, String reactionsFile, int firstValence, int increment) {
        this.chemicals = new ArrayList();
        this.load(elementsFile, binaryCompoundsFile, reactionsFile, firstValence, increment);
        this.reactionManager = new ReactionManager();
        this.madeChanges = false;
    }
    
    ///
    //METHODS
    ///
    
    //load database from file
    public boolean load(String elementsFile, String binaryCompoundsFile, String reactionsFile, int firstValence, int increment) {
        String line;
        
        try {
            //Load Elements File
            BufferedReader in = new BufferedReader(new FileReader(elementsFile));
            
            while((line = in.readLine()) != null){
                Element newElement = new Element(line, in.readLine().charAt(0), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine());

                line = in.readLine();
                if (!line.equals(Chemical.NO_REACTIONS_INVOLVED)) {
                    //Add temporary array to store reaction indices
                    String[] tempIndexArray = in.readLine().split(" ");
                    List<Reaction> reactionsInvolvedIndices = new ArrayList();

                    for (int i = 0 ; i < tempIndexArray.length ; i++)
                        reactionsInvolvedIndices.add(new Reaction(Integer.parseInt(tempIndexArray[i]), null, null)); 

                    newElement.setReactionsInvolved(reactionsInvolvedIndices);
                }
                
                //check duplicate properties
                if(!(this.numProtonRepeats(newElement.getNumProton()) || this.commonNameRepeats(newElement.getCommonName()) || this.elementMolecularFormulaRepeats(newElement.getMolecularFormula())))
                    chemicals.add(newElement);
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
                FormulaComponent component1 = null;
                FormulaComponent component2 = null;

                BinaryCompound newBinaryCompound = new BinaryCompound(line, in.readLine().charAt(0), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), component1, component2);

                //Find and add component elements
                String componentName1 = in.readLine();
                int numOccurrence1 = Integer.parseInt(in.readLine());
                String componentName2 = in.readLine();
                int numOccurrence2 = Integer.parseInt(in.readLine());

                component1 = new FormulaComponent((Element)searchChemicalsByName(componentName1), numOccurrence1);
                newBinaryCompound.setComponent1(component1);
                component2 = new FormulaComponent((Element)searchChemicalsByName(componentName2), numOccurrence2);
                newBinaryCompound.setComponent2(component2);

                //add temporary array to store reaction indices
                line = in.readLine();
                if (!line.equals(Chemical.NO_REACTIONS_INVOLVED)) {
                    String[] tempIndexArray = in.readLine().split(" ");
                    List<Reaction> reactionsInvolvedIndices = new ArrayList();

                    for (int i = 0 ; i < tempIndexArray.length ; i++)
                        reactionsInvolvedIndices.add(new Reaction(Integer.parseInt(tempIndexArray[i]), null, null)); 

                    newBinaryCompound.setReactionsInvolved(reactionsInvolvedIndices);
                }
                
                //check duplicate commonName
                if(!this.commonNameRepeats(newBinaryCompound.getCommonName()))
                    chemicals.add(newBinaryCompound);
            } 
            in.close();
        }catch(IOException iox){
            System.out.println("Warning: Compounds File NOT FOUND");
        }
            
        try{
            //Load Reactions File
            BufferedReader in = new BufferedReader(new FileReader(reactionsFile));
            
            while((line = in.readLine()) != null){
                Element reactant1 = null;
                Element reactant2 = null;
                
                Reaction newReaction = new Reaction(Integer.parseInt(line), reactant1, reactant2);
                
                reactant1 = (Element)searchChemicalsByName(in.readLine());
                newReaction.setReactant1(reactant1);
                reactant2 = (Element)searchChemicalsByName(in.readLine());
                newReaction.setReactant1(reactant2);
                
                //repeat check done by GUI
                
                this.reactionManager.getReactionList().add(newReaction);
            }
            
        } catch(IOException iox) {
            System.out.println("Warning: Reactions File NOT FOUND");
        }
        
        List<Reaction> tempReactionsInvolved = new ArrayList();

        for (int i = 0 ; i < this.chemicals.size() ; i++) {
            if (!this.chemicals.get(i).reactionsInvolved.isEmpty()) {
                for (int j = 0 ; j < this.chemicals.get(i).reactionsInvolved.size() ; j++) {
                    tempReactionsInvolved.add(this.reactionManager.getReactionList().get(chemicals.get(i).reactionsInvolved.get(j).getID()));
                }
            }
            this.chemicals.get(i).setReactionsInvolved(tempReactionsInvolved);
        }
        
        return true;
    }
    
    //save database to file
    public boolean save(String elementsFile, String binaryCompoundsFile, String reactionsFile) {
        try {
            //Output Element File
            BufferedWriter out = new BufferedWriter(new FileWriter(elementsFile, false));
            
            for(int i = 0 ; i < this.chemicals.size() ; i++){
                if(chemicals.get(i) instanceof Element) {
                    Element outputElement = (Element)chemicals.get(i);
                    int numReactionsInvolved = outputElement.reactionsInvolved.size();
                    
                    out.write(outputElement.toString());
                    
                    //Output reactions as a list of indices of the reactions
                    if (outputElement.reactionsInvolved.isEmpty()) {
                        out.write(Chemical.NO_REACTIONS_INVOLVED + "\n");
                    } else {
                        for(int j = 0 ; j < numReactionsInvolved - 1 ; j++) {
                            out.write(searchReactionIndicesByID(outputElement.reactionsInvolved.get(j).getID()) + " ");
                        }
                        out.write(searchReactionIndicesByID(outputElement.reactionsInvolved.get(numReactionsInvolved - 1).getID()) + "\n");
                    }
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
                    
                    //Output reactions as a list of indices of the reactions
                    if (outputBinaryCompound.reactionsInvolved.isEmpty()) {
                        out.write(Chemical.NO_REACTIONS_INVOLVED + "\n");
                    } else {
                        for(int j = 0 ; j < numReactionsInvolved - 1 ; j++) {
                            out.write(searchReactionIndicesByID(outputBinaryCompound.reactionsInvolved.get(j).getID()) + " ");
                        }
                        out.write(searchReactionIndicesByID(outputBinaryCompound.reactionsInvolved.get(numReactionsInvolved - 1).getID()) + "\n");
                    }
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
    
    //add a new Element
    public boolean addElement(Element newElement){
        if(this.numProtonRepeats(newElement.getNumProton()) || this.commonNameRepeats(newElement.getCommonName()) || this.elementMolecularFormulaRepeats(newElement.getMolecularFormula()))
            return false;
        this.chemicals.add(newElement);
        updateTable();
        return true;
    }
    
    //add a new BinaryCompound
    public boolean addBinaryCompound(BinaryCompound newBinaryCompound){
        if(this.commonNameRepeats(newBinaryCompound.getCommonName()))
            return false;
        this.chemicals.add(newBinaryCompound);
        return true;
    }
    
    //add a new Reaction
    public void addReaction(Reaction newReaction){
        this.reactionManager.addReaction(newReaction);
    }
    
    //remove a chemical specified by its name
    public boolean removeChemical(String name) {
        
        Chemical toBeRemoved = searchChemicalsByName(name);
        if(toBeRemoved == null)
            return false;
        
        //Remove Reactions related to chemical
        int length = reactionManager.getReactionList().size();
        int index;
        for (index = 0 ; index < length ; index++) {
            for (int j = 0 ; j < toBeRemoved.getReactionsInvolved().size() ; j++) {
                if (toBeRemoved.getReactionsInvolved().get(j) == reactionManager.getReactionList().get(index)) {
                    reactionManager.remove(index);
                    index--;
                    length--;
                }
            }
        }
        
        toBeRemoved.deleteReactions();
        
        //Remove Chemical itself & update table
        this.chemicals.remove(toBeRemoved);
        this.updateTable();
        
        return true;
    }
    
    //generate a graph of chemicals & a specified property
    public boolean generateGraph(String property) {  //WIP as to what inputs are required
        return false;
        //cuz WIP
    }
    
    //Searching Methods
    public Reaction searchReactionsByID(int id) {
        Reaction curReaction;
        for (int i = 0 ; i < this.reactionManager.getReactionList().size() ; i++) {
            curReaction = this.reactionManager.getReactionList().get(i);
            if (curReaction.getID() == id)
                return curReaction;
        }
        return null;
    }
    public int searchReactionIndicesByID(int id) {
        Reaction curReaction;
        for (int i = 0 ; i < this.reactionManager.getReactionList().size() ; i++) {
            curReaction = this.reactionManager.getReactionList().get(i);
            if (curReaction.getID() == id)
                return i;
        }
        return -1;
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
        if(formula.equals(""))
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
    
    //Sorting Methods (Selection Sort)
    public List<Chemical> sortChemicalsByName() {
        List<Chemical> sortedChemicals = new ArrayList(chemicals);
        
        //sort chemicals by name alphabetically
        int index;
        for(int i = sortedChemicals.size()-1; i >= 1; i--){
            index = i;
            for(int j = 0; j <= i; j++){
                if(sortedChemicals.get(j).getCommonName().compareTo(sortedChemicals.get(index).getCommonName()) > 0) {
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
        nameToCheck = nameToCheck.toLowerCase();
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
    
    //returns a list of all binary compounds
    public List<BinaryCompound> listBinaryCompounds(){
        List<BinaryCompound> compounds = new ArrayList();
        
        for(int i = 0; i < chemicals.size(); i++){
            if(chemicals.get(i) instanceof BinaryCompound)
                compounds.add((BinaryCompound)chemicals.get(i));
        }
        
        return compounds;
    }
    
    //returns a string array of all reactions
    public String[] listReactions(){
        return reactionManager.listReactions();
    }
    
    public Reaction simulateReaction(Element reactant1, Element reactant2) {
        return reactionManager.simulateReaction(reactant1, reactant2);
    }
    
    public boolean isNewReaction(Reaction reaction) {
        BinaryCompound tempChem = reaction.getProduct();
        for(int i = 0; i < chemicals.size(); i++) {
            if(chemicals.get(i).equals(tempChem))
                return false;
        }
        return true;
    }
    
    //updating/creating periodicTable
    public void updateTable() {
        this.periodicTable = new PeriodicTable(this.periodicTable.getFirstValence(), this.periodicTable.getIncrement(), this.sortElements());
    }
    
}
