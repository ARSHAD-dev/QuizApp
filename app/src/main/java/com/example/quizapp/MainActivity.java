package com.example.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/*
 ** Created by Arshad...
 */

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";
    String questionOne = "";
    String questionTwo = "";
    String questionThree = "";
    int correctCounter = 0;
    int incorrectCounter = 0;
    int emptyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sumitAnswers(View view)
     {
        CheckBox q1Answer1 = (CheckBox) findViewById(R.id.question_1_checkbox_1);
        CheckBox q1Answer2 = (CheckBox) findViewById(R.id.question_1_checkbox_2);
        CheckBox q1Answer3 = (CheckBox) findViewById(R.id.question_1_checkbox_3);
        CheckBox q1Answer4 = (CheckBox) findViewById(R.id.question_1_checkbox_4);
        CheckBox q1Answer5 = (CheckBox) findViewById(R.id.question_1_checkbox_5);
        if (q1Answer1.isChecked() || q1Answer4.isChecked() || q1Answer5.isChecked() && (q1Answer2.isChecked() || q1Answer3.isChecked())) {
            questionOne = getString(R.string.incorrect_answer);
            incorrectCounter++;
        } else if (q1Answer2.isChecked() && q1Answer3.isChecked()) {
            questionOne = getString(R.string.correct_answer);
            correctCounter++;
        } else if (q1Answer2.isChecked() || q1Answer3.isChecked()) {
            questionOne = getString(R.string.incorrect_answer);
            incorrectCounter++;
        } else {
            questionOne = getString(R.string.empty_answer);
            emptyCounter++;
        }
        RadioButton q2Answer1 = (RadioButton) findViewById(R.id.question_2_radio_1);
        RadioButton q2Answer2 = (RadioButton) findViewById(R.id.question_2_radio_2);
        RadioButton q2Answer3 = (RadioButton) findViewById(R.id.question_2_radio_3);
        if (q2Answer1.isChecked()) {
            questionTwo = getString(R.string.correct_answer);
            correctCounter++;
        } else if (q2Answer2.isChecked() || q2Answer3.isChecked()) {
            questionTwo = getString(R.string.incorrect_answer);
            incorrectCounter++;
        } else {
            questionTwo = getString(R.string.empty_answer);
            emptyCounter++;
        }
        RadioButton q3Answer1 = (RadioButton) findViewById(R.id.question_3_radio_1);
        RadioButton q3Answer2 = (RadioButton) findViewById(R.id.question_3_radio_2);
        RadioButton q3Answer3 = (RadioButton) findViewById(R.id.question_3_radio_3);
        if (q3Answer2.isChecked()) {
            questionThree = getString(R.string.correct_answer);
            correctCounter++;
        } else if (q3Answer1.isChecked() || q3Answer3.isChecked()) {
            questionThree = getString(R.string.incorrect_answer);
            incorrectCounter++;
        } else {
            questionThree = getString(R.string.empty_answer);
            emptyCounter++;
        }
        EditText studentAnswer = (EditText) findViewById(R.id.question_4_answer);
        String questionFourFilter = studentAnswer.getText().toString().toLowerCase();
        boolean textTest = questionFourFilter.equals("objects");
        Log.i("MainActivity", String.valueOf(textTest));
        if (textTest) {
            correctCounter++;
        } else if (questionFourFilter.isEmpty()) {
            emptyCounter++;
        } else {
            incorrectCounter++;
            quizReportMessage();
            correctCounter = 0;
            incorrectCounter = 0;
            emptyCounter = 0;
        }
    }


    private void quizReportMessage() {
        String finalReport = "You got: " + correctCounter + " correct answers out of 4.";
        Context context = getApplicationContext();
        CharSequence toastMessage = finalReport;
        int toastTimer = Toast.LENGTH_SHORT;
        Toast.makeText(context, toastMessage, toastTimer).show();
    }


}