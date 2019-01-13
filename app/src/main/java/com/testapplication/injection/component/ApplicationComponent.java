package com.testapplication.injection.component;

import android.app.Application;

import com.testapplication.injection.module.ActivityModule;
import com.testapplication.injection.module.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApiModule.class
        }
)
public interface ApplicationComponent {
    void inject(Application application);
    ActivityComponent plus(ActivityModule activityModule);
}
