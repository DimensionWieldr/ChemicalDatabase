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
    private String molecularFormula;
    
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
    
    public String getMolecularFormula(){
        return this.molecularFormula;
    }
    public void setMolecularFormula(String molecularFormula){
        this.molecularFormula = molecularFormula;
    }
    
    ///
    //CONSTRUCTOR
    ///
    
    public BinaryCompound(String commonName, char stpState, double stpDensity, double molarMass, double bp, double mp, String colour, int charge, FormulaComponent component1, FormulaComponent component2) {
        //Fields in Chemical
        this.setCommonName(commonName);
        this.setStpState(stpState);
        this.setStpDensity(stpDensity);
        this.setMolarMass(molarMass);
        this.setBP(bp);
        this.setMP(mp);
        this.setColour(colour);
        this.reactionsInvolved = new ArrayList();
        
        //Fields in Compound
        this.setCharge(charge);
        this.setComponent1(component1);
        this.setComponent2(component2);
        this.molecularFormula = component1.getComponent().getMolecularFormula() + " " + component1.getNumOccurrence() + " " + component2.getComponent().getMolecularFormula() + " " + component2.getNumOccurrence();
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
        output += this.component1.toString();
        output += this.component2.toString();

        return output;
    }
    
}
