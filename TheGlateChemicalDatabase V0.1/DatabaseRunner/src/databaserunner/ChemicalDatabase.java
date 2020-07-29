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
    
    private static final double DEFAULT_STATE_CHANGE_TEMP = -273.15;
    
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
    
    public ChemicalDatabase(String fileName, int firstValence, int increment) {
        this.chemicals = new ArrayList();
        this.load(fileName, firstValence, increment);
        this.reactionManager = new ReactionManager();
        this.madeChanges = false;
    }
    
    ///
    //METHODS
    ///
    
    //unique numProton, commonName, molecularFormula
    public boolean load(String fileName, int firstValence, int increment) {
        //hashsets for making sure certain properties are NOT repeated
        HashSet<Integer> numProtonSet = new HashSet();
        HashSet<String> commonNameSet = new HashSet();
        HashSet<String> molecularFormulaSet = new HashSet();
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            
            String line;
            while((line = in.readLine()) != null){
                Chemical newChemical;
                switch (line) {
                    case "element":
                        newChemical = new Element(in.readLine(), in.readLine().charAt(0), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine());
                        
                        int tempNumProton = ((Element)newChemical).getNumProton();
                        if(numProtonSet.contains(tempNumProton))
                            ((Element)newChemical).setNumProton(0);
                        else
                            numProtonSet.add(tempNumProton);
                        
                        break;
                    case "compound":
                        FormulaComponent component1 = null;
                        FormulaComponent component2 = null;
                        
                        newChemical = new BinaryCompound(in.readLine(), in.readLine().charAt(0), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), Double.parseDouble(in.readLine()), in.readLine(), Integer.parseInt(in.readLine()), component1, component2);
                        
                        String componentName1 = in.readLine();
                        int numOccurrence1 = Integer.parseInt(in.readLine());
                        String componentName2 = in.readLine();
                        int numOccurrence2 = Integer.parseInt(in.readLine());
                        
                        component1.setComponent((Element)searchChemicalsByName(componentName1));
                        component1.setNumOccurrence(numOccurrence1);
                        component2.setComponent((Element)searchChemicalsByName(componentName2));
                        component2.setNumOccurrence(numOccurrence2);
                        
                        break;
                    default:
                        newChemical = null;
                        break;
                }
                
                //check duplicate commonName
                String tempCommonName = ((Element)newChemical).getCommonName();
                if(commonNameSet.contains(tempCommonName))
                    ((Element)newChemical).setCommonName("unknown");
                else
                    commonNameSet.add(tempCommonName);
                
                //check duplicate molecularFormula
                String tempMolecularFormula = ((Element)newChemical).getMolecularFormula();
                if(molecularFormulaSet.contains(tempMolecularFormula))
                    ((Element)newChemical).setMolecularFormula("");
                else
                    molecularFormulaSet.add(tempMolecularFormula);
                
                chemicals.add(newChemical);
            }
            in.close();
            
            this.periodicTable = new PeriodicTable(firstValence, increment, this.sortElements());
        } catch(IOException iox) {
            System.out.println("FILE NOT FOUND");
            return false;
        }
        
        return true;
    } 
    
    //MASSIVE LIST WIP
    public boolean save(String fileName) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, false));
            
            for(Chemical x : chemicals){
                out.write("" + x);
            }
            out.close();
        } catch(IOException e) {
            return false;
        }
        
        return true;
    }
    
    //Sorting Methods (Selection Sort)
    public List<Chemical> sortChemicalsByName() {
        List<Chemical> sortedChemicals = new ArrayList(chemicals);
        
        //sort chemicals by name alphabetically
        int index;
        Chemical temp;
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
            if(x.getMP() != DEFAULT_STATE_CHANGE_TEMP){
                sortedChemicals.add(x);
            }
        }
        
        //sort chemicals by melting point (lowest to highest melting point)
        int index;
        Chemical temp;
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
            if(x.getBP() != DEFAULT_STATE_CHANGE_TEMP){
                sortedChemicals.add(x);
            }
        }
        
        //sort chemicals by boiling point (lowest to highest boiling point)
        int index;
        Chemical temp;
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
    public List<Chemical> sortChemicalsByStateAtSTP(char state) {
        List<Chemical> sortedChemicals = new ArrayList();
        
        //sift out valid chemicals
        for(Chemical x : chemicals){
            if(x.getStpState() == state){
                sortedChemicals.add(x);
            }
        }
        
        return sortedChemicals;
    }
    public List<Element> sortElements(){
        List<Element> elements = new ArrayList();
        
        //sift out elements
        for(Chemical x : chemicals){
            if(x instanceof Element){
                elements.add((Element)x);
            }
        }

        //sort elements by atomic number
        int index;
        Element temp;
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
        
        return elements;
    }
    
    public boolean generateGraph(String property) {  //WIP as to what inputs are required
        return false;
        //cuz WIP
    }
    
    //Searching Methods
    public Chemical searchChemicalsByName(String name) {
        for (int i = 0 ; i < chemicals.size() ; i++) {
            if (this.chemicals.get(i).getCommonName().equals(name)) 
                return this.chemicals.get(i);
        }
        return null;
    }
    public int searchChemicalIndicesByName(String name) {  
        for (int i = 0 ; i < chemicals.size() ; i++) {
            if (this.chemicals.get(i).getCommonName().equals(name)) 
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

    public boolean remove(String name) {
        
        Chemical toBeRemoved = searchChemicalsByName(name);
        if(toBeRemoved == null)
            return false;
        
        //Remove Reactions related to element
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
        
        //Remove Element itself & update table
        this.chemicals.remove(searchChemicalIndicesByName(name));
        this.updateTable();
        
        return true;
    }
    
    public boolean update(String name) {
        return false;
        //WIP
    }
    
    public Reaction react(Element reactant1, Element reactant2) {
        return reactionManager.simulateReaction(reactant1, reactant2);
    }
    
    private boolean isNewChemical(Reaction reaction) {
        BinaryCompound tempChem = reaction.getProduct();
        for(int i = 0; i < chemicals.size(); i++) {
            if(chemicals.get(i).equals(tempChem))
                return false;
        }
        chemicals.add(tempChem);
        return true;
    }
    
    //Updating/Creating periodicTable
    public void updateTable() {
        this.periodicTable = new PeriodicTable(this.periodicTable.getFirstValence(), this.periodicTable.getIncrement(), this.sortElements());
    }
    
    public String toString() {
        //NONONO
        return "NO";
    }
    
    public void exit(boolean savedProgress) {
        //do later
    }
    
}
