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
    
    public static final String DEFAULT_COMMON_NAME = "unknown";
    public static final char DEFAULT_STATE = 'n';
    public static final char SOLID_STATE = 's';
    public static final char LIQUID_STATE = 'l';
    public static final char GASEOUS_STATE = 'g';
    public static final double DEFAULT_DENSITY = 0;
    public static final double DEFAULT_MOLAR_MASS = 0;
    public static final double DEFAULT_STATE_CHANGE_TEMP = -2147483648.0;
    public static final String DEFAULT_COLOUR = "unknown";
    public static final String DEFAULT_MOLECULAR_FORMULA = "unknown";
    
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
    public boolean setCommonName(String commonName) {
        this.commonName = commonName;
        if(commonName.toLowerCase().equals(DEFAULT_COMMON_NAME))
            return false;
        return true;
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
    public boolean setStpDensity(double stpDensity) {
        if (stpDensity >= DEFAULT_DENSITY){
            this.stpDensity = stpDensity;
            return true;
        }
        this.stpDensity = DEFAULT_DENSITY;
        return false;
    }
    
    public double getMolarMass() {
        return this.molarMass;
    }
    public boolean setMolarMass(double molarMass) {
        if (molarMass >= DEFAULT_MOLAR_MASS){
            this.molarMass = molarMass;
            return true;
        }
        this.molarMass = DEFAULT_MOLAR_MASS;
        return false;
    }
    
    public double getBP() {
        return this.bp;
    }
    public boolean setBP(double bp) {
        if(bp >= DEFAULT_STATE_CHANGE_TEMP){
            this.bp = bp;
            return true;
        }
        this.bp = DEFAULT_STATE_CHANGE_TEMP;
        return false;
    }
    
    public double getMP() {
        return this.mp;
    }
    public boolean setMP(double mp) {
        if(mp >= DEFAULT_STATE_CHANGE_TEMP){
            this.mp = mp;
            return true;
        }
        this.mp = DEFAULT_STATE_CHANGE_TEMP;
        return false;
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
        
        if (bp > mp) {
            if(this.mp > ChemicalDatabase.STANDARD_TEMPERATURE)
                return SOLID_STATE;
            else if(this.bp < ChemicalDatabase.STANDARD_TEMPERATURE)
                return GASEOUS_STATE;
            else
                return LIQUID_STATE;
        } else {
            if(this.bp > ChemicalDatabase.STANDARD_TEMPERATURE)
                return SOLID_STATE;
            else
                return GASEOUS_STATE;
        }
    }
    
    public void addReaction(Reaction newReaction) {
        this.reactionsInvolved.add(newReaction);
    }
    
    public boolean equals(Chemical other){
        return this.commonName.equals(other.commonName);
    }
    
    public abstract String toString();
    
}
