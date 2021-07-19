package com.example.user.multifuncetionapp;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.reza.multifunctionapp.R;

public class Wifi extends AppCompatActivity {

    Switch wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        wifi = findViewById(R.id.switchwifi);

        wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//jika true
                if(isChecked) {
//menghidupkan wifi
                    setWifi(true);
                    Toast.makeText(Wifi.this,"wifi off",Toast.LENGTH_SHORT).show();
                }else {
                    setWifi(false);
                    Toast.makeText(Wifi.this, "wifi off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setWifi(boolean b) {

//memanggil wifi adapter yang telah disediakan android studio
        WifiManager wifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);

//jika wifi = true dan wifi dalam keadaan tidak aktif, maka dihidupkan
        if (b == true && !wifiManager.isWifiEnabled()){
            wifiManager.setWifiEnabled(true);
//jika wifi = false dan wifi dalam keadaan aktif, maka matikan
        }else if (b == false && wifiManager.isWifiEnabled()){
            wifiManager.setWifiEnabled(false);
        }
    }
}
