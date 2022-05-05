package com.example.kenyabestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VenueDetails extends AppCompatActivity {
    TextView mNoter, dets;
    ImageView img;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_details);
        mNoter = (TextView) findViewById(R.id.textView34);
        img = (ImageView) findViewById(R.id.card);
        dets = (TextView) findViewById(R.id.dets);
        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showDetail = new Intent(VenueDetails.this, HomePage.class);
                startActivity(showDetail);
            }
        });

        String mNoteInitial = getIntent().getExtras().getString("selected_note");
        String details = getIntent().getExtras().getString("selected_detail");
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            int res = bundle.getInt("selected_image");
            img.setImageResource(res);
        }


        mNoter.setText( mNoteInitial);
        dets.setText(details);


    }
}