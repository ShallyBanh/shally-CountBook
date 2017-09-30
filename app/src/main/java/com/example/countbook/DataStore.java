package com.example.countbook;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * This is a singleton class which keeps track of our app's data when the user quits the program so
 * that when the user opens up the app again the previous data is still there.
 * This is done using shared preferences.
 */
public class DataStore {
    private static DataStore store;
    private String FILENAME = "Keys";
    private SharedPreferences sharedPreferences;

    private DataStore(Context context) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(FILENAME,0);
    }

    /**
     * Gets our record list from our shared preference's file where we last stored it
     * @param key
     * @return our recordlist
     */
    public ArrayList<Records> getDataFromSharedPreferences(String key){
        Gson gson = new Gson();
        ArrayList<Records> ourRecordList = new ArrayList<Records>();
        String emptyArrayListJson = gson.toJson(new ArrayList<Records>());

        //Try to grab our record list from our shared preference file if it's not found
        //then it will return emptyArrayListJson
        String jsonPreferences = sharedPreferences.getString(key, emptyArrayListJson);

        Type type = new TypeToken<ArrayList<Records>>(){}.getType();

        //Convert the string back into a ArrayList<Record> type
        ourRecordList = gson.fromJson(jsonPreferences, type);

        return ourRecordList;
    }

    public static DataStore getInstance(Context context) {
        if (store == null) {
            store = new DataStore(context);
        }
        return store;
    }

    /**
     * Stores our record list as a key-value pair in our shared preference file
     * @param key - the key to use to access our recordlist data
     * @param recordList - the record list we want stored
     */
    public void storeRecordList(String key, ArrayList<Records> recordList) {
        Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        //Stringify our list
        String recordListAsString = gson.toJson(recordList);

        editor.putString(key, recordListAsString);
        editor.commit();
    }

}