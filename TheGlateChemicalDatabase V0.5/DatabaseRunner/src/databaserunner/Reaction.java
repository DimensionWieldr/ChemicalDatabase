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
    
    private static final int REPEATED_REACTION_ID = -1;
    private static final int IMPOSSIBLE_REACTION_ID = -2;
    
    private int id;
    private Element reactant1;
    private int numElement1;
    private Element reactant2;
    private int numElement2;
    private BinaryCompound product;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public static int getREPEATED_REACTION_ID() {
        return REPEATED_REACTION_ID;
    }

    public static int getIMPOSSIBLE_REACTION_ID() {
        return IMPOSSIBLE_REACTION_ID;
    }
    
    public int getNumElement1() {
        return this.numElement1;
    }
    public void setNumElement1(int num) {
        this.numElement1 = num;
    }

    public int getNumElement2() {
        return this.numElement2;
    }
    public void setNumElement2(int num) {
        this.numElement2 = num;
    }
    
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
            this.reactant1.getReactionsInvolved().add(this);
            this.reactant2.getReactionsInvolved().add(this);
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
    
    public BinaryCompound react() {
        int charge;
        int oxNum1 = reactant1.getOxidationNum(), oxNum2 = reactant2.getOxidationNum();
        
        if(oxNum1 == 0 || oxNum2 == 0)
            return null;
        
        //Temporary Name of product
        String tempName = Chemical.DEFAULT_COMMON_NAME;
        
        //Set default unknown parameters
        double defaultStpDensity = Chemical.DEFAULT_DENSITY;
        double defaultBP = Chemical.DEFAULT_STATE_CHANGE_TEMP;
        double defaultMP = Chemical.DEFAULT_STATE_CHANGE_TEMP;
        String colour = Chemical.DEFAULT_COLOUR;
        
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
        product = new BinaryCompound(tempName, defaultStpDensity, molarMass, defaultBP, defaultMP, colour, charge, component1, component2);
        return product;
    }
    
    private static int GCF(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return (GCF(num2, num1 % num2));
        }
    }
    
    //for displaying to the user
    public String stringRepresentation(){
        String output = "";
        
        output += this.reactant1.getMolecularFormula() + " ";
        output += this.reactant2.getMolecularFormula() + " ";
        output += this.product.getMolecularFormula();
        
        return output;
    }
    
    //for saving to files
    public String toString() {
        String output = "";

        output += this.id + "\n";
        output += this.reactant1.getCommonName() + "\n";
        output += this.reactant2.getCommonName() + "\n";
        output += this.product.getCommonName() + "\n";

        return output;
    }
    
}
