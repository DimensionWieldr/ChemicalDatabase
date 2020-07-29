/*
    Reaction.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: To store a reaction's reactant and product chemicals.
*/

package databaserunner;

import java.math.*;

public class Reaction {
    
    ///
    //FIELDS
    ///
    
    public static final int REPEATED_REACTION_ID = -1;
    public static final int IMPOSSIBLE_REACTION_ID = -2;
    public static final int DEFAULT_NUM_REACTANT = 1;
    public static final String LABEL_REACTANT = "Reactant";
    
    private static final int MOLAR_MASS_ACCURACY = 4;
    
    private int id;
    private Element reactant1;
    private Element reactant2;
    private BinaryCompound product;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public int getID() {
        return this.id;
    }
    public void setID(int id) {
        this.id = id;
    }
    
    public Element getReactant1() {
        return this.reactant1;
    }
    public void setReactant1(Element reactant1) {
        this.reactant1 = reactant1;
    }
    
    public Element getReactant2() {
        return this.reactant2;
    }
    public void setReactant2(Element reactant2) {
        this.reactant2 = reactant2;
    }
    
    public BinaryCompound getProduct() {
        return this.product;
    }
    public void setProduct(BinaryCompound product) {
        this.product = product;
    }
    
    ///
    //CONSTRUCTORS
    ///
    
    public Reaction(int id, Element reactant1, Element reactant2) {
        this.id = id;
        this.reactant1 = reactant1;
        this.reactant2 = reactant2;

        if (this.reactant1 != null && this.reactant2 != null)
            this.product = this.react(); //ALSO SETS numElement1 & numElement2

        if (this.product != null) {
            if (this.reactant1 == this.reactant2) {
                this.reactant1.getReactionsInvolved().add(this);
            } else {
                this.reactant1.getReactionsInvolved().add(this);
                this.reactant2.getReactionsInvolved().add(this);
            }
            this.product.getReactionsInvolved().add(this);
        } else {
            this.id = IMPOSSIBLE_REACTION_ID;
        }
    }
    public Reaction(int id, Element reactant1, Element reactant2, BinaryCompound product){
        this.id = id;
        this.reactant1 = reactant1;
        this.reactant2 = reactant2;
        this.product = product;

        this.reactant1.getReactionsInvolved().add(this);
        this.reactant2.getReactionsInvolved().add(this);
        this.product.getReactionsInvolved().add(this);
    }
    public Reaction(int id){
        this.id = id;
    }
    
    ///
    //METHODS
    ///
    
    public void removePointers() {
        this.reactant1.getReactionsInvolved().remove(this);
        this.reactant2.getReactionsInvolved().remove(this);
        this.product.getReactionsInvolved().remove(this);
    }
    
    public BinaryCompound react() {
        int charge;
        int numReactant1;
        int numReactant2;
        
        int oxNum1 = reactant1.getOxidationNum(), oxNum2 = reactant2.getOxidationNum();
        
        if(oxNum1 == Element.NO_REACTION_OXIDATION_NUMBER || oxNum2 == Element.NO_REACTION_OXIDATION_NUMBER)
            return null;
        
        //Temporary Name of product
        String tempName = Chemical.DEFAULT_COMMON_NAME;
        
        //Set default unknown parameters
        double defaultStpDensity = Chemical.DEFAULT_DENSITY;
        double defaultBP = Chemical.DEFAULT_STATE_CHANGE_TEMP;
        double defaultMP = Chemical.DEFAULT_STATE_CHANGE_TEMP;
        String colour = Chemical.DEFAULT_COLOUR;
        
        //Balancing reactions
        if(oxNum1 > Element.NO_REACTION_OXIDATION_NUMBER && oxNum2 > Element.NO_REACTION_OXIDATION_NUMBER) {
            numReactant1 = DEFAULT_NUM_REACTANT;
            numReactant2 = DEFAULT_NUM_REACTANT;
            if(this.reactant1 != this.reactant2)
                charge = oxNum1 + oxNum2;
            else
                charge = BinaryCompound.DEFAULT_CHARGE;
        } else {
            oxNum1 = Math.abs(oxNum1);
            oxNum2 = Math.abs(oxNum2);
            numReactant1 = oxNum2 / GCF(oxNum1, oxNum2);
            numReactant2 = oxNum1 / GCF(oxNum1, oxNum2);
            charge = BinaryCompound.DEFAULT_CHARGE;
        }
        
        FormulaComponent component1 = new FormulaComponent(reactant1, numReactant1);
        FormulaComponent component2 = new FormulaComponent(reactant2, numReactant2);
        
        //Calculating molar mass
        double molarMass = reactant1.getMolarMass() * numReactant1 + reactant2.getMolarMass() * numReactant2;
        molarMass = roundDouble(molarMass, MOLAR_MASS_ACCURACY);
        
        //creating & returning final product
        product = new BinaryCompound(tempName, defaultStpDensity, molarMass, defaultBP, defaultMP, colour, charge, component1, component2);
        return product;
    }
    
    private double roundDouble(double value, int places) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    private int GCF(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return (GCF(num2, num1 % num2));
        }
    }
    
    //for saving to files
    public String toString() {
        String output = DatabaseGUI.EMPTY_STRING;

        output += this.id + DatabaseGUI.LINE_BREAK;
        output += this.reactant1.getCommonName() + DatabaseGUI.LINE_BREAK;
        output += this.reactant2.getCommonName() + DatabaseGUI.LINE_BREAK;
        output += this.product.getCommonName() + DatabaseGUI.LINE_BREAK;

        return output;
    }
}