/*
    ReactionManager.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: Stores list of all reactions that have occurred.
*/

package databaserunner;

import java.util.*;

public class ReactionManager {
    
    ///
    //FIELDS
    ///
    
    private List<Reaction> reactionList;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public List<Reaction> getReactionList() {
        return reactionList;
    }
    public void setReactionlist(List<Reaction> reactionList) {
        this.reactionList = reactionList;
    }
    
    ///
    //CONSTRUCTOR
    ///
    
    public ReactionManager() {
        reactionList = new ArrayList();
    }
    
    ///
    //METHODS
    ///
    
    public Reaction simulateReaction(Element reactant1, Element reactant2) {
        Reaction newReaction = new Reaction(reactant1, reactant2, reactionList.size());
        reactionList.add(newReaction);
        return newReaction;
    }
    
    public boolean remove(int index) {
        if(index >= 0){
            reactionList.remove(index);
            return true;
        }
        return false;
    }
        
    public String toString() {
        String s = "";
        for (int i = 0; i < reactionList.size(); i++) {
            s = s + reactionList.get(i);
        }
        return s;
    }
    
}
