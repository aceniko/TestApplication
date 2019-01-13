package com.testapplication.core.models.api;

import com.google.gson.annotations.SerializedName;

public class ProductDto {
    @SerializedName("name")
    private String name;
    @SerializedName("productNumber")
    private String productNumber;
    @SerializedName("color")
    private String color;
    @SerializedName("standardCost")
    private double standardCost;
    @SerializedName("listPrice")
    private double listPrice;
    @SerializedName("weight")
    private double weight;
    @SerializedName("dateCreated")
    private String dateCreated;
    @SerializedName("userComment")
    private String userComment;
    @SerializedName("isActive")
    private boolean isActive;
    @SerializedName("isDeleted")
    private boolean isDeleted;
    @SerializedName("id")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(double standardCost) {
        this.standardCost = standardCost;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
