package com.example.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

//Testing - everything is just skelatal code no actual functionality written yet
public class MainActivity extends AppCompatActivity {
    ListView listView ;
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        //testing - adding in hardcoded strings to see how it will look
        String[] values = new String[] { "object 0",
                "object 1",
                "object 2",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  itemValue = (String) listView.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), RecordView.class);
                intent.putExtra(EXTRA_MESSAGE, itemValue);
                startActivity(intent);
            }
        });
    }

}
