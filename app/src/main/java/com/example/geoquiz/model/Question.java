package com.example.geoquiz.model;

import android.widget.Button;
import android.widget.ImageButton;

import com.example.geoquiz.R;

public class Question {
    private int mQuestionResId;
    private boolean mIsTrue;
    private boolean isPeresed;
    public boolean isPeresed() {
        return isPeresed;
    }
    public void setPeresed(boolean peresed) {
        isPeresed = peresed;
    }
    public int getQuestionResId() {
        return mQuestionResId;
    }
    public void setQuestionResId(int questionResId) {
        mQuestionResId = questionResId;
    }
    public boolean isTrue() {
        return mIsTrue;
    }
    public void setTrue(boolean aTrue) {
        mIsTrue = aTrue;
    }

    public Question(int questionResId, boolean isTrue) {
        mQuestionResId = questionResId;
        mIsTrue = isTrue;
        isPeresed=false;
    }

    public Question() {
    }
}
