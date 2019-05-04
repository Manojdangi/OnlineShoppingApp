package com.example.onlineclothingshoppingapp;

public class ItemModel {
    private String ItemName,ItemPrice,ItemDescription;
    private int ImageName;

    public ItemModel(String itemName, String itemPrice, String itemDescription, int imageName) {
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemDescription = itemDescription;
        ImageName = imageName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public void setImageName(int imageName) {
        ImageName = imageName;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public int getImageName() {
        return ImageName;
    }
}
