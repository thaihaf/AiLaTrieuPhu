package com.example.finalprojectailatrieuphu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalprojectailatrieuphu.Dialog.DialogHuongdan;

public class MainScreen extends AppCompatActivity {
    private Button btnHuongdan;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        btnHuongdan = findViewById(R.id.btnHuongdan);
        btnStart = findViewById(R.id.btnStart);
        btnHuongdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DialogHuongdan(MainScreen.this).show();
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainScreen.this, GameScreen.class);
                startActivity(i);
            }
        });
    }
}