package com.testapplication.injection.component;

import android.app.Application;

import com.testapplication.injection.module.ActivityModule;
import com.testapplication.injection.module.ApiModule;
import com.testapplication.injection.module.ApplicationModule;
import com.testapplication.ui.presenter.LoginPresenter;
import com.testapplication.ui.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ApiModule.class
        }
)
public interface ApplicationComponent {
    void inject(Application application);
    ActivityComponent plus(ActivityModule activityModule);
    void inject(MainPresenter mainPresenter);
    void inject(LoginPresenter loginPresenter);

}
