package databaserunner;

import gui.*;
import java.io.*;

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
    public static void addElement(String commonName, char stpState, double stpDensity, double molarMass, double bp, double mp, String colour, int numProton, int numNeutron, double ionizationEnergy, double electronegativity, String molecularFormula){
        Element newElement = new Element(commonName, stpState, stpDensity, molarMass, bp, mp, colour, numProton, numNeutron, ionizationEnergy, electronegativity, molecularFormula);
        database.getChemicals().add(newElement);
        //update table
    }
    
    //Add Compound functionality
    public static void startAddBinaryCompound(){
        
    }
    public static void addBinaryCompound(){
        
    }
    
    //Remove Chemical functionality
    public static boolean removeChemical(String name){
        boolean removeSuccessful = database.removeChemical(name);
        if(removeSuccessful)
            Home.start();
        return removeSuccessful;
    }
    
    //Search Chemical functionality
    public static void startSearchChemical(){
        
    }
    public static void searchChemical(){
        
    }
    
    //Sort Chemicals functionality
    public static void startSortChemicals(){
        
    }
    public static void sortChemicals(){
        
    }
    
    //List Chemicals functionality
    public static void startListChemicals(){
        
    }
    public static void listChemicals(){
        
    }
    
    //List Reactions functionality
    public static void startListReactions(){
        
    }
    public static void listReactions(){
        
    }
    
    //Simulate Reaction functionality
    public static void startSimulateReaction(){
        
    }
    public static void simulateReaction(){
        
    }
    
}
