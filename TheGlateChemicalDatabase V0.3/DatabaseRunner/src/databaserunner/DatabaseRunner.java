package databaserunner;

import gui.*;

public class DatabaseRunner {
    
    public static void main(String[] args) {
        //JUJU - i found a lot of bugs LOL
            //calculate molar mass properly
            //change molecular formula to somthing else & entered # of neutron != displayed
            //test if entering compound names to reactants section will break things
            //sort chemicals needs to update all values regardless of chemical type
            //state @ stp matching bp/mp
            //remove chemicals does not remove reactions or compounds containing the removed element
            //name sorting toLowerCase()
            //electronegativity restrictions???
            //no poiint in displaying properties that will be default all the time (simulate reaction's product)
        
        //FIX PALINDROME REACTIONS - bue
            //to detect 2 binarycompounds that are the same, use .equals method to compare everything
            //use electronegativity to determine order (make electronegativity required)
            //test long names
            //broken file loading/saving CHECK DISCORD FOR DETAILS (i pinged @glat at 11:22 PM)
        
        //CHANGE CHEMICAL PROPERTIES - ra
            //you want a list of all the chemicals
            //to the right of the list, there should be a section with editable fields that pertain to ALL CHEMICALS
            //IMPORTANT:
                //treat change chemical as if it only edits the fields in Chemical minus molarMass
                //there should be SIX total editable fields on the GUI (for now)
                //more explanation for this when we call again (i did some thinking and we need to talk about it cuz its too complicated to type lol)
            //make sure to check commonName for repeats using commonNameRepeats(String) method in ChemicalDatabase which returns a boolean
        
        //IM BORED BUTTON FOR RECURSION (ignore for now, might wanna ask ms lam about this)
            //options: string permutation, crossword, wordsearch, maze
        
        DatabaseGUI databaseGUI = new DatabaseGUI();
    }
    
}
