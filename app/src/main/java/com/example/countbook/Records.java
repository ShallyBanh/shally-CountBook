package com.example.countbook;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shally on 2017-09-13.
 */


public class Records {
    public String name = "";
    public String comment = "";
    public Integer initialValue = 0;
    public Integer currentValue = 0;
    public Date date = new Date();

    public Records( Integer initVal, String name, String comment, Integer curVal, Date date){
        this.name = name;
        this.comment = comment;
        this.initialValue = initVal;
        this.currentValue = curVal;
        this.date = date;

        //numberOfRecords += 1;
    }

    @Override
    /**
     * ArrayAdapter calls to string on the object and displays it on the textview. Override to display what we want
     */
    public String toString(){
        return "Name: " + this.name + " | Current Value: " + this.currentValue + " | Date: " + new SimpleDateFormat("yyyy-MM-dd").format(this.date);

    }
    public String getName(){
        return this.name;
    }

    public String getComment(){
        return this.comment;
    }

    public Integer getCurrentValue(){
        return this.currentValue;
    }

    public Integer getInitialValue(){
        return this.initialValue;
    }

    public String getDate(){
        return new SimpleDateFormat("yyyy-MM-dd").format(this.date);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public void setCurrentValue(Integer currentValue){
        this.currentValue = currentValue;
    }

    public void setInitialValue(Integer initialValue){
        this.initialValue = initialValue;
    }

    public void setDate(Date date){
        this.date = date;
    }


    /**
     * To do
     */
    public void increment(){
        this.currentValue += 1;
        this.date = new Date();

    }

    /**
     * To do
     */
    public void decrement(){
        if(this.currentValue == 0){
            return;
        }
        this.currentValue -= 1;
        this.date = new Date();
    }

    public void resetCounter(){
        this.currentValue = this.initialValue;
    }


}
