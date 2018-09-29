package com.example.proga.urbanhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button log , reg;
    private EditText pass, mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log = (Button)findViewById(R.id.log);
        reg = (Button)findViewById(R.id.registr);
        pass = (EditText)findViewById(R.id.in_pass);
        mail = (EditText)findViewById(R.id.in_mail);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String in_mail, in_pass;
                int count=0;
                in_mail = mail.getText().toString();
                in_pass = pass.getText().toString();
                if (in_mail == "") {
                    Toast.makeText(getApplicationContext(),"No email",Toast.LENGTH_LONG).show();
                }
                if (in_pass == "") {
                    Toast.makeText(getApplicationContext(),"No password",Toast.LENGTH_LONG).show();
                }
                if (in_pass.length()<8){
                    Toast.makeText(getApplicationContext(),"Write your password more then 7 symbols",Toast.LENGTH_LONG).show();
                }
                if (in_mail == "magnit@mail.com" && in_pass == "12345678"){
                    Intent adminintent = new Intent(MainActivity.this, admin_base.class);
                    startActivity(adminintent);
                }
                else{
                    Intent userintent = new Intent(MainActivity.this, user_base.class);
                    startActivity(userintent);
                }
            }
        });


    }
}
