package com.example.user.myproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         EditText name1 = findViewById(R.id.n1);


        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("NAME");



        name1.setText(value1);
        addListener();}
        public void addListener(){
        Button show = findViewById(R.id.show);
          final   EditText username=findViewById(R.id.u1);
           final EditText password=findViewById(R.id.pass);
          final   EditText confirm=findViewById(R.id.confirm);



        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Bundle extras = getIntent().getExtras();
                String value1 = extras.getString("NAME");
                String value2 = extras.getString("Batch");
                String value3 = extras.getString("Year");
                String value4 = extras.getString("Course");
                String value5 = extras.getString("Phone");
                String value6 = extras.getString("Address");
                String value7 = password.getText().toString();
                String value8 = confirm.getText().toString();






                    Intent k= new Intent(SecondActivity.this,ThirdActivity.class);
                    k.putExtra("Username",username.getText().toString());
                    k.putExtra("Password",password.getText().toString());
                    k.putExtra("name", value1);
                    k.putExtra("batch",value2);
                    k.putExtra("year",value3);
                    k.putExtra("course",value4);
                    k.putExtra("phone",value5);
                    k.putExtra("address",value6);

                progressDialog = new ProgressDialog(SecondActivity.this);
                progressDialog.setMax(100);
                progressDialog.setTitle("ProgressDialog");
                progressDialog.setMessage("Loading");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();

                if(progressDialog.getProgress()==progressDialog.getMax())
                    progressDialog.dismiss();


                if(value7.equals(value8))
                {
                    startActivity(k);
                    Toast.makeText(getApplicationContext(), "Activity 3 called", Toast.LENGTH_SHORT).show();}
                else
                    Toast.makeText(SecondActivity.this, "Both passwords should be same", Toast.LENGTH_SHORT).show();





            }
        });

    }

    }


