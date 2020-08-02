package com.example.geoquiz.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.geoquiz.R;
import com.example.geoquiz.model.Question;

public class QuizActivity extends AppCompatActivity {
    private int mAnsweredQuestion=0;
    private Integer mScoreCnt=0;
    private TextView mScore;
    private TextView mTests;
    private ImageButton mBtnTrue;
    private ImageButton mBtnFalse;
    private ImageButton mButtonNext;
    private ImageButton mButtonPrev;
    private ImageButton mButtonFirst;
    private ImageButton mButtonLast;
    private int mCurrentIndex=0;

    private Question[] mQuestions={
            new Question(R.string.question_australia,false),
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,true),
            new Question(R.string.question_americas,false),
            new Question(R.string.question_asia,false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();
        updateQuestion();

    }

    private void findViews() {
        mScore=findViewById(R.id.score);
        mButtonFirst=findViewById(R.id.btn_first);
        mButtonLast=findViewById(R.id.btn_last);
        mButtonNext=(ImageButton) findViewById(R.id.btn_next);
        mButtonPrev=(ImageButton)findViewById(R.id.btn_prev);
        mBtnTrue=(ImageButton)findViewById(R.id.btn_true);
        mBtnFalse=(ImageButton)findViewById(R.id.btn_false);
        mTests =findViewById(R.id.txtview_question_text);


    }

    private void updateQuestion() {
        int questionResId=mQuestions[mCurrentIndex].getQuestionResId();
        mTests.setText(questionResId);
        mBtnFalse.setEnabled(!mQuestions[mCurrentIndex].isPeresed());
        mBtnTrue.setEnabled(!mQuestions[mCurrentIndex].isPeresed());

    }

    private void setListeners() {
        mBtnTrue.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                checkAnswer(true);
                mQuestions[mCurrentIndex].setPeresed(true);
            }
        });
        mBtnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                mQuestions[mCurrentIndex].setPeresed(true);
            }
        });

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestions.length;
                updateQuestion();


            }
        });
        mButtonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex - 1 + mQuestions.length) % mQuestions.length;
                updateQuestion();
            }
        });
        mButtonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTests.setText(mQuestions[0].getQuestionResId());
            }
        });
        mButtonLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTests.setText(mQuestions[mQuestions.length-1].getQuestionResId());
            }
        });
    }

    private void checkAnswer(boolean userPressed){
        mAnsweredQuestion++;
        mQuestions[mCurrentIndex].setPeresed(true);
        if (mQuestions[mCurrentIndex].isTrue()==userPressed){
            mScoreCnt++;
            Toast.makeText(QuizActivity.this, R.string.toast_correct, Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(QuizActivity.this, R.string.toast_incorrect, Toast.LENGTH_SHORT).show();
        }
        mBtnTrue.setEnabled(false);
        mBtnFalse.setEnabled(false);
        mScore.setText(mScoreCnt.toString());
    }
}