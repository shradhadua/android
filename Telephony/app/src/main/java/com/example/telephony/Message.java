package com.example.telephony;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Message extends AppCompatActivity {
    EditText e3, e4;
    Button b2;
    String phoneNo, message;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        e3 = findViewById(R.id.ph);
        e4 = findViewById(R.id.msg);
        b2 = findViewById(R.id.send_btn);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMSMessage();


            }
        });
    }

    protected void sendSMSMessage() {
        phoneNo = e3.getText().toString();
        message = e4.getText().toString();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

            } else ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.SEND_RESPOND_VIA_MESSAGE}, MY_PERMISSIONS_REQUEST_SEND_SMS);
        }
        ;
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case MY_PERMISSIONS_REQUEST_SEND_SMS:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo,null,message,null,null);
                    Toast.makeText(this, "SMS sent", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "SMS Failed, pleASE TRY AGAIN", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;

        }
    }
}