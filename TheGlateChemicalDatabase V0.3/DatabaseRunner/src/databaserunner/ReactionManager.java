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
        Reaction newReaction = new Reaction(reactionList.size(), reactant1, reactant2);
        reactionList.add(newReaction);
        return newReaction;
    }
    
    public void addReaction(Reaction newReaction){
        reactionList.add(newReaction);
    }
    
    public boolean remove(int index) {
        if(index >= 0){
            reactionList.remove(index);
            return true;
        }
        return false;
    }
    
    public String[] listReactions(){
        String[] reactions = new String[reactionList.size()];
        
        for(int i = 0; i < reactions.length; i++){
            reactions[i] = reactionList.get(i).stringRepresentation();
        }
        
        return reactions;
    }
    
}
