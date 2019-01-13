package com.testapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.testapplication.R;
import com.testapplication.ui.fragment.base.BaseFragment;
import com.testapplication.ui.view.LoginView;
import com.testapplication.ui.view.base.BaseView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment implements LoginView {

    @BindView(R.id.button_login)
    Button btnLogin;

    @BindView(R.id.editTextUserName)
    EditText etUserName;

    @BindView(R.id.editTextPassword)
    EditText etPassword;

    @Override
    public void openMainActivity() {

    }

    @Override
    public void openMainActivity(@Nullable Bundle arguments) {

    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_login;
    }

    @Override
    protected void injectDependencies() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setUp(View view) {

    }

    @OnClick(R.id.button_login)
    public void onButtonLoginClick(){
        validateInput();

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onSuccess(Object result) {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }
}
