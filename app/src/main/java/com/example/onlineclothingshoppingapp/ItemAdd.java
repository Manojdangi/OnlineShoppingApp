package com.example.onlineclothingshoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ItemAdd extends AppCompatActivity implements View.OnClickListener {
    private static final String FILE_NAME = "items.txt";

    EditText item_name, item_price, item_imagename, itemdescription;
    Button additem, showitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_add);

        item_name = findViewById(R.id.et_itemname);
        item_price = findViewById(R.id.et_itemprice);
        item_imagename = findViewById(R.id.et_itemimage_name);
        itemdescription = findViewById(R.id.et_imagedescription);
        additem = findViewById(R.id.btn_additem);
        showitem = findViewById(R.id.btn_showitem);

        additem.setOnClickListener(this);
        showitem.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_additem) {

            String value1 = item_name.getText().toString();
            String value2 = item_price.getText().toString();
            String value3 = item_imagename.getText().toString();
            String value4 = itemdescription.getText().toString();

            if (value1.isEmpty()) {
                item_name.setError("Enter the ItemName");
                item_name.requestFocus();
            } else if (value2.isEmpty()) {
                item_price.setError("Enter the ItemPrice");
                item_price.requestFocus();
            } else if (value3.isEmpty()) {
                item_imagename.setError("Enter the ItemImageName");
                item_imagename.requestFocus();
            } else if (value4.isEmpty()) {
                itemdescription.setError("Enter the ItemDescription");
                itemdescription.requestFocus();
            } else {


                String data = value1 + "->" + value2 + "->" + value3 + "->" + value4;
                String item = null;
                try {

                    FileInputStream fis = openFileInput(FILE_NAME);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();

                    while ((item = br.readLine()) != null) {
                        sb.append(data).append("\n");
                        data = data + "\n" + item;
                    }

                    FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();

                    Toast.makeText(ItemAdd.this, "Saved to",
                            Toast.LENGTH_SHORT).show();
                    item_name.setText("");
                    item_price.setText("");
                    item_imagename.setText("");
                    itemdescription.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        if (view.getId() == R.id.btn_showitem) {
            Intent intent = new Intent(ItemAdd.this, DashBoard.class);
            startActivity(intent);
        }

    }

}


