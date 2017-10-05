package com.example.per6.quizzer;

/**
 * Created by per6 on 9/15/17.
 */

public class Question {
    private String questionText;
    private boolean answer;

    public Question(String text, boolean ans) {
        this.questionText = text;
        this.answer = ans;

    }

    public String getQuestionText() {
        return questionText;
    }
    public boolean getAnswer() {
        return answer;
    }

    public boolean isAnswer() {
        return answer;
    }
    public boolean chequeAnswer(boolean userAnswer)
    {
        return answer==userAnswer;
    }


}
