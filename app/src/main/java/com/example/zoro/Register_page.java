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

public class Register_page extends AppCompatActivity {

    MaterialButton register;
    EditText uname,psw,rpsw;
    String u,p,rp;
    TextView gologin;

    public SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        DBhelper mydb = new DBhelper(this);
        db = mydb.getWritableDatabase();
        db = mydb.getReadableDatabase();

        uname = (EditText) findViewById(R.id.uname);
        psw = (EditText) findViewById(R.id.psw);
        rpsw = (EditText) findViewById(R.id.rpsw);
        register = (MaterialButton) findViewById(R.id.butt);
        gologin = (TextView) findViewById(R.id.go_login);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u = uname.getText().toString();
                p = psw.getText().toString();
                rp = rpsw.getText().toString();


                if(u.equals("") || p.equals("") || rpsw.equals("")) {
                    Toast.makeText(Register_page.this, "Enter Details", Toast.LENGTH_SHORT).show();
                } else if (p.equals(rp)) {
                    Boolean checkUser = mydb.checkUsername(u);
                    if(checkUser == false){
                        Boolean insert = mydb.insertData(u,p);
                        Toast.makeText(Register_page.this, "Registered", Toast.LENGTH_SHORT).show();
                        openNew();
                    }else {Toast.makeText(Register_page.this, "Try Different Name", Toast.LENGTH_SHORT).show();}
                } else {Toast.makeText(Register_page.this, "Wrong Password", Toast.LENGTH_SHORT).show();                }
            }
        });

        gologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void openNew() {
        Intent i = new Intent(this, Login_page.class);
        startActivity(i);
    }

    public void register(){
        startActivity(new Intent(this, Login_page.class));
    }
}