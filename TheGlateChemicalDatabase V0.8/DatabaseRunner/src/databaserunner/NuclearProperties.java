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
    
    public static final int DEFAULT_PROTONS = 0;
    public static final int DEFAULT_ELECTRONS = 0;
    public static final int DEFAULT_NEUTRONS = 0;
    public static final double DEFAULT_IONIZATION_ENERGY = 0;
    public static final double MIN_ELECTRONEGATIVITY = 0;
    public static final double MAX_ELECTRONEGATIVITY = 4;
    
    private int numProton;
    private int numElectron;
    private int numNeutron;
    private double ionizationEnergy;
    private double electronegativity;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    //Constants
    public static int getDEFAULT_PROTONS(){
        return DEFAULT_PROTONS;
    }
    public static int getDEFAULT_ELECTRONS(){
        return DEFAULT_ELECTRONS;
    }
    public static int getDEFAULT_NEUTRONS(){
        return DEFAULT_NEUTRONS;
    }
    public static double getDEFAULT_IONIZATION_ENERGY(){
        return DEFAULT_IONIZATION_ENERGY;
    }
    public static double MIN_ELECTRONEGATIVITY(){
        return MIN_ELECTRONEGATIVITY;
    }
    public static double MAX_ELECTRONEGATIVITY(){
        return MAX_ELECTRONEGATIVITY;
    }
    
    //Variables
    public int getNumProton() {
        return this.numProton;
    }
    public boolean setNumProton(int numProton) {
        if (numProton > 0){
            this.numProton = numProton;
            return true;
        }
        this.numProton = DEFAULT_PROTONS;
        return false;
    }

    public int getNumElectron() {
        return this.numElectron;
    }
    public void setNumElectron(int numElectron) {
        if (numElectron > 0) 
            this.numElectron = numElectron;
        else
            this.numElectron = DEFAULT_ELECTRONS;
    }

    public int getNumNeutron() {
        return this.numNeutron;
    }
    public boolean setNumNeutron(int numNeutron) {
        if (numNeutron >= 0){
            this.numNeutron = numNeutron;
            return true;
        }
        this.numNeutron = DEFAULT_NEUTRONS;
        return false;
    }

    public double getIonizationEnergy() {
        return this.ionizationEnergy;
    }
    public boolean setIonizationEnergy(double ionizationEnergy) {
        if (ionizationEnergy >= 0){
            this.ionizationEnergy = ionizationEnergy;
            return true;
        }
        this.ionizationEnergy = DEFAULT_IONIZATION_ENERGY;
        return false;
    }

    public double getElectronegativity() {
        return this.electronegativity;
    }
    public boolean setElectronegativity(double electronegativity) {
        if (electronegativity >= MIN_ELECTRONEGATIVITY && electronegativity <= MAX_ELECTRONEGATIVITY){
            this.electronegativity = electronegativity;
            return true;
        }
        this.electronegativity = MIN_ELECTRONEGATIVITY;
        return false;
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
    public NuclearProperties() {
        
    }
    
    ///
    //METHODS
    ///
    
    public String toString() {
        String output = ""; 

        output += this.numProton + "\n";
        output += this.numNeutron + "\n";
        output += this.ionizationEnergy + "\n";
        output += this.electronegativity + "\n";

        return output;
    }
    
}
