package com.testapplication.ui.view;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.testapplication.ui.view.base.BaseView;

public interface LoginView extends BaseView {
    void openMainActivity();
    void openMainActivity(@Nullable Bundle arguments);
}
