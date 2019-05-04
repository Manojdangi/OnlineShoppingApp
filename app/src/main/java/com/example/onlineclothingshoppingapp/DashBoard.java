package com.example.onlineclothingshoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashBoard extends AppCompatActivity {

    RecyclerView recyclerview;
    List<ItemModel> itemlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        recyclerview= findViewById(R.id.recycler_view);

        prepareItemList();
        recyclerview.setLayoutManager(new GridLayoutManager(this,3));
        recyclerview.setAdapter(new ItemAdapter(itemlist, getApplicationContext()));

    }

    public void prepareItemList(){
//        itemlist.add(new ItemModel("Shirt","2000","This is good shirt",R.drawable.shirt1));
//        itemlist.add(new ItemModel("Vest","1000","This is good shirt",R.drawable.vest1));

        String lines = null;
        Map<String, String> items = new HashMap<>();


        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("items.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while ((lines = bufferReader.readLine()) != null) {
                stringBuilder.append(lines).append("\n");
                String[] parts = lines.split("->");


                items.put("name", parts[0]);
                items.put("price", parts[1]);
                items.put("img",parts[2]);
                items.put("desc", parts[3]);

                String img= items.get("img");
                int image_of_an_item = getResources().getIdentifier(img, "drawable", getPackageName());

                itemlist.add(new ItemModel(items.get("name"), items.get("price"), items.get("desc"),image_of_an_item));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
