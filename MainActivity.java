package com.quizgame.squareandcubesquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.quizgame.squareandcubesquiz.quizapp.R;

public class MainActivity extends AppCompatActivity {
    private Button enter;
    private static final int REQUEST_CODE_QUIZ=1;

    public static final String SHARED_PREFS="sharedprefs";
    public static final String KEY_HIGHSCORE="keyHighScore";
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";
    private TextView highscore;
    private Spinner spinnerDifficulty;
    private int highscores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        enter=(Button)findViewById(R.id.button_startquiz);
        highscore=findViewById(R.id.text_highscore);
        spinnerDifficulty = findViewById(R.id.spinner_difficulty);

        String[] difficultyLevels = question.getAllDifficultyLevels();

        ArrayAdapter<String> adapterDifficulty = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, difficultyLevels);
        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulty.setAdapter(adapterDifficulty);
        loadHighscore();


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();


            }
        });
    }

    private void startQuiz() {

        String difficulty = spinnerDifficulty.getSelectedItem().toString();

        Intent intent = new Intent(MainActivity.this, Activity_quiz.class);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(Activity_quiz.EXTRA_SCORE, 0);
                if (score > highscores) {
                    updateHighscore(score);
                }
            }
        }
    }

    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscores = prefs.getInt(KEY_HIGHSCORE, 0);
        highscore.setText("Highscore: " + highscores);
    }

    private void updateHighscore(int highscoreNew) {
        highscores = highscoreNew;
        highscore.setText("Highscore: " + highscores);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscores);
        editor.apply();
    }

}
