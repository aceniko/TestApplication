package com.testapplication.core.models.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PagedResultDtoProduct {
    @SerializedName("totalCount")
    private int totalCount;
    @SerializedName("items")
    private List<ProductDto> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<ProductDto> getItems() {
        return items;
    }

    public void setItems(List<ProductDto> items) {
        this.items = items;
    }
}
