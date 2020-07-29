/*
    Element.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: Stores element-specific properties.
*/

package databaserunner;

import java.util.*;

public class Element extends Chemical {
    
    ///
    //FIELDS
    ///
    
    private NuclearProperties nuclearProp; //aggregated
    private String molecularFormula;
    private int oxidationNum; //initialized in PeriodicTable, not in Element's constructor
    private Period periodIn; //initialized in PeriodicTable, not in Element's constructor
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    //start of NuclearProperties accessors & mutators
    public NuclearProperties getNuclearProp() {
        return this.nuclearProp;
    }
    public void setNuclearProp(NuclearProperties nuclearProp) {
        this.nuclearProp = nuclearProp;
    }
    
        public int getNumProton() {
            return this.nuclearProp.getNumProton();
        }
        public void setNumProton(int numProton) {
            this.nuclearProp.setNumProton(numProton);
        }

        public int getNumElectron() {
            return this.nuclearProp.getNumElectron();
        }
        public void setNumElectron(int numElectron) {
            this.nuclearProp.setNumElectron(numElectron);
        }

        public int getNumNeutron() {
            return this.nuclearProp.getNumElectron();
        }
        public void setNumNeutron(int numNeutron) {
            this.nuclearProp.setNumNeutron(numNeutron);
        }

        public double getIonizationEnergy() {
            return this.nuclearProp.getIonizationEnergy();  
        }
        public void setIonizationEnergy(double ionizationEnergy) {
             this.nuclearProp.setIonizationEnergy(ionizationEnergy);
        }

        public double getElectronegativity() {
            return this.nuclearProp.getElectronegativity(); 
        }
        public void setElectronegativity(double electronegativity) {
            this.nuclearProp.setElectronegativity(electronegativity);
        }
    //end of NuclearProperties accessors & mutators
    
    public String getMolecularFormula() {
        return this.molecularFormula;
    }
    public void setMolecularFormula(String formula) {
        if (!formula.contains(" ")) 
            this.molecularFormula = formula;
        else
            this.molecularFormula = DEFAULT_MOLECULAR_FORMULA;
    }
    
    public int getOxidationNum() {
        return this.oxidationNum;
    }
    public void setOxidationNum(int oxidationNum) {
        this.oxidationNum = oxidationNum;
    }
    
    public Period getPeriodIn() {
        return this.periodIn;
    }
    public void setPeriodIn(Period periodIn) {
        this.periodIn = periodIn;
    }
    
    ///
    //CONSTRUCTOR
    ///
    
    public Element(String commonName, char stpState, double stpDensity, double molarMass, double bp, double mp, String colour, int numProton, int numNeutron, double ionizationEnergy, double electronegativity, String molecularFormula) {
        //Fields in Chemical
        this.setCommonName(commonName);
        this.setStpState(stpState);
        this.setStpDensity(stpDensity);
        this.setMolarMass(molarMass);
        this.setBP(bp);
        this.setMP(mp);
        this.setColour(colour);
        this.reactionsInvolved = new ArrayList();
        
        //Fields in Element
        this.nuclearProp = new NuclearProperties(numProton, numProton, numNeutron, ionizationEnergy, electronegativity); //numElectron is set to numProton because chemistry
        this.setMolecularFormula(molecularFormula);
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
        output += this.nuclearProp.toString();
        output += this.molecularFormula + "\n";

        //reactionsInvolved handled in Chemical Database file output
        //oxidation # and periodIn do not need to be saved since they are determined upon initialization

        return output;
    }
    
}
