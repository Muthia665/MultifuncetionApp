package com.example.user.multifuncetionapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.reza.multifunctionapp.R;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SMS extends AppCompatActivity {

    MaterialEditText txtpesan, txtno;
    Button btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        txtpesan = findViewById(R.id.txtpesan);
        txtno = findViewById(R.id.txtnumber);
        btnsend = findViewById(R.id.btnsend);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
// //mengecek versi android untuk meminta permission
// if (Build.VERSION.SDK_INT >= M && checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
// requestPermissions(new String[] {Manifest.permission.SEND_SMS, Manifest.permission.SEND_SMS},120);
// }else {
// try {
// SmsManager sms = SmsManager.getDefault();
// //untuk mengirim sms
// sms.sendTextMessage(txtno.getText().toString(),null,txtpesan.getText().toString(),null,null);
// } catch (Exception e){
// Toast.makeText(SMSActivity.this, "Failed", Toast.LENGTH_SHORT).show();
// }
// }

                Intent a = new Intent(Intent.ACTION_VIEW);
                a.putExtra("sms_body", txtpesan.getText().toString());
                a.putExtra("address",txtno.getText().toString());
                a.setType("vnd.android-dir/mms-sms"); //type buat sms
                startActivity(a);

            }
        });
    }
}