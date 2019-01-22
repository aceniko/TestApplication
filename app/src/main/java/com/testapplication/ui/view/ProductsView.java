package com.testapplication.ui.view;

import com.testapplication.core.models.api.ProductDto;
import com.testapplication.ui.view.base.BaseView;

import java.util.ArrayList;

public interface ProductsView extends BaseView {
    void getAllProducts();
    void getFilteredProducts(ArrayList<String> filters);    //TODO: KeyValue filters
    void editProduct(String productId, ProductDto productDto);
    void addProduct(ProductDto productDto);
    void deleteProduct(String productId);
}
