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
    private int oxidationNum;
    private Period periodIn;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
        //START of NUCLEAR PROP Acc/Mut
    
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
    
        //END of NUCLEAR PROP Acc/Mut
    
    public String getMolecularFormula() {
        return this.molecularFormula;
    }
    public void setMolecularFormula(String formula) {
        if (!formula.contains(" ")) 
            this.molecularFormula = formula;
    }
    
    public int getOxidationNum() {
        return this.oxidationNum;
    }
    public void setOxidationNum(int oxidationNum) {
        int upperBound = periodIn.getPeriodLength()/2;
        int lowerBound = -1 * (periodIn.getPeriodLength()/2);
        
        if (oxidationNum > lowerBound && oxidationNum < upperBound) 
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
    
    //fix ifs
    public Element(String commonName, char stpState, double stpDensity, double molarMass, double bp, double mp, String colour, int numProton, int numNeutron, double ionizationEnergy, double electronegativity, String molecularFormula) {
        //Fields in Chemical
        this.setCommonName(commonName);
        this.setStpState(stpState);
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
        
        //Nuclear Properties
        this.nuclearProp = new NuclearProperties(numProton, numProton, numNeutron, ionizationEnergy, electronegativity); 
            //numElectron set to numProton cause chemistry
        
        //Fields in Element
        this.molecularFormula = molecularFormula;
        this.periodIn = new Period();
    }
    
    ///
    //METHODS
    ///
    
    public String toString() {
        return this.molecularFormula;
    }
    
}
