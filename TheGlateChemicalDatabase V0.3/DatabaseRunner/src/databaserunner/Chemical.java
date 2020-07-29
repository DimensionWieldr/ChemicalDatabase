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
    
    protected static final String DEFAULT_COMMON_NAME = "unknown";
    protected static final char DEFAULT_STATE = ' ';
    protected static final double DEFAULT_DENSITY = 0;
    protected static final double DEFAULT_MOLAR_MASS = 0;
    protected static final double DEFAULT_STATE_CHANGE_TEMP = -273.15;
    protected static final String DEFAULT_COLOUR = "";
    protected static final String DEFAULT_MOLECULAR_FORMULA = "";
    protected static final String NO_REACTIONS_INVOLVED = "No Reactions";
    
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
    
    //* IN CHEMICAL, ELEMENT, NUCLEAR PROPERTIES, & BINARY COMPOUND
    //* Whenever a default setting is used due to a restriction violation:
        //* Add boolean returns which should cause GUI notifications.
    //* (need to ensure user cannot enter wrong data types as well... just a GUI thing?)
    
    //Constants
    public static String getDEFAULT_COMMON_NAME(){
        return DEFAULT_COMMON_NAME;
    }
    public static char getDEFAULT_STATE(){
        return DEFAULT_STATE;
    }
    public static double getDEFAULT_DENSITY(){
        return DEFAULT_DENSITY;
    }
    public static double getDEFAULT_MOLAR_MASS(){
        return DEFAULT_MOLAR_MASS;
    }
    public static double getDEFAULT_STATE_CHANGE_TEMP(){
        return DEFAULT_STATE_CHANGE_TEMP;
    }
    public static String getDEFAULT_COLOUR(){
        return DEFAULT_COLOUR;
    }
    public static String getDEFAULT_MOLECULAR_FORMULA(){
        return DEFAULT_MOLECULAR_FORMULA;
    }
    
    //Variables
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
            this.stpState = DEFAULT_STATE;
    }
    
    public double getStpDensity() {
        return this.stpDensity;
    }
    public void setStpDensity(double stpDensity) {
        if (stpDensity > 0) 
            this.stpDensity = stpDensity;
        else
            this.stpDensity = DEFAULT_DENSITY;
    }
    
    public double getMolarMass() {
        return this.molarMass;
    }
    public void setMolarMass(double molarMass) {
        if (molarMass > 0) 
            this.molarMass = molarMass;
        else
            this.molarMass = DEFAULT_MOLAR_MASS;
    }
    
    public double getBP() {
        return this.bp;
    }
    public void setBP(double bp) {
        if(bp > DEFAULT_STATE_CHANGE_TEMP)
            this.bp = bp;
        else
            this.bp = DEFAULT_STATE_CHANGE_TEMP;
    }
    
    public double getMP() {
        return this.mp;
    }
    public void setMP(double mp) {
        if(mp > DEFAULT_STATE_CHANGE_TEMP)
            this.mp = mp;
        else
            this.mp = DEFAULT_STATE_CHANGE_TEMP;
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
        return this.commonName.equals(other.commonName);
    }
    
    public abstract String toString();
    
}
