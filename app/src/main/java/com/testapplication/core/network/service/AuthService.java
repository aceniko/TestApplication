package com.testapplication.core.network.service;


import com.testapplication.core.models.api.AuthenticateModel;
import com.testapplication.core.models.api.AuthenticateResultModel;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface AuthService {
    @POST
    Observable<AuthenticateResultModel> authenticate(@Url String url, @Body AuthenticateModel request);
}
