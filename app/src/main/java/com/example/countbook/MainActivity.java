package com.example.countbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Main activity class. This activity shows a list of current records/counter and also displays the total number of
 * records/counters
 */
public class MainActivity extends AppCompatActivity {
    public ArrayAdapter<Records> adapter;
    public ListView listView;
    public TextView totalNumberOfRecords;
    public static Boolean firstStart = true;
    private DataStore store;

    /**
     * Fires when "Add Records" is pressed. Switches the activity to "AddRecordActivity"
     * @param view
     */
    public void addRecords(View view){
        Intent intent = new Intent(getApplicationContext(), AddRecordActivity.class);
        startActivity(intent);
    }

    /**
     * Grabs any past data of the app from our shared preferences file
     * @param context
     */
    public void getPastData(Context context){
        store = DataStore.getInstance(context);
        ArrayList<Records> r = store.getDataFromSharedPreferences("recordsstring");
        RecordContainer.getInstance().setRecordContainer(r); //= new ArrayList<>(store.getDataFromSharedPreferences("recordsstring"));
    }

    /**
     * Stores the past data of app in our shared preferences file
     * @param context
     */
    public void storePastData(Context context){
        store = DataStore.getInstance(context);
        store.storeRecordList("recordsstring", RecordContainer.getInstance().getRecordList());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Reload the previous data of the app if this we are just launching the app
        if(savedInstanceState == null && firstStart == true){
            firstStart = false;
            getPastData(this);
        }

        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        totalNumberOfRecords = (TextView) findViewById(R.id.totalNumberOfRecordsText);

        totalNumberOfRecords.setText("Total Number Of Records: " + RecordContainer.getInstance().getTotalRecords().toString());
        adapter = new ArrayAdapter<Records>(this, android.R.layout.simple_list_item_1, android.R.id.text1, RecordContainer.getInstance().getRecordList());
        listView.setAdapter(adapter);
        //Listens for when a record in the list is pressed
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EditRecordActivity.class);
                //set our currentSelectedRecord to the record we tapped on
                CurrentSelectedRecord.getInstance().setRecord((Records)listView.getAdapter().getItem(position));
                startActivity(intent);
            }
        });
    }

    /**
     * Stores our data when the app stops
     */
    @Override
    public void onStop() {
        super.onStop();
        storePastData(this);
    }

}
