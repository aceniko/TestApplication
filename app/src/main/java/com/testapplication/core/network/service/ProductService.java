package com.testapplication.core.network.service;

import com.testapplication.constants.Constants;
import com.testapplication.core.models.api.PagedResultDtoProduct;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ProductService {
    @GET
    Observable<PagedResultDtoProduct> productsGetAll(@Url String url, @Header(Constants.AUTHORIZATION) String authorization, @Query(Constants.SKIP_COUNT) int skipCount, @Query(Constants.MAX_RESULT_COUNT) int maxResultCount);

}
