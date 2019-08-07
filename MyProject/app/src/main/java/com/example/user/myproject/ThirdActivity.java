package com.example.user.myproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TextView name2=findViewById(R.id.n2);
        TextView batch2=findViewById(R.id.b2);
        TextView year2=findViewById(R.id.y2);
        TextView course2=findViewById(R.id.c2);
        TextView phone2=findViewById(R.id.p2);
        TextView add2=findViewById(R.id.a2);
        TextView user2=findViewById(R.id.u2);
        TextView pass2=findViewById(R.id.pass2);

        Bundle extras = getIntent().getExtras();
        String name=extras.getString("name");
        String batch=extras.getString("batch");
        String year=extras.getString("year");
        String course=extras.getString("course");
        String phone=extras.getString("phone");
        String address=extras.getString("address");
        String user=extras.getString("Username");
        String pass=extras.getString("Password");

        name2.setText("NAME: "+name);
        batch2.setText("BATCH: "+batch);
        year2.setText("YEAR: "+year);
        course2.setText("COURSE: "+ course);
        phone2.setText("PHONE: "+phone);
        add2.setText("ADDRESS: "+address);
        user2.setText("USERNAME: "+user);
        pass2.setText("PASSWORD: "+pass);

    }
}
