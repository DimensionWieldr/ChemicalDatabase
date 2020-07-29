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
    
    public static final int DEFAULT_CHARGE = 0;
    
    public static final String LABEL_CHARGE = "Charge";
    public static final String LABEL_MOLECULAR_FORMULA = "Composition";
    public static final String LABEL_ELEMENT_1 = "A";
    public static final String LABEL_ELEMENT_2 = "B";
    public static final String LABEL_SUBSCRIPT_1 = "a";
    public static final String LABEL_SUBSCRIPT_2 = "b";
    
    public static final int MOLECULAR_FORMULA_ELEMENT_1_NAME = 0;
    public static final int MOLECULAR_FORMULA_ELEMENT_1_OCCURRENCE = 1;
    public static final int MOLECULAR_FORMULA_ELEMENT_2_NAME = 2;
    public static final int MOLECULAR_FORMULA_ELEMENT_2_OCCURRENCE = 3;
    
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
            if (component1.getElement().getElectronegativity() < this.component2.getElement().getElectronegativity()) {
                this.component1 = component1;
            } else if (component1.getElement().getElectronegativity() > this.component2.getElement().getElectronegativity()) {
                this.component1 = this.component2;
                this.component2 = component1;
            } else {
                if (component1.getElement().getAtomicSymbol().compareToIgnoreCase(this.component2.getElement().getAtomicSymbol()) < 0) {
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
            if (component2.getElement().getElectronegativity() > this.component1.getElement().getElectronegativity()) {
                this.component2 = component2;
            } else if (component2.getElement().getElectronegativity() < this.component1.getElement().getElectronegativity()) {
                this.component2 = this.component1;
                this.component1 = component2;
            } else {
                if (component2.getElement().getAtomicSymbol().compareToIgnoreCase(this.component1.getElement().getAtomicSymbol()) > 0) {
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
        
        if (component1.getElement() == component2.getElement()) {
            this.component1.getElement().getCompoundsInvolved().add(this);
            this.molecularFormula = this.component1.getElement().getAtomicSymbol() + DatabaseGUI.WORD_SPLIT + (this.component1.getNumOccurrence() + this.component2.getNumOccurrence());
        } else {
            this.component1.getElement().getCompoundsInvolved().add(this);
            this.component2.getElement().getCompoundsInvolved().add(this);
            this.molecularFormula = this.component1.getElement().getAtomicSymbol() + DatabaseGUI.WORD_SPLIT + this.component1.getNumOccurrence() + DatabaseGUI.WORD_SPLIT + this.component2.getElement().getAtomicSymbol() + DatabaseGUI.WORD_SPLIT + this.component2.getNumOccurrence();
        }
        
    }
    public BinaryCompound(String commonName){
        this.setCommonName(commonName);
    }
    public BinaryCompound(){
        
    }
    
    ///
    //METHODS
    ///
    
    public void removePointers() {
        this.component1.getElement().getCompoundsInvolved().remove(this);
        this.component2.getElement().getCompoundsInvolved().remove(this);
    }
    
    public boolean equals(BinaryCompound other) {
        if ((this.component1.getElement() == other.component1.getElement() && this.component2.getElement() == other.component2.getElement()) || (this.component1.getElement() == other.component2.getElement() && this.component2.getElement() == other.component1.getElement())) 
            return true;
        return false;
    }
    
    public String toString() {
        String output = DatabaseGUI.EMPTY_STRING;

        output += this.commonName + DatabaseGUI.LINE_BREAK;
        output += this.stpDensity + DatabaseGUI.LINE_BREAK;
        output += this.molarMass + DatabaseGUI.LINE_BREAK;
        output += this.bp + DatabaseGUI.LINE_BREAK;
        output += this.mp + DatabaseGUI.LINE_BREAK;
        output += this.colour + DatabaseGUI.LINE_BREAK;
        output += this.charge + DatabaseGUI.LINE_BREAK;
        output += this.component1.toString();
        output += this.component2.toString();

        return output;
    }
}