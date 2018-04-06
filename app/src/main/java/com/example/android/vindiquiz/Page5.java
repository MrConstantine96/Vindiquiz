package com.example.android.vindiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Page5 extends AppCompatActivity {

    private RadioButton oneortwo, twoorthree, threeorfour, fourorfive;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_5);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        String name = prefs.getString("MY_NAME", "");

        oneortwo = (RadioButton) findViewById(R.id.oneOrTwo);
        twoorthree = (RadioButton) findViewById(R.id.twoOrThree);
        threeorfour = (RadioButton) findViewById(R.id.threeOrFour);
        fourorfive = (RadioButton) findViewById(R.id.fourOrFive);

        oneortwo.setChecked(prefs.getBoolean("ONEORTWO", false));
        twoorthree.setChecked(prefs.getBoolean("TWOORTHREE", false));
        threeorfour.setChecked(prefs.getBoolean("THREEORFOUR", false));
        fourorfive.setChecked(prefs.getBoolean("FOURORFVE", false));

        Button button = findViewById(R.id.nextPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage6();
            }
        });

        button = findViewById(R.id.previousPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage4();
            }
        });

    }

    public void openActivityPage6() {
        saveData();
        Intent intent = new Intent(this, Page6.class);
        startActivity(intent);
    }

    public void openActivityPage4() {
        saveData();
        Intent intent = new Intent(this, Page4.class);
        startActivity(intent);
    }

    private void saveData() {
        //Save data.
        SharedPreferences.Editor editor = prefs.edit();
        boolean isOneOrTwo = oneortwo.isChecked();
        boolean isTwoOrThree = twoorthree.isChecked();
        boolean isThreeOrFour = threeorfour.isChecked();
        boolean isFourOrFive = fourorfive.isChecked();
        editor.putBoolean("ONEORTWO", isOneOrTwo);
        editor.putBoolean("TWOORTHREE", isTwoOrThree);
        editor.putBoolean("THREEORFOUR", isThreeOrFour);
        editor.putBoolean("FOURORFVE", isFourOrFive);
        editor.apply();
    }
}