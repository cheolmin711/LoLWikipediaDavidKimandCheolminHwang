package com.example.cheolmin.lolwikipedia;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();

        Champion c = getIntent().getParcelableExtra("champion");
        textView.setText(c.getName());

        Champion champion1 = (Champion)getIntent().getSerializableExtra("info");

        if(bundle.getString("ChampName")!= "amumusquare");
        {
            Toast.makeText(this, c.getName(), Toast.LENGTH_SHORT).show();

            //here get the string stored in the string variable and do
            // setText() on userName
        }
    }


}
