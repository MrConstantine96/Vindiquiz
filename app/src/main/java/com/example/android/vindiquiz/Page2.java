package com.example.android.vindiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Page2 extends AppCompatActivity {

    private CheckBox q1_rocheste_cb;
    private CheckBox q1_colheln_cb;
    private CheckBox q1_malina_cb;
    private CheckBox q1_berbhe_cb;
    private SharedPreferences prefs;
    String data, name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_2);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        name = prefs.getString("MY_NAME", "");

        q1_rocheste_cb = (CheckBox) findViewById(R.id.q1_rocheste_cb);
        q1_colheln_cb = (CheckBox) findViewById(R.id.q1_colheln_cb);
        q1_malina_cb = (CheckBox) findViewById(R.id.q1_malina_cb);
        q1_berbhe_cb = (CheckBox) findViewById(R.id.q1_berbhe_cb);

        q1_rocheste_cb.setChecked(prefs.getBoolean("ROCHESTE", false));
        q1_colheln_cb.setChecked(prefs.getBoolean("COLHELN", false));
        q1_malina_cb.setChecked(prefs.getBoolean("MALINA", false));
        q1_berbhe_cb.setChecked(prefs.getBoolean("BERBHE", false));

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

    /**
     * Saves data and changes page
     */
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
        boolean isRocheste = q1_rocheste_cb.isChecked();
        boolean isColheln = q1_colheln_cb.isChecked();
        boolean isMalina = q1_malina_cb.isChecked();
        boolean isBerbhe = q1_berbhe_cb.isChecked();
        editor.putBoolean("ROCHESTE", isRocheste);
        editor.putBoolean("COLHELN", isColheln);
        editor.putBoolean("MALINA", isMalina);
        editor.putBoolean("BERBHE", isBerbhe);
        editor.apply();
    }
}