package com.example.raneem_191022;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private EditText UserIDText;
    private EditText FirstNameText;
    private EditText LastNameText;
    private EditText PhoneNoText;
    private EditText EmailText;
    private Button btnAdd;
    private Button btnBack;
    private Button btnUpdate;
    private Button btnDelete;
    private String key;
    private String userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        key = getIntent().getStringExtra("key");
        userId = getIntent().getStringExtra("userID");
        firstName = getIntent().getStringExtra("firstName");
        lastName = getIntent().getStringExtra("lastName");
        phoneNumber  = getIntent().getStringExtra("phoneNumber");
        emailAddress = getIntent().getStringExtra("emailAddress");

        UserIDText = (EditText) findViewById(R.id.insertId);
        FirstNameText = (EditText) findViewById(R.id.insertFirst);
        LastNameText = (EditText) findViewById(R.id.insertLast);
        PhoneNoText = (EditText) findViewById(R.id.insertPhone);
        EmailText = (EditText) findViewById(R.id.insertMail);

        btnAdd = (Button) findViewById(R.id.addbtn);
        btnBack = (Button) findViewById(R.id.backbtn);
        btnUpdate = (Button) findViewById(R.id.updatebtn);
        btnDelete = (Button) findViewById(R.id.deletebtn);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase user = new FirebaseDatabase();
                user.setUserId(UserIDText.getText().toString());
                user.setFirstName(FirstNameText.getText().toString());
                user.setLastName(LastNameText.getText().toString());
                user.setPhoneNumber(PhoneNoText.getText().toString());
                user.setEmailAddress(EmailText.getText().toString());
                new FirebaseDatabaseHelper().addUser(user, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<FirebaseDatabase> users, List<String> keys) {
                        Toast.makeText(SecondActivity.this, "User has been added!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); return;
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase user = new FirebaseDatabase();
                user.setUserId(UserIDText.getText().toString());
                user.setFirstName(FirstNameText.getText().toString());
                user.setLastName(LastNameText.getText().toString());
                user.setPhoneNumber(PhoneNoText.getText().toString());
                user.setEmailAddress(EmailText.getText().toString());

                new FirebaseDatabaseHelper().updateUser(key, user, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<FirebaseDatabase> users, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(SecondActivity.this, "User has been updated!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelper().deleteUser(key, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<FirebaseDatabase> users, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(SecondActivity.this, "User has been deleted!", Toast.LENGTH_LONG).show();
                        finish(); return;
                    }
                });
            }
        });
    }
}