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
        if (this.component2 != null) {
            if (component1.getComponent().getElectronegativity() < this.component2.getComponent().getElectronegativity()) {
                this.component1 = component1;
            } else if (component1.getComponent().getElectronegativity() > this.component2.getComponent().getElectronegativity()) {
                this.component1 = this.component2;
                this.component2 = component1;
            } else {
                if (component1.getComponent().getMolecularFormula().compareToIgnoreCase(this.component2.getComponent().getMolecularFormula()) < 0) {
                    this.component1 = component1;
                } else {
                    this.component1 = this.component2;
                    this.component2 = component1;
                }
            }
        } else {
            this.component1 = component1;
        }
    }
    
    public FormulaComponent getComponent2() {
        return this.component2;
    }
    public void setComponent2(FormulaComponent component2) {
        if (this.component1 != null) {
            if (component2.getComponent().getElectronegativity() > this.component1.getComponent().getElectronegativity()) {
                this.component2 = component2;
            } else if (component2.getComponent().getElectronegativity() < this.component1.getComponent().getElectronegativity()) {
                this.component2 = this.component1;
                this.component1 = component2;
            } else {
                if (component2.getComponent().getMolecularFormula().compareToIgnoreCase(this.component1.getComponent().getMolecularFormula()) > 0) {
                    this.component2 = component2;
                } else {
                    this.component2 = this.component1;
                    this.component1 = component2;
                }
            }
        } else {
            this.component2 = component2;
        }
    }
    
    public String getMolecularFormula(){
        return this.molecularFormula;
    }
    public void setMolecularFormula(String molecularFormula){
        this.molecularFormula = molecularFormula;
    }
    
    ///
    //CONSTRUCTORS
    ///
    
    public BinaryCompound(String commonName, double stpDensity, double molarMass, double bp, double mp, String colour, int charge, FormulaComponent component1, FormulaComponent component2) {
        //Fields in Chemical
        this.setCommonName(commonName);
        this.setStpDensity(stpDensity);
        this.setMolarMass(molarMass);
        this.setBP(bp);
        this.setMP(mp);
        this.stpState = this.calculateState();
        this.setColour(colour);
        this.reactionsInvolved = new ArrayList();
        
        //Fields in Compound
        this.setCharge(charge);
        this.setComponent1(component1);
        this.setComponent2(component2);
        this.component1.getComponent().getCompoundsInvolved().add(this);
        this.component2.getComponent().getCompoundsInvolved().add(this);
        this.molecularFormula = this.component1.getComponent().getMolecularFormula() + "-" + this.component1.getNumOccurrence() + "-" + this.component2.getComponent().getMolecularFormula() + "-" + this.component2.getNumOccurrence();
    }
    public BinaryCompound(String commonName, double stpDensity, double bp, double mp, String colour){
        this.setCommonName(commonName);
        this.setStpDensity(stpDensity);
        this.setBP(bp);
        this.setMP(mp);
        this.stpState = this.calculateState();
        this.setColour(colour);
    }
    public BinaryCompound(String commonName){
        this.setCommonName(commonName);
    }
    
    ///
    //METHODS
    ///
    
    public boolean equals(BinaryCompound other) {
        if ((this.component1.getComponent() == other.component1.getComponent() && this.component2.getComponent() == other.component2.getComponent()) || (this.component1.getComponent() == other.component2.getComponent() && this.component2.getComponent() == other.component1.getComponent())) 
            return true;
        return false;
    }
    
    public String toString() {
        String output = "";

        output += this.commonName + "\n";
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
