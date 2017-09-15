package com.example.per6.quizzer;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.per6.quizzer.R.id.enter;
import static com.example.per6.quizzer.R.id.f;
import static com.example.per6.quizzer.R.id.question_text;
import static com.example.per6.quizzer.R.id.t;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button trueButton, falseButton, enterButton;
    private int score=0;
    private TextView question;
    private ArrayList<Question> questionbank;

    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    private void setListeners(){
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        enterButton.setOnClickListener(this);
    }
    public void wireWidgets(){
        trueButton=(Button) findViewById(t);
        falseButton=(Button) findViewById(f);
        enterButton=(Button) findViewById(enter);
        question=(TextView) findViewById(question_text);
    }
    private void initQuestion() {
        questionbank.add(1,new Question("Cats like blankets",true));
        questionbank.add(1,new Question("This computer is good",true));
    }


    @Override
    public void onClick(View view) {

    }
}
