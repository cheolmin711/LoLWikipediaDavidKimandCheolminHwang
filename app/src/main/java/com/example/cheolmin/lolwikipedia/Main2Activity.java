package com.example.cheolmin.lolwikipedia;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView name = findViewById(R.id.textView2);
        ImageView champion = findViewById(R.id.imageView2);
        ImageView item1 = findViewById(R.id.itemView1);
        ImageView item2 = findViewById(R.id.itemView2);
        ImageView item3 = findViewById(R.id.itemView3);
        ImageView item4 = findViewById(R.id.itemView4);
        ImageView item5 = findViewById(R.id.itemView5);
        ImageView item6 = findViewById(R.id.itemView6);
        TextView item1desc = findViewById(R.id.textItem1);
        TextView item2desc = findViewById(R.id.textItem2);
        TextView item3desc = findViewById(R.id.textItem3);
        TextView item4desc = findViewById(R.id.textItem4);
        TextView item5desc = findViewById(R.id.textItem5);
        TextView item6desc = findViewById(R.id.textItem6);
        TextView description = findViewById(R.id.textView3);
        Bundle bundle = getIntent().getExtras();

        Champion c = getIntent().getParcelableExtra(MainActivity.EXTRA_MESSAGE);
        Item item = getIntent().getParcelableExtra(MainActivity.EXTRA_ITEM);
        name.setText(c.getName());
        champion.setImageResource(c.getImageid());
        item1.setImageResource(c.getItem1().getImageIdItem());
        item2.setImageResource(c.getItem2().getImageIdItem());
        item3.setImageResource(c.getItem3().getImageIdItem());
        item4.setImageResource(c.getItem4().getImageIdItem());
        item5.setImageResource(c.getItem5().getImageIdItem());
        item6.setImageResource(c.getItem6().getImageIdItem());
        item1desc.setText(c.getItem1().getName());
        item2desc.setText(c.getItem2().getName());
        item3desc.setText(c.getItem3().getName());
        item4desc.setText(c.getItem4().getName());
        item5desc.setText(c.getItem5().getName());
        item6desc.setText(c.getItem6().getName());

        description.setText(c.getDescription());

        //String newString;
//        if (savedInstanceState == null) {
//            Bundle extras = getIntent().getExtras();
//
//            if(extras == null) {
//                newString= null;
//                c.getName();
//                System.out.println(c.getName());
//            } else {
//                newString= extras.getString("com.example.myfirstapp.MESSAGE");
//            }
//        } else {
//            newString= (String) savedInstanceState.getSerializable("com.example.myfirstapp.MESSAGE");
//        }


        //Champion champion1 = (Champion)getIntent().getSerializableExtra("info");

        //if(bundle.get());
        // {
        //Toast.makeText(this, c.getName(), Toast.LENGTH_SHORT).show();

        //here get the string stored in the string variable and do
        // setText() on userName
        //}
    }


}