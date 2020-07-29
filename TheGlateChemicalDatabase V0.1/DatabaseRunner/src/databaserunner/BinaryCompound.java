/*
    BinaryCompound.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: Stores compound-specific properties.
*/

package databaserunner;

import java.util.*;

public class BinaryCompound extends Chemical {
    
    ///
    //FIELDS
    ///
    
    private int charge; 
    private FormulaComponent component1;
    private FormulaComponent component2;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public int getCharge() {
        return charge; 
    } 
    public void setCharge(int charge) {
        this.charge = charge;
    }
    
    public FormulaComponent getComponent1() {
        return this.component1;
    }
    public void setComponent1(FormulaComponent component1) {
        this.component1 = component1;
    }
    
    public FormulaComponent getComponent2() {
        return this.component2;
    }
    public void setComponent2(FormulaComponent component2) {
        this.component2 = component2;
    }
    
    ///
    //CONSTRUCTOR
    ///
    
    public BinaryCompound(String commonName, char stpState, double stpDensity, double molarMass, double bp, double mp, String colour, int charge, FormulaComponent component1, FormulaComponent component2) {
        //Fields in Chemical
        this.commonName = commonName;
        this.stpState = stpState;
        if (stpDensity > 0)
            this.stpDensity = stpDensity;
        if (molarMass > 0)
            this.molarMass = molarMass;
        if(bp > DEFAULT_STATE_CHANGE_TEMP)
            this.bp = bp;
        if(mp > DEFAULT_STATE_CHANGE_TEMP)
            this.mp = mp;
        this.colour = colour;
        this.reactionsInvolved = new ArrayList();
        
        //Fields in Compound
        this.charge = charge;
        this.component1 = component1;
        this.component2 = component2;
    }
    
    ///
    //METHODS
    ///
    
    public String toString() {
        String output = "";
        
        output += this.commonName + "\n";
        output += this.stpState + "\n";
        output += this.stpDensity + "\n";
        output += this.molarMass + "\n";
        output += this.bp + "\n";
        output += this.mp + "\n";
        output += this.colour + "\n";
        output += this.charge + "\n";
        //WIP
        
        return output;
    }
    
}
