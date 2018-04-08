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

    private RadioButton q3_five_rb;
    private RadioButton q3_ten_rb;
    private RadioButton q3_twenty_rb;
    private RadioButton q3_fivty_rb;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_4);

        ImageView sixteen_gif = findViewById(R.id.sixteen_gif);
        Glide.with(this).load(R.drawable.sixteen_gif).asGif().into(sixteen_gif);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);

        q3_five_rb = (RadioButton) findViewById(R.id.q3_five_rb);
        q3_ten_rb = (RadioButton) findViewById(R.id.q3_ten_rb);
        q3_twenty_rb = (RadioButton) findViewById(R.id.q3_twenty_rb);
        q3_fivty_rb = (RadioButton) findViewById(R.id.q3_fivty_rb);

        q3_five_rb.setChecked(prefs.getBoolean("FIVE", false));
        q3_ten_rb.setChecked(prefs.getBoolean("TEN", false));
        q3_twenty_rb.setChecked(prefs.getBoolean("TWENTY", false));
        q3_fivty_rb.setChecked(prefs.getBoolean("FIVTY", false));

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
        boolean isFive = q3_five_rb.isChecked();
        boolean isTen = q3_ten_rb.isChecked();
        boolean isTwenty = q3_twenty_rb.isChecked();
        boolean isFivty = q3_fivty_rb.isChecked();
        editor.putBoolean("FIVE", isFive);
        editor.putBoolean("TEN", isTen);
        editor.putBoolean("TWENTY", isTwenty);
        editor.putBoolean("FIVTY", isFivty);
        editor.apply();
    }
}