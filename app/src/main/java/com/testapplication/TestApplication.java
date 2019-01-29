package com.testapplication;

import android.app.Application;
import android.content.Context;

import com.testapplication.injection.component.ActivityComponent;
import com.testapplication.injection.component.ApplicationComponent;
import com.testapplication.injection.component.DaggerApplicationComponent;
import com.testapplication.injection.module.ActivityModule;
import com.testapplication.injection.module.ApiModule;
import com.testapplication.injection.module.ApplicationModule;
import com.testapplication.ui.activity.base.BaseActivity;

public class TestApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    public void onCreate() {
        super.onCreate();

        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent
//                    .create();
                    .builder()
                    .applicationModule(new ApplicationModule(this))
                    .apiModule(new ApiModule())
                    .build();
        }
        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public static TestApplication get(Context context) {
        return (TestApplication) context.getApplicationContext();
    }

    public ActivityComponent createActivityComponent(BaseActivity activity){
        return mApplicationComponent.plus(new ActivityModule(activity));
    }
}
