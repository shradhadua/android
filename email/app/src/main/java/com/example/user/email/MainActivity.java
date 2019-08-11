package com.example.user.email;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText recip,subject,body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button send;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recip=findViewById(R.id.to);
        subject=findViewById(R.id.subject);
      body=findViewById(R.id.body);
        send=findViewById(R.id.sendmail);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   String recipient= recip.getText().toString();
                String sub=subject.getText().toString();
                 String content=body.getText().toString();


                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");

                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{recipient});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Your Subject"+"\t"+sub);
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Email message goes here:"+"\t"+content);

                try{
                    startActivity(Intent.createChooser(emailIntent,"SendMail"));
                    finish();
                    Log.i("","");

                }catch(android.content.ActivityNotFoundException ex){
                    Toast.makeText(MainActivity.this, "No email client installed", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
