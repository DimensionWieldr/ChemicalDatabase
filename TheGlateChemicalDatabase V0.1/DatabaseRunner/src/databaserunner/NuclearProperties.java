/*
    NuclearProperties.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: Stores properties for the element class specifically related to its nucleus.
*/

package databaserunner;

public class NuclearProperties {
    
    ///
    //FIELDS
    ///
    
    private static final int MAX_ELECTRONEGATIVITY = 4;
    
    private int numProton;
    private int numElectron;
    private int numNeutron;
    private double ionizationEnergy;
    private double electronegativity;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public int getNumProton() {
        return this.numProton;
    }
    public void setNumProton(int numProton) {
        if (numProton > 0) 
            this.numProton = numProton;
        else
            this.numProton = 0;
    }
    
    public int getNumElectron() {
        return this.numElectron;
    }
    public void setNumElectron(int numElectron) {
        if (numElectron > 0) 
            this.numElectron = numElectron;
        else
            this.numElectron = 0;
    }
    
    public int getNumNeutron() {
        return this.numNeutron;
    }
    public void setNumNeutron(int numNeutron) {
        if (numNeutron >= 0) 
            this.numNeutron = numNeutron;
        else
            this.numNeutron = 0;
    }
        
    public double getIonizationEnergy() {
        return this.ionizationEnergy;    
    }
    public void setIonizationEnergy(double ionizationEnergy) {
        if (ionizationEnergy > 0) 
            this.ionizationEnergy = ionizationEnergy;
        else
            this.ionizationEnergy = 0;
    }
    
    public double getElectronegativity() {
        return this.electronegativity;
    }
    public void setElectronegativity(double electronegativity) {
        if (electronegativity > 0 && electronegativity <= MAX_ELECTRONEGATIVITY)
            this.electronegativity = electronegativity;
        else
            this.electronegativity = 0;
    }
    
    ///
    //CONSTRUCTOR
    ///
    
    public NuclearProperties(int numProton, int numElectron, int numNeutron, double ionizationEnergy, double electronegativity) {
        this.setNumProton(numProton);
        this.setNumElectron(numElectron);
        this.setNumNeutron(numNeutron);
        this.setIonizationEnergy(ionizationEnergy);
        this.setElectronegativity(electronegativity);
    }
    
    ///
    //METHODS
    ///
    
    public String toString() {
        return ""; //WIP
    }
    
}
