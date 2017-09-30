package com.example.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditRecordsActivity extends AppCompatActivity {
    EditText name;
    EditText comment;
    EditText currentValue;
    EditText initialValue;
    TextView date;
    Intent intent;
    Records currRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_records);

        // Get the Intent that started this activity and extract the string
        intent = new Intent(this, MainActivity.class);
        currRecord = CurrentSelectedRecord.getInstance().getRecord();

        //Set the fields to the values of our current record
        name = (EditText) findViewById(R.id.editText);
        name.setText(currRecord.getName());

        comment = (EditText) findViewById(R.id.editText2);
        String testComment = currRecord.getComment();
        comment.setText(currRecord.getComment());

        currentValue = (EditText) findViewById(R.id.editText3);
        currentValue.setText(currRecord.getCurrentValue().toString());

        initialValue = (EditText) findViewById(R.id.editText4);
        initialValue.setText(currRecord.getInitialValue().toString());

        date = (TextView) findViewById(R.id.textView6);
        date.setText(currRecord.getDate());
    }

    /** Called when the user taps the Send button */
    public void okayButton(View view) {
        currRecord.setCurrentValue(Integer.parseInt(currentValue.getText().toString()));
        currRecord.setInitialValue(Integer.parseInt(initialValue.getText().toString()));
        currRecord.setName(name.getText().toString());
        currRecord.setComment(comment.getText().toString());
        MainActivity.itemValue = currRecord;
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void incrementButton(View view) {
        currRecord.increment();
        currentValue.setText(currRecord.getCurrentValue().toString());
        date.setText(currRecord.getDate());

    }

    /** Called when the user taps the Send button */
    public void decrementButton(View view) {
        currRecord.decrement();
        currentValue.setText(currRecord.getCurrentValue().toString());
        date.setText(currRecord.getDate());

    }

    /** Called when the user taps the Send button */
    public void resetCounterButton(View view) {
        currRecord.resetCounter();
        currentValue.setText(currRecord.getCurrentValue().toString());
        date.setText(currRecord.getDate());

    }

    public void deleteRecord(View view){
        RecordContainer.getInstance().getRecordList().remove(CurrentSelectedRecord.getInstance().getRecord());
        Intent newintent = new Intent(this, MainActivity.class);
        MainActivity.updateView();
        startActivity(newintent);
       // MainActivity.updateView();
    }

}
