package com.demo.qvcreplicate;

import java.io.Serializable;

import javax.inject.Inject;

public class Item implements Serializable {

    private String itemName;
    private String itemURL;
    private Double itemPreviousPrice;
    private  Double itemSalePrice;
    private String itemDescription;


    @Inject
    public Item(String itemName, String itemURL, Double itemPreviousPrice, Double itemSalePrice, String itemDescription) {
        this.itemName = itemName;
        this.itemURL = itemURL;
        this.itemPreviousPrice = itemPreviousPrice;
        this.itemSalePrice = itemSalePrice;
        this.itemDescription = itemDescription;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemURL() {
        return itemURL;
    }

    public void setItemURL(String itemURL) {
        this.itemURL = itemURL;
    }

    public Double getItemPreviousPrice() {
        return itemPreviousPrice;
    }

    public void setItemPreviousPrice(Double itemPreviousPrice) {
        this.itemPreviousPrice = itemPreviousPrice;
    }

    public Double getItemSalePrice() {
        return itemSalePrice;
    }

    public void setItemSalePrice(Double itemSalePrice) {
        this.itemSalePrice = itemSalePrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
