package com.testapplication.injection.module;

import android.app.Activity;
import android.content.Context;

import com.testapplication.core.network.ApiManagerImpl;
import com.testapplication.injection.ActivityContext;
import com.testapplication.injection.PerActivity;
import com.testapplication.ui.activity.base.BaseActivity;
import com.testapplication.ui.presenter.LoginPresenter;
import com.testapplication.ui.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    LoginPresenter provideLoginPresenter(CompositeDisposable compositeDisposable, ApiManagerImpl apiManager){
        return new LoginPresenter((BaseActivity) mActivity, compositeDisposable, apiManager);
    }
    @Provides
    @PerActivity
    MainPresenter provideMainPresenter(CompositeDisposable compositeDisposable, ApiManagerImpl apiManager){
        return new MainPresenter((BaseActivity) mActivity, compositeDisposable, apiManager);
    }
}
