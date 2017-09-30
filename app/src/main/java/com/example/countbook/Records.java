package com.example.countbook;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shally on 2017-09-13.
 *
 * This class contains all the information that a record/counter should have.
 */
public class Records {
    public Date date = new Date();
    public Integer initialValue = 0;
    public Integer currentValue = 0;
    public String comment = "";
    public String name = "";

    /**
     * Constructor. Creates a record
     * @param initVal
     * @param name
     * @param comment
     * @param curVal
     * @param date
     */
    public Records( Integer initVal, String name, String comment, Integer curVal, Date date){
        this.name = name;
        this.comment = comment;
        this.initialValue = initVal;
        this.currentValue = curVal;
        this.date = date;
    }

    /**
     * Decrements the current value of the record by 1. Also sets the date of the
     * record/counter to the current date
     */
    public void decrement(){
        //we can't have negative numbers
        if(this.currentValue == 0){
            return;
        }
        this.currentValue -= 1;
        this.date = new Date();
    }

    /**
     * Grabs the comment of the record/counter
     * @return - comment of the record/counter
     */
    public String getComment(){
        return this.comment;
    }

    /**
     * Grabs the current value of the record/counter
     * @return - current value of the record/counter
     */
    public Integer getCurrentValue(){
        return this.currentValue;
    }

    /**
     * Returns the date of the record/counter as a string
     * @return - the date of the record/counter
     */
    public String getDate(){
        return new SimpleDateFormat("yyyy-MM-dd").format(this.date);
    }

    /**
     * Grabs the initial value of the record/counter
     * @return - initial value of the record/counter
     */
    public Integer getInitialValue(){
        return this.initialValue;
    }


    /**
     * Grabs the name of the record/counter
     * @return - name of the record/counter
     */
    public String getName(){
        return this.name;
    }


    /**
     * Increments the current value of the record by 1. Also sets the date of the
     * record/counter to the current date
     */
    public void increment(){
        this.currentValue += 1;
        this.date = new Date();

    }

    /**
     * Resets the current value of the record/counter to the initial value
     */
    public void resetCounter(){
        this.currentValue = this.initialValue;
    }
    /**
     * Sets the comment of the record/counter to comment
     * @param comment - value to set the comment of record/counter to
     */
    public void setComment(String comment){
        this.comment = comment;
    }

    /**
     * Sets the current value of the record/counter to currentValue
     * @param currentValue - value to set the current value of record/counter to
     */
    public void setCurrentValue(Integer currentValue){
        this.currentValue = currentValue;
    }

    /**
     * Sets the initial value of the record/counter to initialValue
     * @param initialValue - value to set the initial value of record/counter to
     */
    public void setInitialValue(Integer initialValue){
        this.initialValue = initialValue;
    }

    /**
     * Sets the name of the record/counter to name
     * @param name - value to set the name of record/counter to
     */
    public void setName(String name){
        this.name = name;
    }

    @Override
    /**
     * ArrayAdapter calls to string on the object and displays it on the textview. Override to display what we want
     */
    public String toString(){
        return "Name: " + this.getName() + " | Current Value: " + this.getCurrentValue() + " | Initial Value: " + this.initialValue
                + " | Comment: " + this.getComment() + " | Date: " + new SimpleDateFormat("yyyy-MM-dd").format(this.date);

    }
}
