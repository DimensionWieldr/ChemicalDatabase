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
    
    private Element element;
    private int numOccurrence;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public Element getElement(){
        return this.element;
    }
    public void setElement(Element component){
        this.element = component;
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
        this.element = component;
        this.numOccurrence = numOccurrence;
    }
    
    ///
    //METHODS
    ///
    
    public String toString(){
        String output = DatabaseGUI.EMPTY_STRING;

        output += this.element.getCommonName() + DatabaseGUI.LINE_BREAK;
        output += this.numOccurrence + DatabaseGUI.LINE_BREAK;

        return output;
    }
}