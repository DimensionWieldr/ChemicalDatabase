package databaserunner;

import gui.*;

public class DatabaseRunner {
    
    public static void main(String[] args) {
        
        //BUGS
            //Defaults should be displayed as "unknown" *Tied to
                //Edit chemical should also display "unknown" for defaults, however, upon submission, all unknowns have to be re-translated  into the defaults
            //spaces allow you to rename chemical even though it looks the same
                //remove spaces from repeat check       (Ra)
                
        //Style Changes
            //Constants
                //All GUI text need to be constants
                //+ve charge constant
                //Remove gets for constants
            //*Remove logic from GUI (Juju) :(
            //Fix method paramater consistency
        
        //Other Features
            //save on exit (or ask to) & on reload (Ra)
            //after reload, user shouldnt be able to change firstValence & increment unless no reactions & compounds exist (Daniel)
            //load from empty element file (Daniel)
        
        //IM BORED BUTTON FOR RECURSION
            //string permutation
        
        new DatabaseGUI();
    }
    
}
