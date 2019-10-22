package com.example.sqlitedb;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editCompanyname, editPhno, editDesignation, editText_id, editText_up_id;
    Button btnAddData, button_read, button_delete, button_update, button_deleteAll;
    private SQLiteDatabase sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        editName = (EditText) findViewById(R.id.editText_name);
        editCompanyname = (EditText) findViewById(R.id.editText_companyname);
        editPhno = (EditText) findViewById(R.id.editText_phno);
        editDesignation = (EditText) findViewById(R.id.editText_designation);
        btnAddData = (Button) findViewById(R.id.button_add);
        AddData();

        button_read = findViewById(R.id.button_read);
        viewALL();

        editText_id = findViewById(R.id.editText_id);
        button_delete = findViewById(R.id.button_delete);
        delete();

        editText_up_id = findViewById(R.id.editText_up_id);
        button_update = findViewById(R.id.button_update);
        update();

        button_deleteAll = findViewById(R.id.button_deleteAll);
        button_deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDb.DeleteAll();
                Toast.makeText(MainActivity.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void update() {
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idd = editText_up_id.getText().toString();

                if (TextUtils.isEmpty(idd)) {
                    Toast.makeText(MainActivity.this, "give id", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isUpdate = myDb.updateData(editText_up_id.getText().toString(), editName.getText().toString()
                        , editCompanyname.getText().toString()
                        , editDesignation.getText().toString()
                        , editPhno.getText().toString());

                if (isUpdate == true) {

                    editName.setText("");
                    editCompanyname.setText("");
                    editDesignation.setText("");
                    editPhno.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void delete() {
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editText_id.getText().toString();
                int result = myDb.deleteData(id);
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                editText_id.setText("");
            }
        });

    }

    private void viewALL() {
        button_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor resn = myDb.getAllData();
                if (resn.getCount() == 0) {
                    showMessage("Alert", "Nothing");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (resn.moveToNext()) {
                    buffer.append("Id :" + resn.getString(0) + "\n");
                    buffer.append("Name :" + resn.getString(1) + "\n");
                    buffer.append("Company Name :" + resn.getString(2) + "\n");
                    buffer.append("Designation :" + resn.getString(3) + "\n");
                    buffer.append("Contact Num :" + resn.getString(4) + "\n\n");
                }

// Show all data
                showMessage("Data", buffer.toString());
            }
        });
    }


    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = editName.getText().toString();
                        String company = editCompanyname.getText().toString();
                        String des = editDesignation.getText().toString();
                        String phno = editPhno.getText().toString();

                        if (TextUtils.isEmpty(name)) {
                            Toast.makeText(MainActivity.this, "Plase enter the Name", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if (TextUtils.isEmpty(company)) {
                            Toast.makeText(MainActivity.this, "Plase enter the Company Name", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if (TextUtils.isEmpty(des)) {
                            Toast.makeText(MainActivity.this, "Plase enter the Desigantion", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if (TextUtils.isEmpty(phno)) {
                            Toast.makeText(MainActivity.this, "Plase enter the Contact Number", Toast.LENGTH_LONG).show();
                            return;
                        }
                        boolean isInserted = myDb.insertData(name, company, des, phno);
                        if (isInserted == true) {
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            editName.setText("");
                            editDesignation.setText("");
                            editPhno.setText("");
                            editCompanyname.setText("");
                        } else
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}