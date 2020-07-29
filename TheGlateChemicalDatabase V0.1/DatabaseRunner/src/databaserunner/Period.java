/*
    Period.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: To store all the elements in a single row on the periodic table.
*/

package databaserunner;

import java.util.Arrays;

public class Period {
    
    ///
    //FIELDS
    ///
    
    private Element[] periodElements;
    private int periodLength;
    private int periodNum;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public Element[] getPeriodElements() {
        return this.periodElements;
    }
    public void setPeriod(Element[] periodElements) {
        this.periodElements = periodElements;
    }
    
    public int getPeriodLength() {
        return this.periodLength;
    }
    public void setPeriodLength(int periodLength) {
        this.periodLength = periodLength;
    }
    
    public int getPeriodNum() {
        return this.periodNum;
    }
    public void setPeriodNum(int periodNum) {
        this.periodNum = periodNum;
    }
    
    ///
    //CONSTRUCTORS
    ///
    
    public Period(int periodLength, int periodNum, Element[] periodElements) {
        this.periodLength = periodLength;
        this.periodNum = periodNum;
        this.periodElements = periodElements;
    }
    public Period(){
        
    }
    
    ///
    //METHODS
    ///
    
    public int numItems(){
        int count = 0;
        for(Element x : periodElements){
            if(x != null)
                count++;
        }
        return count;
    }
    
    public String toString() {
        return Arrays.toString(this.periodElements);
    }
    
}
