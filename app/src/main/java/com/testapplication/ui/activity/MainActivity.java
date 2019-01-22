package com.testapplication.ui.activity;

import android.os.Bundle;

import com.testapplication.R;
import com.testapplication.ui.activity.base.BaseActivity;
import com.testapplication.ui.fragment.LoginFragment;
import com.testapplication.ui.fragment.ProductsFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    public final static String TAG;

    static {
        TAG = MainActivity.class.getCanonicalName();
    }

    private FragmentManager mFragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependencies();

        setUnBinder(ButterKnife.bind(this));

        setUp();
    }

    @Override
    protected void setUp() {
        mFragmentManager = getSupportFragmentManager();
        Fragment fragment = new ProductsFragment();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getCanonicalName());
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }
}
