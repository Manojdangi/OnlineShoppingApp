package com.example.onlineclothingshoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDisplay extends AppCompatActivity {
    TextView ItemName, Price,Description;
    ImageView ItemImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);

        ItemName=findViewById(R.id.itemname);
        Price=findViewById(R.id.price);
        Description=findViewById(R.id.description);
        ItemImage=findViewById(R.id.itemimage);
        Bundle bundle=getIntent().getExtras();

        if (bundle!=null){
            ItemName.setText(bundle.getString("ItemName"));
            Price.setText(bundle.getString("Price"));
            Description.setText(bundle.getString("Description"));
            ItemImage.setImageResource(bundle.getInt("ItemImage"));

        }
    }
}
