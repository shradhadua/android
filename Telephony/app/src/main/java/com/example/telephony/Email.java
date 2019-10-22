package com.example.telephony;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Email extends AppCompatActivity {
     EditText to, sub, body;
     Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        to=findViewById(R.id.to);
        sub=findViewById(R.id.subject);
        body=findViewById(R.id.body);
        btn=findViewById(R.id.send_email);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=to.getText().toString();
                String b=body.getText().toString();
                String s=sub.getText().toString();
                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{t});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Your Subject"+s);
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Your email message:"+b);
                try {
                    startActivity(Intent.createChooser(emailIntent,"Send Email..."));
                    finish();
                    Log.i("","");
                }catch(android.content.ActivityNotFoundException ex){
                    Toast.makeText(Email.this, "there is no email client installed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
