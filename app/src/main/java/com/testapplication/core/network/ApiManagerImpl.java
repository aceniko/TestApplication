package com.testapplication.core.network;

import android.content.Context;

import com.testapplication.core.models.api.AuthenticateModel;
import com.testapplication.core.models.api.AuthenticateResultModel;
import com.testapplication.core.models.api.PagedResultDtoProduct;
import com.testapplication.core.network.service.AuthService;
import com.testapplication.core.network.service.ProductService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class ApiManagerImpl implements ApiManager {

    private final AuthService mAuthService;
    private final ProductService mProductService;
    private final Context mContext;

    @Inject
    public ApiManagerImpl(Context context, AuthService authService, ProductService productService){
        mContext = context;
        mAuthService = authService;
        mProductService = productService;
    }

    @Override
    public Observable<AuthenticateResultModel> authenticate(AuthenticateModel authModel) {
        return mAuthService.authenticate(ApiEndPoints.ENDPOINT_AUTH, authModel);
    }

    @Override
    public Observable<PagedResultDtoProduct> getAllProductsPaged(int skipCount, int maxResultCount, String accessToken) {
        return mProductService.productsGetAll(ApiEndPoints.ENDPOINT_PRODUCTS_GET_ALL, accessToken, skipCount, maxResultCount);
    }
}
