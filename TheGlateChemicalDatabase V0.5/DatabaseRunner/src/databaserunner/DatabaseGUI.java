package databaserunner;

import gui.*;
import java.io.*;
import java.util.*;

public class DatabaseGUI {
    
    ///
    //FIELDS
    ///
    
    private static ChemicalDatabase database;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public static ChemicalDatabase getDatabase(){
        return database;
    }
    public static void setDatabase(ChemicalDatabase newDatabase){
        database = newDatabase;
    }
    
    ///
    //CONSTRUCTOR
    ///
    
    public DatabaseGUI(){
        Start.start();
    }
    
    ///
    //METHODS
    ///
    
    //Start/Submit functionality
    public static boolean constructDatabase(String elementsFile, String binaryCompoundsFile, String reactionsFile, int firstValence, int increment){
        try{
            BufferedReader in = new BufferedReader(new FileReader(elementsFile));
            //main file exists, so continue
            database = new ChemicalDatabase(elementsFile, binaryCompoundsFile, reactionsFile, firstValence, increment);
            Home.start();
            return true;
        }catch(IOException iox){
            //file does not exist, so abort
            return false;
        }
    }
    
    //Add Element functionality
    public static void startAddElement(){
        AddElement.start();
    }
    public static boolean addElement(Element newElement){
        return database.addElement(newElement);
    }
    
    //Remove Chemical functionality
    public static boolean removeChemical(String name){
        boolean removeSuccessful = database.removeChemical(name);
        if(removeSuccessful)
            Home.start();
        return removeSuccessful;
    }
    
    //Sort Chemicals functionality
    public static void startSortChemicals(){
        SortChemicals.start();
    }
    public static List<Chemical> sortChemicalsByName(){
        return database.sortChemicalsByName();
    }
    public static List<Chemical> sortChemicalsByMolarMass(){
        return database.sortChemicalsByMolarMass();
    }
    public static List<Chemical> sortChemicalsByMeltingPoint(){
        return database.sortChemicalsByMeltingPoint();
    }
    public static List<Chemical> sortChemicalsByBoilingPoint(){
        return database.sortChemicalsByBoilingPoint();
    }
    public static List<Chemical> sortChemicalsByStpDensity(){
        return database.sortChemicalsByStpDensity();
    }
    public static List<Chemical> sortChemicalsByStpState(char property){
        return database.sortChemicalsByStpState(property);
    }
    
    //List Compounds functionality
    public static void startListBinaryCompounds(){
        ListBinaryCompounds.start();
    }
    public static List<BinaryCompound> listBinaryCompounds(){
        return database.listBinaryCompounds();
    }
    
    //List Reactions functionality
    public static void startListReactions(){
        ListReactions.start();
    }
    public static String[] listReactions(){
        return database.listReactions();
    }
    public static void removeReaction(int index){
        database.removeReaction(index);
        ListReactions.start();
    }
    
    //Simulate Reaction functionality
    public static void startSimulateReaction(){
        SimulateReaction.start();
    }
    public static Reaction simulateReaction(Element reactant1, Element reactant2){
        return database.simulateReaction(reactant1, reactant2);
    }
    
    //Edit Chemical functionality
    public static void startEditChemicals(){
        EditChemicals.start();
    }
    public static boolean editElements(Element search, String commonName, double stpDensity, double bp, double mp, String colour, String molecularFormula, int numProton, double electronegativity, int numNeutron, double molarMass, double ionizationEnergy){
        return database.editElements(search, commonName, stpDensity, bp, mp, colour, molecularFormula, numProton, electronegativity, numNeutron, molarMass, ionizationEnergy);
    }
    public static boolean editBinaryCompounds(BinaryCompound search, String commonName, double stpDensity, double bp, double mp, String colour){
        return database.editBinaryCompounds(search, commonName, stpDensity, bp, mp, colour);
    }
    
}
