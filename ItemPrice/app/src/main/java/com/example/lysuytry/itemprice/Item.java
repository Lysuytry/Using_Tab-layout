package com.example.lysuytry.itemprice;

/**
 * Created by Ly Suytry on 7/30/2016.
 */
public class Item {
    private String itemName;
    private int itemID;
    private int itemType;


    public Item(){

    }
    public Item(String name){
        this.itemName=name;
    }
    public Item(int id,String name){
        this.itemID=id;
        this.itemName=name;
    }
    public Item(int id,String name,int type){
        this.itemID=id;
        this.itemName=name;
        this.itemType=type;
    }
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

}
