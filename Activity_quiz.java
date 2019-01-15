package com.quizgame.squareandcubesquiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.quizgame.squareandcubesquiz.quizapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Activity_quiz extends AppCompatActivity implements RewardedVideoAdListener {
    public static final String EXTRA_SCORE="extraSCore";
    private static  final long COUNTDOWN_IN_MILLIS=30000;
     private TextView textViewquestion;

     private EditText answer;
     private TextView score;
     private TextView questioncount;
     private TextView countdown;
     private Button confirm;
     private List<question> questionList;
     private ImageView right;
    private ImageView wrong;
    private ImageView timeup;

     private ColorStateList textcolordefaultcd;
     private CountDownTimer countDownTimer;
     private long timeleftinmillis;
     private int questioncounter;
     private int questioncounttotal;
     private question currentquestion;
     private int coins;
    private TextView textViewDifficulty;
   private boolean answered;
    private long backPressedTime;
    private RewardedVideoAd mad;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mad = MobileAds.getRewardedVideoAdInstance(this);
        mad.setRewardedVideoAdListener(this);

        setContentView(R.layout.activity_quiz);
        textViewquestion=findViewById(R.id.question);
        answer=findViewById(R.id.answer);
        score=findViewById(R.id.text_view_score);
        questioncount=findViewById(R.id.text_view_question_count);
        countdown=findViewById(R.id.text_view_countdown);
        confirm=findViewById(R.id.button_confirm);

        right=findViewById(R.id.imageView1);
        wrong=findViewById(R.id.imageView2);
        timeup=findViewById(R.id.imageView3);
        textcolordefaultcd=countdown.getTextColors();
        Intent intent = getIntent();
        String difficulty = intent.getStringExtra(MainActivity.EXTRA_DIFFICULTY);

        //textViewDifficulty.setText("Difficulty: " +difficulty);
        answer.setInputType((InputType.TYPE_CLASS_NUMBER + InputType.TYPE_NUMBER_FLAG_DECIMAL));

        QuizDbHelper dbhelper = new QuizDbHelper(this);
            questionList = dbhelper.getquestions(difficulty);
        questioncounttotal = questionList.size();
            Collections.shuffle(questionList);
            shownextquestion();
        loadRewardedVideoAd();






        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered)
                {
                    if(answer.getText().toString().trim().length() > 0)
                    {
                        checkanswer();
                    }
                    else {
                        Toast.makeText(Activity_quiz.this,"Enter answer",Toast.LENGTH_SHORT).show();
                    }



                }
                else{

                    shownextquestion();
                }
            }
        });




    }

    private void loadRewardedVideoAd() {
        if(!mad.isLoaded()) {
            mad.loadAd("ca-app-pub-3940256099942544/5224354917",
                    new AdRequest.Builder().build());
        }
    }

    private void shownextquestion()
    {
        answer.setText("");
        if(questioncounter<questioncounttotal)
        {
            currentquestion=questionList.get(questioncounter);

            textViewquestion.setText(currentquestion.getQuestion());
            questioncounter++;
            questioncount.setText("Question: " + questioncounter + "/" + questioncounttotal);
            answered=false;
            confirm.setText("confirm");

            timeleftinmillis=COUNTDOWN_IN_MILLIS;
            startcountdown();

        }
        else {
            finishQuiz();
        }

    }

    private void startcountdown()
    {

        countDownTimer=new CountDownTimer(timeleftinmillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftinmillis=millisUntilFinished;
                updatecountdowntext();
            }

            @Override
            public void onFinish() {
          timeleftinmillis=0;
          updatecountdowntext();
                confirm.setVisibility(View.GONE);
                timeup.setVisibility(View.VISIBLE);
                answer.setEnabled(false);
                final Handler handler  = new Handler();
                final Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (timeup.isShown()) {
                            timeup.setVisibility(View.GONE);
                            answer.setEnabled(true);
                        }

                    }
                };

                handler.postDelayed(runnable, 6000);


                final Handler handler1  = new Handler();
                final Runnable runnable1 = new Runnable() {
                    @Override
                    public void run() {
                       finishQuiz();
                    }
                };

                handler1.postDelayed(runnable1, 3000);



         // checkanswer();
            }
        }.start();


    }
    private void updatecountdowntext()
    {
        int minutes=(int)(timeleftinmillis/1000)/60;
        int seconds=(int)(timeleftinmillis/1000)%60;
        String timeformatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        countdown.setText(timeformatted);
        if(timeleftinmillis<1000)
        {
            countdown.setTextColor(Color.RED);
        }
        else
        {
            countdown.setTextColor(textcolordefaultcd);
        }



    }

    private void checkanswer()
    {
        answered=true;

        countDownTimer.cancel();
        String ans=answer.getText().toString().trim();
      //  Toast.makeText(Activity_quiz.this,ans,Toast.LENGTH_SHORT).show();
       if(ans.equals(currentquestion.getAnswer())) {
           coins++;
           score.setText("COINS: " + coins);
          // Toast.makeText(Activity_quiz.this, "Your answer is right", Toast.LENGTH_SHORT).show();
          right.setVisibility(View.VISIBLE);
           confirm.setVisibility(View.GONE);
           answer.setEnabled(false);
           final Handler handler  = new Handler();
           final Runnable runnable = new Runnable() {
               @Override
               public void run() {
                   if (right.isShown()) {
                   right.setVisibility(View.GONE);
                   }
                   answer.setEnabled(true);
                   confirm.setVisibility(View.VISIBLE);
               }
           };

           handler.postDelayed(runnable, 2000);
           showsolution();
           final Handler handler6  = new Handler();
           final Runnable runnable6 = new Runnable() {
               @Override
               public void run() {
                   shownextquestion();
               }
           };

           handler6.postDelayed(runnable6, 2000);
       }
       else if(!ans.equals(currentquestion.getAnswer())) {

            //score.setText("COINS: " + coins);
            // Toast.makeText(Activity_quiz.this, "Your answer is right", Toast.LENGTH_SHORT).show();
           confirm.setVisibility(View.GONE);
            wrong.setVisibility(View.VISIBLE);
           answer.setEnabled(false);
            final Handler handler  = new Handler();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (wrong.isShown()) {
                        wrong.setVisibility(View.GONE);
                    }


                }
            };

            handler.postDelayed(runnable, 3000);
           final Handler handler1  = new Handler();
           final Runnable runnable1 = new Runnable() {
               @Override
               public void run() {
                   if(mad.isLoaded())
                   {
                       mad.show();
                   }

                   finishQuiz();
                   answer.setEnabled(true);
               }
           };

           handler1.postDelayed(runnable1, 4000);


       }



    }
    private void showsolution()
    {

        Toast.makeText(Activity_quiz.this,"Well Done :)",Toast.LENGTH_SHORT).show();
        if(questioncounter<questioncounttotal)
        {
            //confirm.setText("NEXT");


        }
        else {
            confirm.setText("Finish");
            if(mad.isLoaded())
            {
                mad.show();
            }

        }
    }

    private void finishQuiz()
    {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE,coins);
        setResult(RESULT_OK, resultIntent);
        finish();


    }


    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
   Intent intent=new Intent(Activity_quiz.this,MainActivity.class);
   startActivity(intent);
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }


    @Override
    public void onResume() {
        mad.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mad.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mad.destroy(this);
        super.onDestroy();
    }
}
