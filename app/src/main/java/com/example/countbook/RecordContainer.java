package com.example.countbook;

import java.util.ArrayList;

/**
 * Created by Shally on 2017-09-30.
 */

public class RecordContainer {
    private static final RecordContainer ourInstance = new RecordContainer();

    public static RecordContainer getInstance() {
        return ourInstance;
    }

    private ArrayList<Records> recordList = new ArrayList<Records>();

    public ArrayList<Records> getRecordList(){
        return recordList;
    }

    public void setRecordContainer(ArrayList<Records> r){
        recordList = new ArrayList<Records>(r);
    }
    public Integer getTotalRecords(){
        return recordList.size();
    }

    private RecordContainer() {
    }
}
