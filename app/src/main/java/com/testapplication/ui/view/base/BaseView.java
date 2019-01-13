package com.testapplication.ui.view.base;

import android.support.annotation.StringRes;

public interface BaseView {
    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();
    void onSuccess(Object result);
    void onError(@StringRes int resId);

    void onError(String message);

    boolean isNetworkConnected();

    void hideKeyboard();
}
