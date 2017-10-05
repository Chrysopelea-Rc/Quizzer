package com.example.per6.quizzer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.per6.quizzer.R.id.enter;
import static com.example.per6.quizzer.R.id.f;
import static com.example.per6.quizzer.R.id.question_text;
import static com.example.per6.quizzer.R.id.t;

//finish the check question and game mechanism
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String EXTRAMESSAGE1 = "hi";
    private boolean finished=false;
    private Button trueButton, falseButton, enterButton;
    public int score=0;
    private TextView question;
    private ArrayList<Question> questionbank=new ArrayList<>();
    private String catQuestion=getString(R.string.catQuestion);
    private String chiQuestion=getString(R.string.chiQuestion);
    private String computerQuestion=getString(R.string.computerQuestion);
    private String vQuestion=getString(R.string.vQuestion);
    private boolean hasBeenAnswered=false;
    private boolean answered=false;
private int currentq=0;
public static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        initQuestion();
        if (savedInstanceState!=null)
        {
            currentq=savedInstanceState.getInt("question We are on",0);
        }
        question.setText(questionbank.get(currentq).getQuestionText());

        //display the first question in the bank in the text view
        question.setText("hellow world!");
        question.setText(questionbank.get(currentq).getQuestionText());



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
        questionbank.add(new Question(catQuestion,true));
        questionbank.add(new Question(computerQuestion,true));
        questionbank.add(new Question(vQuestion,true));
        questionbank.add(new Question(chiQuestion,false));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.t:
                Toast.makeText(this, "T Clicked!", Toast.LENGTH_SHORT).show();
                answered=true;
                checkQuestion();
                hasBeenAnswered=true;
                break;
            case R.id.f:
                Toast.makeText(this, "F Clicked!", Toast.LENGTH_SHORT).show();
                answered=false;
                checkQuestion();
                hasBeenAnswered=true;
                break;
            case R.id.enter:


                Toast.makeText(this, "Score: "+score, Toast.LENGTH_SHORT).show();
                nextQuestion();

                answered=false;
                hasBeenAnswered=false  ;
                break;
            default:
                Toast.makeText(this, "Nothin Happening", Toast.LENGTH_SHORT).show();
    }
}
    public void nextQuestion() {
        //advance to the next question, make sure it's actually exists, then set it
        if (currentq<questionbank.size()-1)
        {
            currentq++;
        }
        else
        {
            currentq=0;
            finished=true;

            Intent i = new Intent(MainActivity.this, ScorecardActivity.class);
            //Intent(coming from, where to go)
            i.putExtra(EXTRAMESSAGE1, Integer.toString(score));
            startActivity(i);

        }
        question.setText(questionbank.get(currentq).getQuestionText());


    }
    public void checkQuestion()
    {
        if (answered==questionbank.get(currentq).getAnswer()&& hasBeenAnswered==false)
        {score++;}
        else{score+=0;
        }
    }
//android lifecycle methods
    //issue: resets questions during screen rotation
    //solution: use SavedInstanceState

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState:method fYred");
        outState.putInt("qestion We are on", currentq);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart:method fYred");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop:method fYred");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy:method fYred");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause:method fYred");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume:method fYred");
    }
}


