package com.testapplication.injection.module;

import com.testapplication.core.network.ApiManager;
import com.testapplication.core.network.ApiManagerImpl;
import com.testapplication.core.network.service.AuthService;
import com.testapplication.core.network.service.ProductService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    @Provides
    @Singleton
    Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://test.madeinmacedonia.com.mk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public AuthService provideAuthService(Retrofit retrofit){
        return retrofit.create(AuthService.class);
    }

    @Provides
    @Singleton
    public ProductService provideProductService(Retrofit retrofit){
        return retrofit.create(ProductService.class);
    }

    @Provides
    @Singleton
    ApiManager provideApiManager(ApiManagerImpl apiManager) {
        return apiManager;
    }
}
