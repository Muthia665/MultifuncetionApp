package com.example.user.multifuncetionapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reza.multifunctionapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class STTActivity extends AppCompatActivity {

    TextView txtstt;
    ImageView imgstt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stt);

        txtstt = findViewById(R.id.txtText);
        imgstt = findViewById(R.id.imgstt);

        imgstt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputSpeak();
                txtstt.setText("");
            }
        });
    }


    private void InputSpeak() {
        Intent a = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        a.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //MENGATUR KE BAHASA INDONESIA
        a.putExtra(RecognizerIntent.EXTRA_LANGUAGE, new Locale("id", "ID"));
        //memberi judul dialog
        a.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech to Text");

        try {
            //memulai speech to text
            startActivityForResult(a, 100);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100 : {
                if (resultCode == RESULT_OK && data != null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtstt.setText(result.get(0));
                }
            }
            break;
        }
    }
}