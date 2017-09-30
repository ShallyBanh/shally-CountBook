package com.example.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

/**
 * This activity allows the user to create a new record/counter.
 */
public class AddRecordActivity extends AppCompatActivity {

    EditText initComment;
    EditText initInitialValue;
    EditText initName;

    /**
     * Fires when the create button is pressed. Grabs the data entered by the user and creates a new
     * record.
     *
     * @param view
     */
    public void createRecord(View view){
        Intent intent = new Intent(this, MainActivity.class);

        //Grabs the data entered by the user
        initName = (EditText) findViewById(R.id.editNameText);
        initInitialValue = (EditText) findViewById(R.id.editInitValueText);
        initComment = (EditText) findViewById(R.id.editCommentText);

        //create a new record using the data and add it to our record container
        RecordContainer.getInstance().getRecordList().add(new Records(Integer.parseInt(initInitialValue.getText().toString()), initName.getText().toString(),
                initComment.getText().toString(),Integer.parseInt(initInitialValue.getText().toString()), new Date()));

        startActivity(intent);

    }

    /**
     * Constructor
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

    }
}
