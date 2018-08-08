package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton q1RadioButton;
    RadioButton q2RadioButton;
    CheckBox q3Checkbox1;
    CheckBox q3Checkbox2;
    CheckBox q3Checkbox3;
    CheckBox q3Checkbox4;
    EditText q4Textbox;
    StringBuilder results = new StringBuilder();
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        q1RadioButton = findViewById(R.id.question_one_answer_two);
        q2RadioButton = findViewById(R.id.question_two_answer_true);
        q3Checkbox1 = findViewById(R.id.question_3_answer_1);
        q3Checkbox2 = findViewById(R.id.question_3_answer_2);
        q3Checkbox3 = findViewById(R.id.question_3_answer_3);
        q3Checkbox4 = findViewById(R.id.question_3_answer_4);
        q4Textbox = findViewById(R.id.question_four_edit_box);
    }

    public void submitAnswers(View view) {
        //Question 1 scoring
        if (q1RadioButton.isChecked()) {
            score++;
            results.append("Question 1 was correct!\n");
        } else {
            results.append("Question 1 was incorrect!\n");
        }

        //Question 2 scoring
        if (q2RadioButton.isChecked()) {
            score++;
            results.append("Question 2 was correct!\n");
        } else {
            results.append("Question 2 was incorrect!\n");
        }

        //Question 3 scoring
        if (q3Checkbox1.isChecked() && q3Checkbox2.isChecked() && !q3Checkbox3.isChecked() && q3Checkbox4.isChecked()) {
            score++;
            results.append("Question 3 was correct!\n");
        } else {
            results.append("Question 3 was incorrect!\n");
        }

        //Question 4 scoring
        if (q4Textbox.getText().toString().toLowerCase().equals("graph")) {
            score++;
            results.append("Question 4 was correct!\n");
        } else {
            results.append("Question 4 was incorrect!\n");
        }

        //Results
        results.append("Your score was: ");
        results.append(score);
        results.append(" out of 4");
        Toast.makeText(this, results, Toast.LENGTH_SHORT).show();
        results.delete(0, results.length());
        score = 0;
    }
}
