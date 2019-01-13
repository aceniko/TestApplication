package com.testapplication.injection.module;

import android.app.Activity;
import android.content.Context;

import com.testapplication.injection.ActivityContext;

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
}
