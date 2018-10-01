package com.example.proga.urbanhack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private Button log , reg;
    private EditText pass, mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> userPpassword = loadArrayList("userPpassword"); // загружаем
        final ArrayList<String> userMail = loadArrayList("userMail"); // загружаем

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
                else{
                    int index = userMail.indexOf(mail.getText().toString());
                    if (index >= 0) {
                        if (pass.getText().toString().equals(userPpassword.get(index))) {
                            Intent userintent = new Intent(MainActivity.this, base.class);
                            startActivity(userintent);
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Вы не зарегистрированы", Toast.LENGTH_LONG).show();}
                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regintent = new Intent(MainActivity.this,registration.class);
                startActivity(regintent);
            }
        });


    }

    //------------------
    // сохраняем
    private void saveArrayList(String name, ArrayList<String> list) {
        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s).append("<s>");
        if (list.size() > 0) sb.delete(sb.length() - 3, sb.length());
        editor.putString(name, sb.toString()).apply();
    }
    // загружаем
    private ArrayList<String> loadArrayList(String name) {
        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String[] strings = prefs.getString(name, "").split("<s>");
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(strings));
        return list;
    }
}
