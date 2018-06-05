package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mStoryText;
    Button mTopButton;
    Button mBottomButton;
    int mCurrentLevel;
    int mCurrentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStoryText = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);
        mCurrentLevel = 0;
        mCurrentState = 0;

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStory("top");
            }
        });

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStory("bottom");
            }
        });
    }

    private void setStory(String choose)
    {
        if(mCurrentLevel == 0)
        {
            if(choose == "top")
            {
                mStoryText.setText(R.string.T3_Story);
                mTopButton.setText(R.string.T3_Ans1);
                mBottomButton.setText(R.string.T3_Ans2);
            }

            else if(choose == "bottom")
            {
                mStoryText.setText(R.string.T2_Story);
                mTopButton.setText(R.string.T2_Ans1);
                mBottomButton.setText(R.string.T2_Ans2);
                mCurrentState = 1;
            }
        }

        else if(mCurrentLevel == 1)
        {
            if(mCurrentState == 0)
            {
                if(choose == "top")
                {
                    mStoryText.setText(R.string.T6_End);
                    mTopButton.setVisibility(View.INVISIBLE);
                    mBottomButton.setVisibility(View.INVISIBLE);
                }

                else if(choose == "bottom")
                {
                    mStoryText.setText(R.string.T5_End);
                    mTopButton.setVisibility(View.INVISIBLE);
                    mBottomButton.setVisibility(View.INVISIBLE);
                }
            }

            else if(mCurrentState == 1)
            {
                if(choose == "top")
                {
                    mStoryText.setText(R.string.T3_Story);
                    mTopButton.setText(R.string.T3_Ans1);
                    mBottomButton.setText(R.string.T3_Ans2);
                }

                else if(choose == "bottom")
                {
                    mStoryText.setText(R.string.T4_End);
                    mTopButton.setVisibility(View.INVISIBLE);
                    mBottomButton.setVisibility(View.INVISIBLE);
                }
            }
        }

        else if(mCurrentLevel == 2) {

            if (choose == "top") {
                mStoryText.setText(R.string.T6_End);
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
            } else if (choose == "bottom") {
                mStoryText.setText(R.string.T5_End);
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
            }
        }

        mCurrentLevel++;
    }
}
