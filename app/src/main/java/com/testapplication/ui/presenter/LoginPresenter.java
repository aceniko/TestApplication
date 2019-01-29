package com.testapplication.ui.presenter;

import com.testapplication.core.models.api.AuthenticateModel;
import com.testapplication.core.models.api.AuthenticateResultModel;
import com.testapplication.core.network.ApiManager;
import com.testapplication.core.network.ApiManagerImpl;
import com.testapplication.ui.activity.base.BaseActivity;
import com.testapplication.ui.presenter.base.BasePresenter;
import com.testapplication.ui.view.base.BaseView;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<BaseView> {

    private final BaseActivity baseActivity;
    private CompositeDisposable compositeDisposable;
    private ApiManagerImpl apiManager;

    public LoginPresenter(BaseActivity baseActivity, CompositeDisposable compositeDisposable, ApiManagerImpl apiManager){
        super(apiManager, compositeDisposable);
        this.baseActivity = baseActivity;
        this.apiManager = apiManager;
        this.compositeDisposable = compositeDisposable;
    }

    private CompositeDisposable getCompositeDisposable(){
        if(compositeDisposable == null)
            compositeDisposable = new CompositeDisposable();

        return compositeDisposable;
    }

    public void authenticate(AuthenticateModel request){

        getCompositeDisposable().add(apiManager.authenticate(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<AuthenticateResultModel>() {
                            @Override
                            public void accept(AuthenticateResultModel authenticateResultModel) throws Exception {
                                if (authenticateResultModel != null) {

                                }
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        }
                )
        );



    }
}
