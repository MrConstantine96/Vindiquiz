package com.example.android.vindiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameImput;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagenumber_1);

        prefs = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        String name = prefs.getString("MY_NAME", "");

        nameImput = (EditText)findViewById(R.id.nameInput);

        //Set default value
        nameImput.setText(name);

        Button button = findViewById(R.id.nextPage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityPage2();
            }
        });
    }

    public void openActivityPage2() {
        saveData();
        Intent intent = new Intent(this, Page2.class);
        startActivity(intent);
    }

    private void saveData() {
        //Get imput text
        String name = nameImput.getText().toString();

        //Save data.
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("MY_NAME", name);
        editor.apply();
    }
}