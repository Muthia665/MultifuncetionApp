package com.example.user.multifuncetionapp;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import com.example.reza.multifunctionapp.R;

public class MainActivity extends AppCompatActivity {

    Button btnbt,btnwifi,btnmode,btnsms, btntts, btnstt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnbt = findViewById(R.id.btnBt);
        btnbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Bluetooth.class);
                startActivity(i);
            }
        });

        btnwifi = findViewById(R.id.btnWifi);
        btnwifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Wifi.class);
                startActivity(i);
            }

        });

        btnmode = findViewById(R.id.btnMode);
        btnmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Mode.class);
                startActivity(i);
            }

        });

        btnsms = findViewById(R.id.btnSms);
        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SMS.class);
                startActivity(i);
            }

        });

        btnstt = findViewById(R.id.btnstt);
        btnstt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), STTActivity.class);
                startActivity(i);
            }

        });

        btntts = findViewById(R.id.btntts);
        btntts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),STTActivity .class);
                startActivity(i);
            }

        });
    }
}

