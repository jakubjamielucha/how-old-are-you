package com.example.howoldareyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GameActivity extends AppCompatActivity {

    Button btnConfirm, btnExit2;
    EditText editTextNumber;

    LocalDate today = LocalDate.now();
    LocalDate birthDate = LocalDate.of(1939, 3, 4);
    long years = ChronoUnit.YEARS.between(birthDate, today);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btnConfirm = findViewById(R.id.btnConfirm);
        btnExit2 = findViewById(R.id.btnExit2);
        editTextNumber = findViewById(R.id.editTextNumber);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int age = Integer.parseInt(editTextNumber.getText().toString());

                if(age == years){
                    Intent intent = new Intent(GameActivity.this, CorrectActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(GameActivity.this, WrongActivity.class);
                    startActivity(intent);
                }

            }
        });

        btnExit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(Intent.ACTION_MAIN);
                newIntent.addCategory(Intent.CATEGORY_HOME);
                newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(newIntent);
                finish();
            }
        });
    }
}