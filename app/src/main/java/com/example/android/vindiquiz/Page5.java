package com.example.android.vindiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Page5 extends AppCompatActivity {

    private RadioButton q4_oneOrTwo_rb;
    private RadioButton q4_twoOrThree_rb;
    private RadioButton q4_threeOrFour_rb;
    private RadioButton q4_fourOrFive_rb;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_5);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);

        q4_oneOrTwo_rb = (RadioButton) findViewById(R.id.q4_oneOrTwo_rb);
        q4_twoOrThree_rb = (RadioButton) findViewById(R.id.q4_twoOrThree_rb);
        q4_threeOrFour_rb = (RadioButton) findViewById(R.id.q4_threeOrFour_rb);
        q4_fourOrFive_rb = (RadioButton) findViewById(R.id.q4_fourOrFive_rb);

        q4_oneOrTwo_rb.setChecked(prefs.getBoolean("ONEORTWO", false));
        q4_twoOrThree_rb.setChecked(prefs.getBoolean("TWOORTHREE", false));
        q4_threeOrFour_rb.setChecked(prefs.getBoolean("THREEORFOUR", false));
        q4_fourOrFive_rb.setChecked(prefs.getBoolean("FOURORFVE", false));

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
        boolean isOneOrTwo = q4_oneOrTwo_rb.isChecked();
        boolean isTwoOrThree = q4_twoOrThree_rb.isChecked();
        boolean isThreeOrFour = q4_threeOrFour_rb.isChecked();
        boolean isFourOrFive = q4_fourOrFive_rb.isChecked();
        editor.putBoolean("ONEORTWO", isOneOrTwo);
        editor.putBoolean("TWOORTHREE", isTwoOrThree);
        editor.putBoolean("THREEORFOUR", isThreeOrFour);
        editor.putBoolean("FOURORFIVE", isFourOrFive);
        editor.apply();
    }
}