package com.example.android.vindiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import android.widget.RadioButton;

public class Page4 extends AppCompatActivity {

    private RadioButton five, ten, twenty, fivty;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_4);

        ImageView sixteen_gif = findViewById(R.id.sixteen_gif);
        Glide.with(this).load(R.drawable.sixteen_gif).asGif().into(sixteen_gif);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        String name = prefs.getString("MY_NAME", "");

        five = (RadioButton) findViewById(R.id.five);
        ten = (RadioButton) findViewById(R.id.ten);
        twenty = (RadioButton) findViewById(R.id.twenty);
        fivty = (RadioButton) findViewById(R.id.fivty);

        five.setChecked(prefs.getBoolean("FIVE", false));
        ten.setChecked(prefs.getBoolean("TEN", false));
        twenty.setChecked(prefs.getBoolean("TWENTY", false));
        fivty.setChecked(prefs.getBoolean("FIVTY", false));

        Button button = findViewById(R.id.nextPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage5();
            }
        });

        button = findViewById(R.id.previousPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage3();
            }
        });
    }

    public void openActivityPage5() {
        saveData();
        Intent intent = new Intent(this, Page5.class);
        startActivity(intent);
    }

    public void openActivityPage3() {
        saveData();
        Intent intent = new Intent(this, Page3.class);
        startActivity(intent);
    }

    private void saveData() {
        //Save data.
        SharedPreferences.Editor editor = prefs.edit();
        boolean isFive = five.isChecked();
        boolean isTen = ten.isChecked();
        boolean isTwenty = twenty.isChecked();
        boolean isFivty = fivty.isChecked();
        editor.putBoolean("FIVE", isFive);
        editor.putBoolean("TEN", isTen);
        editor.putBoolean("TWENTY", isTwenty);
        editor.putBoolean("FIVTY", isFivty);
        editor.apply();
    }
}