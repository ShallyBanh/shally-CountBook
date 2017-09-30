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
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public static Records itemValue;
    public static ArrayAdapter<Records> adapter;
  //  public static ArrayList<Records> records = new ArrayList<Records>();
  /// public static Integer totalNumberOfRecords = 0;
    TextView setTotalNumberOfRecords;
    public Boolean firstStart = true;
    private DataStore store;

    public void addRecords(View view){
        Intent intent = new Intent(getApplicationContext(), AddRecordController.class);
        startActivity(intent);

    }

    public static void addRecord(Integer initVal, String name, String comment, Integer curVal, Date date){
        RecordContainer.getInstance().getRecordList().add(new Records(initVal, name, comment, curVal, date));
        updateView();
    }

    public static void updateView(){
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onStop() {
        super.onStop();
        storePastData(this);

    }

    public void getPastData(Context context){
        store = DataStore.getInstance(context);
        ArrayList<Records> r = store.getDataFromSharedPreferences("recordsstring");
        RecordContainer.getInstance().setRecordContainer(r); //= new ArrayList<>(store.getDataFromSharedPreferences("recordsstring"));
}

    public void storePastData(Context context){
        store = DataStore.getInstance(context);

       // store.putInt("testrecord", RecordContainer.getInstance().getTotalRecords());
        store.storeRecords("recordsstring", RecordContainer.getInstance().getRecordList());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null && firstStart == true){
            firstStart = false;
            getPastData(this);
        }

        setContentView(R.layout.activity_main);
        setTotalNumberOfRecords = (TextView) findViewById(R.id.textView10);
        setTotalNumberOfRecords.setText("Total Number Of Records: " + RecordContainer.getInstance().getTotalRecords().toString());
        listView = (ListView) findViewById(R.id.list);

        adapter = new ArrayAdapter<Records>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, RecordContainer.getInstance().getRecordList());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CurrentSelectedRecord.getInstance().setRecord((Records)listView.getAdapter().getItem(position));
                itemValue = (Records) listView.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), EditRecordsActivity.class);
                startActivity(intent);
            }

        });
    }

}
