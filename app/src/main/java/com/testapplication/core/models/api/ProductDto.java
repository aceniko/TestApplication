package com.testapplication.core.models.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ProductDto implements Parcelable {
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

    public ProductDto(){}

    protected ProductDto(Parcel in) {
        name = in.readString();
        productNumber = in.readString();
        color = in.readString();
        standardCost = in.readDouble();
        listPrice = in.readDouble();
        weight = in.readDouble();
        dateCreated = in.readString();
        userComment = in.readString();
        isActive = in.readByte() != 0;
        isDeleted = in.readByte() != 0;
        id = in.readInt();
    }

    public static final Creator<ProductDto> CREATOR = new Creator<ProductDto>() {
        @Override
        public ProductDto createFromParcel(Parcel in) {
            return new ProductDto(in);
        }

        @Override
        public ProductDto[] newArray(int size) {
            return new ProductDto[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(productNumber);
        dest.writeString(color);
        dest.writeDouble(standardCost);
        dest.writeDouble(listPrice);
        dest.writeDouble(weight);
        dest.writeString(dateCreated);
        dest.writeString(userComment);
        dest.writeByte((byte) (isActive ? 1 : 0));
        dest.writeByte((byte) (isDeleted ? 1 : 0));
        dest.writeInt(id);
    }
}
