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
    
    private List<BinaryCompound> compoundsInvolved;
    private NuclearProperties nuclearProp; //aggregated
    private String atomicSymbol;
    private int oxidationNum; //initialized in PeriodicTable, not in Element's constructor
    private Period periodIn; //initialized in PeriodicTable, not in Element's constructor
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public List<BinaryCompound> getCompoundsInvolved() {
        return this.compoundsInvolved;
    }
    public void setCompoundsInvolved(List<BinaryCompound> compoundsInvolved) {
        this.compoundsInvolved = compoundsInvolved;
    }
    
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
            return this.nuclearProp.getNumNeutron();
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
        return this.atomicSymbol;
    }
    public void setMolecularFormula(String formula) {
        if (!formula.contains(DatabaseGUI.SPACE)) 
            this.atomicSymbol = formula;
        else
            this.atomicSymbol = DEFAULT_MOLECULAR_FORMULA;
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
    
    public Element(Element other) {
        //Fields in Chemical
        this.setCommonName(other.getCommonName());
        this.setStpDensity(other.getStpDensity());
        this.setMolarMass(other.getMolarMass());
        this.setBP(other.getBP());
        this.setMP(other.getMP());
        this.stpState = this.calculateState();
        this.setColour(other.getColour());
        this.reactionsInvolved = new ArrayList();
        
        //Fields in Element
        this.nuclearProp = new NuclearProperties(other.getNumProton(), other.getNumProton(), other.getNumNeutron(), other.getIonizationEnergy(), other.getElectronegativity()); //numElectron is set to numProton because chemistry
        this.setMolecularFormula(other.getMolecularFormula());
        this.compoundsInvolved = new ArrayList();
    }
    
    public Element(String commonName, double stpDensity, double molarMass, double bp, double mp, String colour, int numProton, int numNeutron, double ionizationEnergy, double electronegativity, String molecularFormula) {
        //Fields in Chemical
        this.setCommonName(commonName);
        this.setStpDensity(stpDensity);
        this.setMolarMass(molarMass);
        this.setBP(bp);
        this.setMP(mp);
        this.stpState = this.calculateState();
        this.setColour(colour);
        this.reactionsInvolved = new ArrayList();
        
        //Fields in Element
        this.nuclearProp = new NuclearProperties(numProton, numProton, numNeutron, ionizationEnergy, electronegativity); //numElectron is set to numProton because chemistry
        this.setMolecularFormula(molecularFormula);
        this.compoundsInvolved = new ArrayList();
    }
    
    ///
    //METHODS
    ///
    
    public String toString() {
        String output = "";

        output += this.commonName + "\n";
        output += this.stpDensity + "\n";
        output += this.molarMass + "\n";
        output += this.bp + "\n";
        output += this.mp + "\n";
        output += this.colour + "\n";
        output += this.nuclearProp.toString();
        output += this.atomicSymbol + "\n";

        //reactionsInvolved handled in Chemical Database file output
        //oxidation # and periodIn do not need to be saved since they are determined upon initialization

        return output;
    }
    
}
