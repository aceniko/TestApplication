package com.testapplication.ui.presenter;

import com.testapplication.ui.view.base.BaseView;

public interface MvpPresenter<V extends BaseView>{
    void onAttach(V mvpView);

    void onDetach();
}
