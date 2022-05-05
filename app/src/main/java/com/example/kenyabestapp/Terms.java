package com.example.kenyabestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Terms extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        webView =findViewById(R.id.pirv);
        webView.loadUrl("file:///android_asset/tems.html");

        Button back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showDetail = new Intent(Terms.this, Settings.class);
                startActivity(showDetail);
                overridePendingTransition(R.anim.toleft, R.anim.toright);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.toleft, R.anim.toright);
        return;
    }
}