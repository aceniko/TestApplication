package com.testapplication.core.network;

import com.testapplication.core.models.api.AuthenticateModel;
import com.testapplication.core.models.api.AuthenticateResultModel;
import com.testapplication.core.models.api.PagedResultDtoProduct;

import io.reactivex.Observable;


public interface ApiManager {
    Observable<AuthenticateResultModel> authenticate(AuthenticateModel authModel);
    Observable<PagedResultDtoProduct> getAllProductsPaged(int skipCount, int maxResultCount, String accessToken);

}
