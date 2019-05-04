package com.example.onlineclothingshoppingapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    List<ItemModel> itemlist;
    Context context;

    public ItemAdapter(List<ItemModel> itemlist, Context context) {
        this.itemlist = itemlist;

        /*for letting user to pass to other activity*/
        this.context=context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_sample, viewGroup,false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder itemViewHolder, int i) {
        final ItemModel itemModel= itemlist.get(i);

        itemViewHolder.ItemName.setText(itemModel.getItemName());
        itemViewHolder.Price.setText(itemModel.getItemPrice());
        itemViewHolder.Description.setText(itemModel.getItemDescription());
        itemViewHolder.ItemImage.setImageResource(itemModel.getImageName());

        itemViewHolder.ItemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=v.getContext();

                Intent intent=new Intent(context,ItemDisplay.class);
                intent.putExtra("ItemName",itemModel.getItemName());
                intent.putExtra("Price",itemModel.getItemPrice());
                intent.putExtra("Description",itemModel.getItemDescription());
                intent.putExtra("ItemImage",itemModel.getImageName());
                context.startActivity(intent);


                //Toast.makeText(context, "Clicked on "+itemModel.getItemName(), Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView ItemName, Price,Description;
        public ImageView ItemImage;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ItemName=itemView.findViewById(R.id.txt_itemname);
            Price=itemView.findViewById(R.id.txt_price);
            Description=itemView.findViewById(R.id.txt_description);
            ItemImage= itemView.findViewById(R.id.txt_itemimage);


        }
    }


}
