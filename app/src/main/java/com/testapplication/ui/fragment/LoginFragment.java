package com.testapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.testapplication.R;
import com.testapplication.constants.Constants;
import com.testapplication.ui.activity.MainActivity;
import com.testapplication.ui.fragment.base.BaseFragment;
import com.testapplication.ui.view.LoginView;

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
        openMainActivity(null);
    }

    @Override
    public void openMainActivity(@Nullable Bundle arguments) {
        Intent intent = new Intent(getBaseActivity(), MainActivity.class);
        if(arguments != null)
            intent.putExtra(Constants.ARGUMENTS, arguments);
        startActivity(intent);
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

    private void validateInput(){
        if(!TextUtils.isEmpty(etUserName.getText())
                && !TextUtils.isEmpty(etPassword.getText())){

            //TODO: login
            openMainActivity();

        } else {
            Toast.makeText(getBaseActivity(), "Fill in all fields.", Toast.LENGTH_SHORT).show();
        }
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
