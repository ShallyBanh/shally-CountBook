package com.example.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This activity allows us to edit a record/counter
 */
public class EditRecordActivity extends AppCompatActivity {
    EditText comment;
    EditText currentValue;
    EditText initialValue;
    EditText name;
    Intent intent;
    Records currRecord;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_records);
        intent = new Intent(this, MainActivity.class);

        currRecord = CurrentSelectedRecord.getInstance().getRecord();
        //Set the fields to the values of our current record
        name = (EditText) findViewById(R.id.editRecordsNameText);
        name.setText(currRecord.getName());

        comment = (EditText) findViewById(R.id.editRecordsCommentText);
        comment.setText(currRecord.getComment());

        currentValue = (EditText) findViewById(R.id.editCurrentValueText);
        currentValue.setText(currRecord.getCurrentValue().toString());

        initialValue = (EditText) findViewById(R.id.editInitValueText);
        initialValue.setText(currRecord.getInitialValue().toString());

        date = (TextView) findViewById(R.id.editRecordsDateText);
        date.setText(currRecord.getDate());
    }

    /**
     * Fires the user taps the "-" button. This will decrement the "Current Value" field
     * @param view
     */
    public void decrementButton(View view) {
        currRecord.decrement();
        updateCurrentValue();

    }

    /**
     * Fires when the user taps the "Delete Record" button. This will delete the current record.
     * @param view
     */
    public void deleteRecord(View view){
        Intent newintent = new Intent(this, MainActivity.class);
        //Remove this record from our record container
        RecordContainer.getInstance().getRecordList().remove(CurrentSelectedRecord.getInstance().getRecord());
        startActivity(newintent);
    }

    /**
     * Fires the user taps the "+" button. This will increment the "Current Value" field
     * @param view
     */
    public void incrementButton(View view) {
        currRecord.increment();
        updateCurrentValue();

    }

    /**
     * Fires the user taps the "Okay" button. Indicates that the user is finished
     * editing the record.
     * @param view
     */
    public void okayButton(View view) {
        ArrayList<Records> recordList = RecordContainer.getInstance().getRecordList();

        //set the new values of the record
        currRecord.setCurrentValue(Integer.parseInt(currentValue.getText().toString()));
        currRecord.setInitialValue(Integer.parseInt(initialValue.getText().toString()));
        currRecord.setName(name.getText().toString());
        currRecord.setComment(comment.getText().toString());

        //update the record in our record container
        recordList.set(recordList.indexOf(currRecord), currRecord);
        RecordContainer.getInstance().setRecordContainer(recordList);

        startActivity(intent);
    }

    /**
     * Fires when the user taps the "Reset Counter" button. This will set the "Current Value" field to
     * the "Initial Value" field
     * @param view
     */
    public void resetCounterButton(View view) {
        currRecord.resetCounter();
        updateCurrentValue();

    }

    /**
     * Sets the "Current Value" field to match the "Current Value" of the current record. Also
     * sets the "Date" field to match the "Date" of the current record.
     */
    public void updateCurrentValue(){
        currentValue.setText(currRecord.getCurrentValue().toString());
        date.setText(currRecord.getDate());
    }
}
