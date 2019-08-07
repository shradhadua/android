package com.example.user.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton(){
        Button login = findViewById(R.id.b1);
         final EditText n = findViewById(R.id.name);
        final EditText b = findViewById(R.id.batch);
        final EditText y = findViewById(R.id.year);
        final EditText c = findViewById(R.id.course);
        final EditText p = findViewById(R.id.phn);
        final EditText a = findViewById(R.id.add);


        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if((n.getText().toString()==null||n.getText().toString().isEmpty())||(c.getText().toString()==null||c.getText().toString().isEmpty())||(p.getText().toString()==null||p.getText().toString().isEmpty())||(b.getText().toString()==null||b.getText().toString().isEmpty())||(y.getText().toString()==null||y.getText().toString().isEmpty())||(a.getText().toString()==null||a.getText().toString().isEmpty()))
                    Toast.makeText(getApplicationContext(), "Enter all the credentials", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent i =new Intent(getApplicationContext(),SecondActivity.class);
                    i.putExtra("NAME",n.getText().toString());
                    i.putExtra("NAME",n.getText().toString());
                    i.putExtra("Batch",b.getText().toString());
                    i.putExtra("Year",y.getText().toString());
                    i.putExtra("Course",c.getText().toString());
                    i.putExtra("Phone",p.getText().toString());
                    i.putExtra("Address",a.getText().toString());

                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Activity 2 called", Toast.LENGTH_SHORT).show();}





            }
            });
    }
}
