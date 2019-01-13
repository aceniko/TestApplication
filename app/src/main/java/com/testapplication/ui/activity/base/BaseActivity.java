package com.testapplication.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.testapplication.TestApplication;
import com.testapplication.injection.component.ActivityComponent;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;
    private Unbinder mUnBinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        createActivityComponent();
    }

    protected void createActivityComponent(){

        if(mActivityComponent == null){
            mActivityComponent = TestApplication.get(this)
                    .createActivityComponent(this);
        }
    }

    public ActivityComponent getActivityComponent() {
        if(mActivityComponent==null) createActivityComponent();
        return mActivityComponent;
    }

    protected abstract void setUp();

    protected abstract int getLayoutId();
    protected abstract void injectDependencies();

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }
}
