package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText plainView1;
    private EditText plainView2;

    public void sum(View view){
       plainView1 = findViewById(R.id.plainText1);
       plainView2 = findViewById(R.id.ActivityOneText);
       int result = Integer.parseInt(plainView1.getText().toString())
                    + Integer.parseInt(plainView2.getText().toString());

       TextView answer = findViewById(R.id.result);
       answer.setText(String.valueOf(result));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        // this activity is about to become visible
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        // this activity has become visible (now "it resumes")
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        // Focus on another activity (this activity is about to be "stopped")
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        // The activity is no longer visible (now it is "stopped")
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        // The activity is about to be destroyed
    }
}