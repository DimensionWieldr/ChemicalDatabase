/*
    FormulaComponent.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: Stores a compound's element components (and their quantity).
*/

package databaserunner;

public class FormulaComponent {
    
    ///
    //FIELDS
    ///
    
    private Element component;
    private int numOccurrence;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public Element getComponent(){
        return this.component;
    }
    public void setComponent(Element component){
        this.component = component;
    }
    
    public int getNumOccurrence(){
        return this.numOccurrence;
    }
    public void setNumOccurrence(int numOccurrence){
        this.numOccurrence = numOccurrence;
    }
    
    ///
    //CONSTRUCTOR
    ///
    
    public FormulaComponent(Element component, int numOccurrence) {
        this.component = component;
        this.numOccurrence = numOccurrence;
    }
    
}
