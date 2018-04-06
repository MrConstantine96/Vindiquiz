package com.example.android.vindiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Page7 extends AppCompatActivity {
    int score = 0;
    int resetScore = 0;
    String name, answer;
    private EditText editText;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_7);
        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        name = prefs.getString("MY_NAME", "");
        editText = (EditText) findViewById(R.id.editText);
        Button submitAnswer = findViewById(R.id.submit_answer);
        submitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get the answer the user entered
                answer = editText.getText().toString();
                if (answer.trim().equalsIgnoreCase("yes")) {
                    Toast.makeText(Page7.this, "Good choice!", Toast.LENGTH_LONG).show();
                } else Toast.makeText(Page7.this, "Wrong answer", Toast.LENGTH_LONG).show();
            }
        });
        Button button = findViewById(R.id.previousPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage6();
            }
        });
        button = findViewById(R.id.reset_score);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage1();
            }
        });
    }

    public void openActivityPage6() {
        Intent intent = new Intent(this, Page6.class);
        startActivity(intent);
    }

    public void openActivityPage1() {
        resetScore();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * This method is called when the button result is clicked.
     */
    private int calculateScore() {
        score = 0;
        boolean rocheste = prefs.getBoolean("ROCHESTE", false);
        boolean colheln = prefs.getBoolean("COLHELN", false);
        boolean malina = prefs.getBoolean("MALINA", false);
        boolean berbhe = prefs.getBoolean("BERBHE", false);
        if (malina && colheln && !rocheste && !berbhe) {
            score += 2;
        } else if (malina && !colheln && !rocheste && !berbhe) {
            score++;
        } else if (!malina && colheln && !rocheste && !berbhe) {
            score++;
        }
        boolean fourteen = prefs.getBoolean("FOURTEEN", false);
        if (fourteen) score += 1;
        boolean fivty = prefs.getBoolean("FIVTY", false);
        if (fivty) score += 1;
        boolean fourOrFive = prefs.getBoolean("FOURORFIVE", false);
        if (fourOrFive) score += 1;
        boolean sylas = prefs.getBoolean("SYLAS", false);
        boolean hagie = prefs.getBoolean("HAGIE", false);
        boolean evie = prefs.getBoolean("EVIE", false);
        boolean hurk = prefs.getBoolean("HURK", false);
        if (sylas && hagie && !evie && !hurk) {
            score += 2;
        } else if (!sylas && hagie && !evie && !hurk) {
            score++;
        } else if (sylas && !hagie && !evie && !hurk) {
            score++;
        }
        if (answer != null && !answer.isEmpty()) {
            if (answer.trim().equalsIgnoreCase("yes")) {
                score++;
            }
        }
        return score;
    }

    /**
     * This method calculates the score of the quiz.
     */
    public void showResult(View view) {
        score = calculateScore();
        display(score);
    }

    /**
     * This method displays the score on the screen.
     */
    private void display(int finalScore) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("", "");
        editor.apply();
        if (score >= 8) {
            TextView scoreTextView = (TextView) findViewById(R.id.summary_score);
            scoreTextView.setText("Congratulations " + name + "!" + "\nYou are the Vindictus Quiz Master! " + "\nScore: " + score + "/8");
        } else if (score >= 5) {
            TextView scoreTextView2 = (TextView) findViewById(R.id.summary_score);
            scoreTextView2.setText("You can do better " + name + "!" + "\nTry again! " + "\nScore: " + score + "/8");
        } else if (score >= 0) {
            TextView scoreTextView = (TextView) findViewById(R.id.summary_score);
            scoreTextView.setText("Hmm... " + name + "!" + "\nBetter luck next time! " + "\nScore: " + score + "/8");
        }
    }

    /**
     * Resets the score of the quiz to 0.
     * Clears all RadioGroups and CheckBoxes.
     */
    public void resetScore() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("MY_NAME", "");
        editor.putBoolean("ROCHESTE", (false));
        editor.putBoolean("COLHELN", (false));
        editor.putBoolean("MALINA", (false));
        editor.putBoolean("BERBHE", (false));
        editor.putBoolean("FORTY", (false));
        editor.putBoolean("THIRTYFOUR", (false));
        editor.putBoolean("NINETEEN", (false));
        editor.putBoolean("FOURTEEN", (false));
        editor.putBoolean("FIVE", (false));
        editor.putBoolean("TEN", (false));
        editor.putBoolean("TWENTY", (false));
        editor.putBoolean("FIVTY", (false));
        editor.putBoolean("ONEORTWO", (false));
        editor.putBoolean("TWOORTHREE", (false));
        editor.putBoolean("THREEORFOUR", (false));
        editor.putBoolean("FOURORFVE", (false));
        editor.putBoolean("SYLAS", (false));
        editor.putBoolean("HAGIE", (false));
        editor.putBoolean("EVIE", (false));
        editor.putBoolean("HURK", (false));
        editor.apply();
    }
}