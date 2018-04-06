package com.example.android.vindiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Page2 extends AppCompatActivity {

    private CheckBox rocheste, colheln, malina, berbhe;
    private SharedPreferences prefs;
    String data, name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_2);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        name = prefs.getString("MY_NAME", "");

        rocheste = (CheckBox) findViewById(R.id.rocheste);
        colheln = (CheckBox) findViewById(R.id.colheln);
        malina = (CheckBox) findViewById(R.id.malina);
        berbhe = (CheckBox) findViewById(R.id.berbhe);

        rocheste.setChecked(prefs.getBoolean("ROCHESTE", false));
        colheln.setChecked(prefs.getBoolean("COLHELN", false));
        malina.setChecked(prefs.getBoolean("MALINA", false));
        berbhe.setChecked(prefs.getBoolean("BERBHE", false));

        Button button = findViewById(R.id.nextPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage3();
            }
        });

        button = findViewById(R.id.previousPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage1();
            }
        });

    }


    public void openActivityPage3() {
        saveData();
        Intent intent = new Intent(this, Page3.class);
        startActivity(intent);
    }

    public void openActivityPage1() {
        saveData();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void saveData() {
        //Save data.
        SharedPreferences.Editor editor = prefs.edit();
        boolean isRocheste = rocheste.isChecked();
        boolean isColheln = colheln.isChecked();
        boolean isMalina = malina.isChecked();
        boolean isBerbhe = berbhe.isChecked();
        editor.putBoolean("ROCHESTE", isRocheste);
        editor.putBoolean("COLHELN", isColheln);
        editor.putBoolean("MALINA", isMalina);
        editor.putBoolean("BERBHE", isBerbhe);
        editor.apply();
    }
}