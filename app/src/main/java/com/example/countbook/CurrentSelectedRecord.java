package com.example.countbook;

import java.util.Date;

/**
 * Singleton Class which keeps track of the current record the User wants/Is currently on
 */
public class CurrentSelectedRecord {
    private static CurrentSelectedRecord ourInstance = new CurrentSelectedRecord();

    //initialize a record so we don't have a null pointer
    private Records record = new Records(0, "", "", 0, new Date());

    /**
     * Constructor
     */
    private CurrentSelectedRecord() {

    }

    public static CurrentSelectedRecord getInstance() {
        return ourInstance;
    }
    /**
     * Gets the current record
     * @return record
     */
    public Records getRecord() {
        return record;
    }

    /**
     * sets our old current record to the new current record that we want
     * @param newRecord
     */
    public void setRecord(Records newRecord){
        record = newRecord;
    }

}
