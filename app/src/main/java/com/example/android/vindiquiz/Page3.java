package com.example.android.vindiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class Page3 extends AppCompatActivity {

    private RadioButton q2_forty_rb;
    private RadioButton q2_thirtyfour_rb;
    private RadioButton q2_nineteen_rb;
    private RadioButton q2_fourteen_rb;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_3);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);

        q2_forty_rb = (RadioButton) findViewById(R.id.q2_forty_rb);
        q2_thirtyfour_rb = (RadioButton) findViewById(R.id.q2_thirtyfour_rb);
        q2_nineteen_rb = (RadioButton) findViewById(R.id.q2_nineteen_rb);
        q2_fourteen_rb = (RadioButton) findViewById(R.id.q2_fourteen_rb);

        q2_forty_rb.setChecked(prefs.getBoolean("FORTY", false));
        q2_thirtyfour_rb.setChecked(prefs.getBoolean("THIRTYFOUR", false));
        q2_nineteen_rb.setChecked(prefs.getBoolean("NINETEEN", false));
        q2_fourteen_rb.setChecked(prefs.getBoolean("FOURTEEN", false));

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
        boolean isForty = q2_forty_rb.isChecked();
        boolean isThirtyFour = q2_thirtyfour_rb.isChecked();
        boolean isNineTeen = q2_nineteen_rb.isChecked();
        boolean isFourTeen = q2_fourteen_rb.isChecked();
        editor.putBoolean("FORTY", isForty);
        editor.putBoolean("THIRTYFOUR", isThirtyFour);
        editor.putBoolean("NINETEEN", isNineTeen);
        editor.putBoolean("FOURTEEN", isFourTeen);
        editor.apply();
    }
}