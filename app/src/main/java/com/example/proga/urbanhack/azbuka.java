package com.example.proga.urbanhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class azbuka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azbuka);
        Button btntext = (Button)findViewById(R.id.btntext);
        final TextView results = (TextView)findViewById(R.id.results);
        btntext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                results.setText("Результат: вы 16 из 15");
            }
        });
        Button button = (Button)findViewById(R.id.dop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapintent = new Intent(azbuka.this,map.class);
                startActivity(mapintent);

            }
        });
    }
}
