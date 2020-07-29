package databaserunner;

import gui.*;

public class DatabaseRunner {
    
    public static void main(String[] args) {
        
        //BUGS
            //Defaults should be displayed as "unknown"
                //Edit chemical should also display "unknown" for defaults, however, upon submission, all unknowns have to be re-translated  into the defaults
            //spaces allow you to rename chemical even though it looks the same
                //remove spaces from repeat check
        
        //GUI Changes
            //Change all GUI classes to non-static
                
        //Style Changes
            //fix stringReresentation
            //Protected Constants?
                //Check if here are any more constants we need
            //Fix method paramater consistency
            //change variable name in element from molecular formula to atomic symbol
            //Should methods in GUI classes only be calling methods in Database GUI? *ask lam
                //currently we have things like DatabaseGUI.getDatabase().method()
        
        //Other Features
            //save on exit (or ask to) & on reload
            //after reload, user shouldnt be able to change firstValence & increment unless no reactions & compounds exist
            //load from empty element file
            //double check diatomic compounds (creating, saving, loading, saving, loading, deleting, saving, loading, saving, loading, LOL) *done?
        
        //IM BORED BUTTON FOR RECURSION
            //options: string permutation, crossword, wordsearch, maze
        
        //User Manual/Instructions
        //(or just say some chem knowledge is required, like we assume they know the max and min of certain things)
        
        DatabaseGUI databaseGUI = new DatabaseGUI();
    }
    
}
