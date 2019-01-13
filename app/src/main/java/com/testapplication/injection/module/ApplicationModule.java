package com.testapplication.injection.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

}