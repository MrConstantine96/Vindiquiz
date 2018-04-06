package com.example.android.vindiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class Page3 extends AppCompatActivity {

    private RadioButton forty, thirtyfour, nineteen, fourteen;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_3);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        String name = prefs.getString("MY_NAME", "");

        forty = (RadioButton) findViewById(R.id.forty);
        thirtyfour = (RadioButton) findViewById(R.id.thirtyfour);
        nineteen = (RadioButton) findViewById(R.id.nineteen);
        fourteen = (RadioButton) findViewById(R.id.fourteen);

        forty.setChecked(prefs.getBoolean("FORTY", false));
        thirtyfour.setChecked(prefs.getBoolean("THIRTYFOUR", false));
        nineteen.setChecked(prefs.getBoolean("NINETEEN", false));
        fourteen.setChecked(prefs.getBoolean("FOURTEEN", false));

        Button button = findViewById(R.id.nextPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage4();
            }
        });

        button = findViewById(R.id.previousPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage2();
            }
        });

    }

    public void openActivityPage4() {
        saveData();
        Intent intent = new Intent(this, Page4.class);
        startActivity(intent);
    }

    public void openActivityPage2() {
        saveData();
        Intent intent = new Intent(this, Page2.class);
        startActivity(intent);
    }

    private void saveData() {
        //Save data.
        SharedPreferences.Editor editor = prefs.edit();
        boolean isForty = forty.isChecked();
        boolean isThirtyFour = thirtyfour.isChecked();
        boolean isNineTeen = nineteen.isChecked();
        boolean isFourTeen = fourteen.isChecked();
        editor.putBoolean("FORTY", isForty);
        editor.putBoolean("THIRTYFOUR", isThirtyFour);
        editor.putBoolean("NINETEEN", isNineTeen);
        editor.putBoolean("FOURTEEN", isFourTeen);
        editor.apply();
    }
}