package com.bbva.face.presentation.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bbva.face.R;
import com.bbva.face.domain.utils.DisplayUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayUtils.saveDisplaySize(getWindowManager().getDefaultDisplay(), this);

        getWindow().setStatusBarColor(0);


        Button btnRol = findViewById(R.id.btnRol);
        btnRol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent enroll = new Intent(MainActivity.this, EnrollActivity.class);
                startActivity(enroll);
            }
        });
        Button btnAuth = findViewById(R.id.btnAuth);
        btnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent authenticate = new Intent(MainActivity.this, AuthenticateActivity.class);
                startActivity(authenticate);
            }
        });
    }
}
