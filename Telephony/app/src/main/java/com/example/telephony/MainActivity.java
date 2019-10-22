package com.example.telephony;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText e1;
    //String s1;
    private static final int REQUEST_PHONE_CALL=1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.btn);
        e1=findViewById(R.id.phone);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                if(s1.length()==0||s1.length()<10){
                    //i.setData(Uri.parse("tel:9289252780"));
                    Toast.makeText(MainActivity.this, "Enter valid number", Toast.LENGTH_SHORT).show();

                }
                else {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", s1, null));
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
                    } else {
                        startActivity(intent);
                    }
                }
            }
        });
    }

    }


