package com.example.proga.urbanhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class patorka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patorka);
        Button btntext = (Button)findViewById(R.id.btntext);
        final TextView results = (TextView)findViewById(R.id.results);
        btntext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                results.setText("Результат: вы 36 из 56");
            }
        });
        Button button = (Button)findViewById(R.id.dop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapintent = new Intent(patorka.this,MapsActivity.class);
                startActivity(mapintent);

            }
        });
    }
}
