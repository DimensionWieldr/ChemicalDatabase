/*
    Chemical.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: Abstract superclass of Element & Compound. Stores properties common to all chemicals.
*/

package databaserunner;

import java.util.*;

public abstract class Chemical {
    
    ///
    //FIELDS
    ///
    
    protected static final double DEFAULT_STATE_CHANGE_TEMP = -273.15;
    
    protected String commonName;
    protected char stpState;
    protected double stpDensity;
    protected double molarMass;
    protected double bp; //boiling point
    protected double mp; //melting point
    protected String colour;
    protected List<Reaction> reactionsInvolved;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    /////////////////////////////*#(%@(&^)@$(^$^*)
    //add restrictions, boolean returns (user prompts), constants for defaults
    //same for Element, BinaryCompound, NuclearProperties
    /////////////////////////////(@^($^*$@*(^$@^o^
    
    public String getCommonName() {
        return this.commonName;
    }
    public void setCommonName(String name) {
        this.commonName = name;
    }
    
    public char getStpState() {
        return this.stpState;
    }
    public void setStpState(char stpState) {
        if (stpState == 's' || stpState == 'l' || stpState == 'g')
            this.stpState = stpState;
        else
            this.stpState = ' ';
    }
    
    public double getStpDensity() {
        return this.stpDensity;
    }
    public void setStpDensity(double stpDensity) {
        if (stpDensity > 0) 
            this.stpDensity = stpDensity;
        else
            this.stpDensity = 0;
    }
    
    public double getMolarMass() {
        return this.molarMass;
    }
    public void setMolarMass(double molarMass) {
        if (molarMass > 0) 
            this.molarMass = molarMass;
    }
    
    public double getBP() {
        return this.bp;
    }
    public void setBP(double bp) {
        if(bp > DEFAULT_STATE_CHANGE_TEMP)
            this.bp = bp;
    }
    
    public double getMP() {
        return this.mp;
    }
    public void setMP(double mp) {
        if(mp > DEFAULT_STATE_CHANGE_TEMP)
            this.mp = mp;
    }
    
    public String getColour() {
        return this.colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public List<Reaction> getReactionsInvolved() {
        return this.reactionsInvolved;
    }
    public void setReactionsInvolved(List<Reaction> reactionsInvolved) {
        this.reactionsInvolved = reactionsInvolved;
    }
    
    ///
    //METHODS
    ///
    
    public void deleteReactions() {
        this.reactionsInvolved.clear();
    }
    
    public void addReaction(Reaction newReaction) {
        this.reactionsInvolved.add(newReaction);
    }
    
    public boolean equals(Chemical other){
        return this.commonName.equals(other.commonName) && this.molarMass == other.molarMass;
    }
    
    public abstract String toString();
    
}
