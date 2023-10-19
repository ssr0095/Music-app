package com.example.zoro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Login_page extends AppCompatActivity {

    MaterialButton butt;
    EditText uname,psw;
    TextView goregister;

    String u,p,rp;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        DBhelper mydb = new DBhelper(this);
        db = mydb.getWritableDatabase();
        db = mydb.getReadableDatabase();

        uname = (EditText) findViewById(R.id.uname);
        psw = (EditText) findViewById(R.id.psw);
        butt = (MaterialButton) findViewById(R.id.butt);
        goregister = (TextView) findViewById(R.id.go_register);

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u = uname.getText().toString();
                p = psw.getText().toString();


                if(u.equals("") || p.equals("")) {
                    Toast.makeText(Login_page.this, "Enter Details", Toast.LENGTH_SHORT).show();
                } else{
                    Boolean checkup = mydb.checkUsernamepass(u,p);
                    if(checkup == true){
                    Toast.makeText(Login_page.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    home();
                    } else {Toast.makeText(Login_page.this, "Wrong Password", Toast.LENGTH_SHORT).show();                }
                }
            }
        });

        goregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    public void home(){
        Intent i = new Intent(this, Song_home.class);
        startActivity(i);
    }
    public void login(){
        startActivity(new Intent(this, Register_page.class));
    }
}