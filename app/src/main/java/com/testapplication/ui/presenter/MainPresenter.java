package com.testapplication.ui.presenter;

import com.testapplication.core.models.api.PagedResultDtoProduct;
import com.testapplication.core.network.ApiManager;
import com.testapplication.core.network.ApiManagerImpl;
import com.testapplication.ui.activity.base.BaseActivity;
import com.testapplication.ui.presenter.base.BasePresenter;
import com.testapplication.ui.view.base.BaseView;

import androidx.annotation.MainThread;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<BaseView> {

    private final BaseActivity baseActivity;
    private CompositeDisposable compositeDisposable;
    private ApiManagerImpl apiManager;

    public MainPresenter(BaseActivity baseActivity, CompositeDisposable compositeDisposable, ApiManagerImpl apiManager){
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

    public void getAllProducts(int skipCount, int maxResultCount, String accessToken){

        getCompositeDisposable().add(apiManager.getAllProductsPaged(skipCount, maxResultCount, accessToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<PagedResultDtoProduct>() {
                            @Override
                            public void accept(PagedResultDtoProduct pagedResultDtoProduct) throws Exception {
                                if(pagedResultDtoProduct != null){

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
