package com.testapplication.ui.presenter.base;

import com.testapplication.core.network.ApiManager;
import com.testapplication.ui.presenter.MvpPresenter;
import com.testapplication.ui.view.base.BaseView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends BaseView> implements MvpPresenter<V> {

    private static final String TAG = "BasePresenter";
    private final CompositeDisposable mCompositeDisposable;
    private ApiManager mApiManager;
    private V mMvpView;

    @Inject
    public BasePresenter(ApiManager apiManager, CompositeDisposable compositeDisposable) {
        this.mApiManager = apiManager;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        this.mMvpView = null;
    }
}
