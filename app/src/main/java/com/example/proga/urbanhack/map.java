package com.example.proga.urbanhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        WebView web = (WebView)findViewById(R.id.webview);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://yandex.ru/maps/213/moscow/?ll=37.505264%2C55.808830&z=16&mode=routes&rtext=55.811680%2C37.502471~55.805349%2C37.509277&rtt=auto");
    }
}
