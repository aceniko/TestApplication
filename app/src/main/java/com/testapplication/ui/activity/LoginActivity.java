package com.testapplication.ui.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.testapplication.R;
import com.testapplication.ui.activity.base.BaseActivity;
import com.testapplication.ui.fragment.LoginFragment;

import butterknife.ButterKnife;


public class LoginActivity extends BaseActivity {

    public final static String TAG;

    static {
        TAG = LoginActivity.class.getCanonicalName();
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
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setUp() {
        mFragmentManager = getSupportFragmentManager();
        Fragment fragment = new LoginFragment();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getCanonicalName());
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
}

