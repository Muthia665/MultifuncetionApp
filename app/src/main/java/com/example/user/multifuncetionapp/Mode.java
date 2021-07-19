package com.example.user.multifuncetionapp;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.reza.multifunctionapp.R;

public class Mode extends AppCompatActivity {

    Button btnring, btnvibrate, btnsilent, btnmodes;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        btnring = findViewById(R.id.btnring);
        btnvibrate = findViewById(R.id.btnvibrate);
        btnsilent = findViewById(R.id.btnsilent);
        btnmodes = findViewById(R.id.btnmodestatus);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        btnring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

            }
        });
        btnvibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

            }
        });
        btnsilent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);

            }
        });
        btnmodes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//mengecek mode yang sedang digunakan pada hp
                int mode = audioManager.getMode();

                if (mode == AudioManager.RINGER_MODE_NORMAL){
                    Toast.makeText(Mode.this, "Ringger", Toast.LENGTH_SHORT).show();
                }else if (mode == AudioManager.RINGER_MODE_VIBRATE){
                    Toast.makeText(Mode.this, "Vibrate", Toast.LENGTH_SHORT).show();
                }else if (mode == AudioManager.RINGER_MODE_SILENT){
                    Toast.makeText(Mode.this, "Silent", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
