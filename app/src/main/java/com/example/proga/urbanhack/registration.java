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

public class registration extends AppCompatActivity {
    private Button btnreg;
    private EditText regmail,pass1,conf_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        final ArrayList<String> userPpassword = loadArrayList("userPpassword"); // загружаем
        final ArrayList<String> userMail = loadArrayList("userMail"); // загружаем

        regmail = (EditText)findViewById(R.id.regmail);
        pass1 = (EditText)findViewById(R.id.pass1);
        conf_pass = (EditText)findViewById(R.id.conf_pass);

        btnreg = (Button)findViewById(R.id.btnreg);
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (regmail.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Введите Логин", Toast.LENGTH_LONG).show();
                } else if (pass1.getText().toString().equals("") || conf_pass.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Введите Пароль", Toast.LENGTH_LONG).show();
                } else if (!pass1.getText().toString().equals(conf_pass.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Пароли не совпадают", Toast.LENGTH_LONG).show();
                } else {
                    int indexsignup = userMail.indexOf(regmail.getText().toString());
                    if (indexsignup >= 0) {
                        Toast.makeText(getApplicationContext(), "Такой аккаунт уже существует", Toast.LENGTH_LONG).show();
                    } else {
                        userPpassword.add(0, pass1.getText().toString());
                        userMail.add(0, pass1.getText().toString());
                        saveArrayList("userPpassword", userPpassword); // сохраняем
                        saveArrayList("userLogin", userMail); // сохраняем
                        //Toast.makeText(getApplicationContext(), Integer.toString(userLogin.indexOf(newlog.getText().toString())), Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(), Integer.toString(userPpassword.indexOf(newpass1.getText().toString())), Toast.LENGTH_LONG).show();
                        Intent newregintent = new Intent(registration.this,
                                base.class);
                        startActivity(newregintent);
                    }
                }
            }
        });

    }
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
