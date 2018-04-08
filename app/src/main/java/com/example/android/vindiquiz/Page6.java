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

    private CheckBox q5_sylas_cb;
    private CheckBox q5_hagie_cb;
    private CheckBox q5_evie_cb;
    private CheckBox q5_hurk_cb;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_6);

        ImageView sylas_gif = findViewById(R.id.sylas_gif);
        Glide.with(this).load(R.drawable.sylas_gif).asGif().into(sylas_gif);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);

        q5_sylas_cb = (CheckBox) findViewById(R.id.q5_sylas_cb);
        q5_hagie_cb = (CheckBox) findViewById(R.id.q5_hagie_cb);
        q5_evie_cb = (CheckBox) findViewById(R.id.q5_evie_cb);
        q5_hurk_cb = (CheckBox) findViewById(R.id.q5_hurk_cb);

        q5_sylas_cb.setChecked(prefs.getBoolean("SYLAS", false));
        q5_hagie_cb.setChecked(prefs.getBoolean("HAGIE", false));
        q5_evie_cb.setChecked(prefs.getBoolean("EVIE", false));
        q5_hurk_cb.setChecked(prefs.getBoolean("HURK", false));

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
        boolean isSylas = q5_sylas_cb.isChecked();
        boolean isHagie = q5_hagie_cb.isChecked();
        boolean isEvie = q5_evie_cb.isChecked();
        boolean isHurk = q5_hurk_cb.isChecked();
        editor.putBoolean("SYLAS", isSylas);
        editor.putBoolean("HAGIE", isHagie);
        editor.putBoolean("EVIE", isEvie);
        editor.putBoolean("HURK", isHurk);
        editor.apply();
    }
}