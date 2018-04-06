package com.example.android.vindiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.CheckBox;

import com.bumptech.glide.Glide;

public class Page6 extends AppCompatActivity {

    private CheckBox sylas, hagie, evie, hurk;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_6);

        ImageView sylas_gif = findViewById(R.id.sylas_gif);
        Glide.with(this).load(R.drawable.sylas_gif).asGif().into(sylas_gif);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        String name = prefs.getString("MY_NAME", "");

        sylas = (CheckBox) findViewById(R.id.sylas);
        hagie = (CheckBox) findViewById(R.id.hagie);
        evie = (CheckBox) findViewById(R.id.evie);
        hurk = (CheckBox) findViewById(R.id.hurk);

        sylas.setChecked(prefs.getBoolean("SYLAS", false));
        hagie.setChecked(prefs.getBoolean("HAGIE", false));
        evie.setChecked(prefs.getBoolean("EVIE", false));
        hurk.setChecked(prefs.getBoolean("HURK", false));

        Button button = findViewById(R.id.nextPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage7();
            }
        });

        button = findViewById(R.id.previousPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage5();
            }
        });

    }

    public void openActivityPage7() {
        saveData();
        Intent intent = new Intent(this, Page7.class);
        startActivity(intent);
    }

    public void openActivityPage5() {
        saveData();
        Intent intent = new Intent(this, Page5.class);
        startActivity(intent);
    }

    private void saveData() {
        //Save data.
        SharedPreferences.Editor editor = prefs.edit();
        boolean isSylas = sylas.isChecked();
        boolean isHagie = hagie.isChecked();
        boolean isEvie = evie.isChecked();
        boolean isHurk = hurk.isChecked();
        editor.putBoolean("SYLAS", isSylas);
        editor.putBoolean("HAGIE", isHagie);
        editor.putBoolean("EVIE", isEvie);
        editor.putBoolean("HURK", isHurk);
        editor.apply();
    }
}