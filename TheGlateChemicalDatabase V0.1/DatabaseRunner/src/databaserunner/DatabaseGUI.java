package databaserunner;

import gui.*;

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
    
    public static void constructDatabase(String fileName, int firstValence, int increment){
        database = new ChemicalDatabase(fileName, firstValence, increment);
        Home.start();
    }
    
    public static void returnHome(){
        Home.start();
    }
    
}
