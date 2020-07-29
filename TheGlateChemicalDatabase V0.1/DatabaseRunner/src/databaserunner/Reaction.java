/*
    Reaction.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: To store a reaction's reactant and product chemicals.
*/

package databaserunner;

public class Reaction {
    
    ///
    //FIELDS
    ///
    
    protected static final double DEFAULT_STATE_CHANGE_TEMP = -273.15;
    
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
    //CONSTRUCTOR
    ///
    
    public Reaction(Element reactant1, Element reactant2, int id) {
        this.id = id;
        this.reactant1 = reactant1;
        this.reactant2 = reactant2;
        this.product = this.react();
    }
    
    ///
    //METHODS
    ///
    
    public BinaryCompound react() {
        int charge;
        int numElement1, numElement2;
        int oxNum1 = reactant1.getOxidationNum(), oxNum2 = reactant2.getOxidationNum();
        
        //Temporary Name of product
        String tempName = reactant1.getCommonName().concat(reactant2.getCommonName());
        
        //Predicted Stp State
        char predictedStpState;
        if(reactant1.getStpState() == 's' || reactant2.getStpState() == 's')
            predictedStpState = 's';
        else if(reactant1.getStpState() == 'l' || reactant2.getStpState() == 'l')
            predictedStpState = 'l';
        else
            predictedStpState = 'g';
        
        //Set default unknown parameters
        double defaultStpDensity = -1; //non-existent
        double defaultBP = DEFAULT_STATE_CHANGE_TEMP;
        double defaultMP = DEFAULT_STATE_CHANGE_TEMP;
        String colour = "colourless";
        
        //Balancing reactions
        if(oxNum1 > 0 && oxNum2 > 0) {
            numElement1 = 1;
            numElement2 = 1;
            charge = oxNum1 + oxNum2;
        } else {
            oxNum1 = Math.abs(oxNum1);
            oxNum2 = Math.abs(oxNum2);
            numElement1 = oxNum2 / GCF(oxNum1, oxNum2);
            numElement2 = oxNum1 / GCF(oxNum1, oxNum2);
            charge = 0;
        }
        
        FormulaComponent component1 = new FormulaComponent(reactant1, numElement1);
        FormulaComponent component2 = new FormulaComponent(reactant2, numElement2);
        
        //Calculating molar mass
        double molarMass = reactant1.getMolarMass() * numElement1 + reactant2.getMolarMass() * numElement2;
        
        //creating & returning final product
        product = new BinaryCompound(tempName, predictedStpState, defaultStpDensity, molarMass, defaultBP, defaultMP, colour, charge, component1, component2);
        return product;
    }
    
    private static int GCF(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return (GCF(num2, num1 % num2));
        }
    }
    
    public String toString() {
        //do later
        return "";
    }
    
}
