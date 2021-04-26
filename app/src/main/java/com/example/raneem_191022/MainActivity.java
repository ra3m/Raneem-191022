package com.example.raneem_191022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //String userid, key2update, value2;
    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Firebase Connection Success", Toast.LENGTH_LONG).show();

        btn = (Button)findViewById(R.id.fetchbtn);
        btn2 = (Button)findViewById(R.id.editbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirebaseList.class));
                //Toast.makeText(MainActivity.this, "Your Driving License will expire soon.", Toast.LENGTH_LONG).show();
            }
    });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}


/*
package com.example.sel10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.annotation.NonNull;

public class MainActivity extends AppCompatActivity {
    String username, usermail, userpass;
    FirebaseAuth Auth = FirebaseAuth.getInstance();
    FirebaseUser currentUser = Auth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name=(EditText)findViewById(R.id.user);
        EditText email=(EditText)findViewById(R.id.email);
        EditText pass=(EditText)findViewById(R.id.pass);
        Button sign=(Button)findViewById(R.id.button);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().isEmpty()|| email.getText().toString().isEmpty() ||pass.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Empty Fields are needed to register", Toast.LENGTH_LONG).show();
                }
                else {
                    username = name.getText().toString();
                    usermail = email.getText().toString();
                    userpass = pass.getText().toString();
                    addUser(usermail,userpass);
                }}});}


    public void addUser(String user_email,String user_pass){
        Auth.createUserWithEmailAndPassword(user_email, user_pass)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            currentUser = Auth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "Successful registration. " + currentUser.getEmail() + " is now added to the company's chatting application ", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "User Already Exists!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }}

 */