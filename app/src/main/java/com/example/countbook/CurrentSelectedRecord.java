package com.example.countbook;

import java.util.Date;

/**
 * Singleton Class which keeps track of the current record the User wants
 */
public class CurrentSelectedRecord {
    private static CurrentSelectedRecord ourInstance = new CurrentSelectedRecord();

    public static CurrentSelectedRecord getInstance() {
        return ourInstance;
    }

    private Records record = new Records(0, "", "", 0, new Date());

    public Records getRecord(){
        return record;
    }

    public void setRecord(Records newRecord){
        record = newRecord;
    }

    private CurrentSelectedRecord() {

    }
}
