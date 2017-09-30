package com.example.countbook;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataStore {
    private static DataStore store;
    private static String filename="Keys";
    private SharedPreferences SP;

    private DataStore(Context context) {
        SP = context.getApplicationContext().getSharedPreferences(filename,0);
    }

    public static DataStore getInstance(Context context) {
        if (store == null) {
            store = new DataStore(context);
        }
        return store;
    }

    public void putRecords(String key, String value) {
        Editor editor = SP.edit();
        editor.putString(key, value);
        editor.commit();
    }


    public int getInt(String key) {
        return SP.getInt(key, 0);
    }

    public void putInt(String key, int num) {
        Editor editor = SP.edit();
        editor.putInt(key, num);
        editor.commit();
    }

    public void storeRecords(String key, ArrayList<Records> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        putRecords(key, json);
    }

    public ArrayList<Records> getDataFromSharedPreferences(String key){
        Gson gson = new Gson();
        ArrayList<Records> productFromShared = new ArrayList<Records>();
        String json = gson.toJson(new ArrayList<Records>());
        String jsonPreferences = SP.getString(key, json);

        Type type = new TypeToken<ArrayList<Records>>(){}.getType();
        productFromShared = gson.fromJson(jsonPreferences, type);

        return productFromShared;
    }

}