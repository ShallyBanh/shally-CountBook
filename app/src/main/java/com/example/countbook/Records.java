package com.example.countbook;

import java.util.Date;

/**
 * Created by Shally on 2017-09-13.
 */


public class Records {
    public String name;
    public String comment;
    public Integer intialValue;
    public Integer currentValue;
    public Date date;
    public static Integer numberOfRecords;

    /**
     * To do
     */
    public void increment(){

    }

    /**
     * To do
     */
    public void decrement(){
    }


    public Integer getTotalNumberOfRecords(){
        return this.numberOfRecords;
    }

}
