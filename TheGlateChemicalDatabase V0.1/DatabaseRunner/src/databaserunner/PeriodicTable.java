/*
    PeriodicTable.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: To store all the rows in the periodic table.
*/

package databaserunner;

import java.util.*;

public class PeriodicTable {
    
    ///
    //FIELDS
    ///
    
    private static final Element UNKNOWN_ELEMENT = new Element("unknown", ' ', 0, 0, 0, 0, "", 0, 0, 0, 0, "");
    
    private List<Period> table;
    private int firstValence;
    private int increment;
    private int numRow;
    private int numCol;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public static Element getUNKNOWN_ELEMENT(){
        return UNKNOWN_ELEMENT;
    }
    
    public List<Period> getTable() {
        return this.table;
    }
    public void setTable(List<Period> table) {
        this.table = table;
    }
    
    public int getFirstValence() {
        return this.firstValence;
    }
    public void setFirstValence(int firstValence) {
        this.firstValence = firstValence;
    }
    
    public int getIncrement() {
        return this.increment;
    }
    public void setIncrement(int increment) {
        this.increment = increment;
    }
    
    public int getNumRow(){
        return this.numRow;
    }
    public void setNumRow(int numRow){
        this.numRow = numRow;
    }
    
    public int getNumCol(){
        return this.numCol;
    }
    public void setnumCol(int numCol){
        this.numCol = numCol;
    }
    
    ///
    //CONSTRUCTORS
    ///
    
    public PeriodicTable(int firstValence, int increment, List<Element> elements) {
        this.firstValence = firstValence;
        this.increment = increment;
        this.table = new ArrayList();
        this.createTable(elements);
    }
    public PeriodicTable(List<Element> elements) {
        this.createTable(elements);
    }
    
    ///
    //METHODS
    ///
    
    private int findPeriodLength(int tempPeriodNum){
        if(tempPeriodNum == 1)
            return this.firstValence;
        if(tempPeriodNum % 2 == 0)
            return findPeriodLength(tempPeriodNum - 1) + this.firstValence + this.increment*tempPeriodNum/2;
        return findPeriodLength(tempPeriodNum - 1);
    }
    
    public void createTable(List<Element> elements) {
        Period newPeriod;
        Element[] tempPeriodElements;
        Element tempElement;
        int tempPeriodLength = 0;
        int tempPeriodNum = 1;
        int elementsUsed = 0;
        int index = 0, i;
        
        while(elementsUsed < elements.size()) {
            //calculates current period's length & initializes elements array
            tempPeriodLength = this.findPeriodLength(tempPeriodNum);
            tempPeriodElements = new Element[tempPeriodLength];
            
            //adds elements to current period's array of elements (while setting ox nums)
            try {
                for(i = index; i < index + tempPeriodLength; i++) {
                    tempElement = elements.get(i);
                    
                    //set oxidation numbers
                    if(i >= tempPeriodLength / 2)
                        tempElement.setOxidationNum(i+1 - tempPeriodLength);
                    else
                        tempElement.setOxidationNum(i+1);
                    
                    tempPeriodElements[i-index] = tempElement;
                }
            } catch(IndexOutOfBoundsException e) {
                //means the last period is incomplete
            }
            
            //create new period
            newPeriod = new Period(tempPeriodLength, tempPeriodNum, tempPeriodElements);
            //add newly created period to table
            table.add(newPeriod);
            //set periodIn for each element in the current period
            try {
                for(i = index; i < index + tempPeriodLength; i++) {
                    tempElement = elements.get(i);
                    tempElement.setPeriodIn(newPeriod);
                }
                index = i;
            } catch(IndexOutOfBoundsException e) {
                //means the last period is incomplete
            }
            
            //increment variables
            tempPeriodNum++;
            elementsUsed += tempPeriodLength;
        }
        
        //replace empty values in last period with UNKNOWN_ELEMENT
        tempPeriodElements = this.table.get(this.table.size()-1).getPeriodElements();
        for(int j = 0; j < tempPeriodElements.length; j++){
            if(tempPeriodElements[j] == null)
                tempPeriodElements[j] = UNKNOWN_ELEMENT;
        }
        this.table.get(this.table.size()-1).setPeriod(tempPeriodElements);
        this.numRow = tempPeriodNum;
        this.numCol = tempPeriodLength;
    }
    
    public String toString() {
        return ""; //WIP
    }
    
}
