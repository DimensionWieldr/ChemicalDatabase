package databaserunner;

import gui.*;

public class DatabaseRunner {
    
    public static void main(String[] args) {
        //JUJU - i found a lot of bugs LOL
            //all remove methods need to remove reactionsInvolved indexes
            //make sure change chemical has restrictions
                //make sure to check commonName for repeats using commonNameRepeats(String) method in ChemicalDatabase which returns a boolean
        
        //FIX PALINDROME REACTIONS - bue
            //all remove methods need to remove reactionsInvolved indexes
                //remove element needs compoundsInvolved list
                //also needs to remove compoundsInvolved indexes
            //no point in displaying properties that will be default all the time (simulate reaction's product)
                //add text fields to edit the product after simulating a reaction
        
        //IM BORED BUTTON FOR RECURSION (ignore for now, might wanna ask ms lam about this)
            //options: string permutation, crossword, wordsearch, maze
        
        DatabaseGUI databaseGUI = new DatabaseGUI();
    }
    
}
