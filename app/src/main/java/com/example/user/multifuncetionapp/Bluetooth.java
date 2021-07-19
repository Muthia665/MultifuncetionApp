package com.example.user.multifuncetionapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.reza.multifunctionapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Bluetooth extends AppCompatActivity {

    Button btnon, btnoff, btnvisible, btnlist;
    ListView listView;

    //deklarasi kelas bluetooth
    BluetoothAdapter BT;

    //untuk menampilkan data array device yang terhubung
    Set<BluetoothDevice> paired;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        btnon = findViewById(R.id.btnon);
        btnoff = findViewById(R.id.btnoff);
        btnvisible = findViewById(R.id.btnvisible);
        btnlist = findViewById(R.id.btnlist);
        listView = findViewById(R.id.ListView);

//inisialisasi class bluethooth
        BT = BluetoothAdapter.getDefaultAdapter();

        btnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//jika bluetooth belum aktif
                if (!BT.isEnabled()) {
//mengaktifkan bluetooth
                    Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//mengangkut pengembalian dari class blurtooth adapter
                    startActivityForResult(turnOn, 0);
                    Toast.makeText(Bluetooth.this, "Bluetooth on", Toast.LENGTH_SHORT).show();
                } else {
//jika bluetooth sudah aktif
                    Toast.makeText(Bluetooth.this, "Bluatooth already on", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT.disable();
                Toast.makeText(Bluetooth.this, "Bluetooth off", Toast.LENGTH_SHORT).show();
            }
        });

        btnvisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}