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
    protected static final char DEFAULT_STATE = 'n';
    protected static final char SOLID_STATE = 's';
    protected static final char LIQUID_STATE = 'l';
    protected static final char GASEOUS_STATE = 'g';
    protected static final double DEFAULT_DENSITY = 0;
    protected static final double DEFAULT_MOLAR_MASS = 0;
    protected static final double DEFAULT_STATE_CHANGE_TEMP = -2147483648.0;
    protected static final String DEFAULT_COLOUR = "unknown";
    protected static final String DEFAULT_MOLECULAR_FORMULA = "unknown";
    
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
    public static char getSOLID_STATE(){
        return SOLID_STATE;
    }
    public static char getLIQUID_STATE(){
        return LIQUID_STATE;
    }
    public static char getGASEOUS_STATE(){
        return GASEOUS_STATE;
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
        if (stpState == SOLID_STATE || stpState == LIQUID_STATE || stpState == GASEOUS_STATE)
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
        if(bp > DEFAULT_STATE_CHANGE_TEMP && bp >= this.mp)
            this.bp = bp;
        else
            this.bp = DEFAULT_STATE_CHANGE_TEMP;
    }
    
    public double getMP() {
        return this.mp;
    }
    public void setMP(double mp) {
        if(mp > DEFAULT_STATE_CHANGE_TEMP && mp <= this.bp)
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
    
    public char calculateState(){
        if(this.mp == DEFAULT_STATE_CHANGE_TEMP && this.bp == DEFAULT_STATE_CHANGE_TEMP)
            return DEFAULT_STATE;
        else if(this.mp > ChemicalDatabase.STANDARD_TEMPERATURE)
            return SOLID_STATE;
        else if(this.bp < ChemicalDatabase.STANDARD_TEMPERATURE)
            return GASEOUS_STATE;
        else
            return LIQUID_STATE;
    }
    
    public void addReaction(Reaction newReaction) {
        this.reactionsInvolved.add(newReaction);
    }
    
    public boolean equals(Chemical other){
        return this.commonName.equals(other.commonName);
    }
    
    public abstract String toString();
    
}
