package com.example.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class AddRecordController extends AppCompatActivity {

    EditText initComment;
    EditText initName;
    EditText initInitialValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record_controller);

    }

    public void createRecord(View view){
        Intent intent = new Intent(this, MainActivity.class);
        initName = (EditText) findViewById(R.id.editText5);
        initInitialValue = (EditText) findViewById(R.id.editText6);
        initComment = (EditText) findViewById(R.id.editText7);
        MainActivity.addRecord(Integer.parseInt(initInitialValue.getText().toString()), initName.getText().toString(),
                initComment.getText().toString(),Integer.parseInt(initInitialValue.getText().toString()), new Date());
        startActivity(intent);

    }
}
