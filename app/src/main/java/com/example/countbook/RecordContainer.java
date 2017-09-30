package com.example.countbook;

import java.util.ArrayList;

/**
 * Created by Shally on 2017-09-30.
 *
 * Singleton Class which keeps track of all our records
 */
public class RecordContainer {
    private static final RecordContainer ourInstance = new RecordContainer();

    //Init our list so we don't have a null pointer
    private ArrayList<Records> recordList = new ArrayList<Records>();

    public static RecordContainer getInstance() {
        return ourInstance;
    }

    private RecordContainer() {

    }

    /**
     * Gets our current list of records/counters
     * @return - our list of records
     */
    public ArrayList<Records> getRecordList(){
        return recordList;
    }

    /**
     * Gets the total amount of records
     * @return - the total amount of records in our list
     */
    public Integer getTotalRecords(){
        return recordList.size();
    }

    /**
     * Sets our record list to a new record list
     * @param newRecordList
     */
    public void setRecordContainer(ArrayList<Records> newRecordList){
        recordList = new ArrayList<Records>(newRecordList);
    }


}
