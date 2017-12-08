package com.example.cheolmin.lolwikipedia;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        GridView = (Bundle) findViewById(R.id.gridview);
        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("strName")!= null)
        {
            //TODO here get the string stored in the string variable and do
            // setText() on userName
        }
    }


}
