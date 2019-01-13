package com.testapplication.ui.fragment.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testapplication.injection.component.ActivityComponent;
import com.testapplication.injection.component.FragmentComponent;
import com.testapplication.injection.module.FragmentModule;
import com.testapplication.ui.activity.base.BaseActivity;
import com.testapplication.ui.view.base.BaseView;

import java.util.logging.Filter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseView {
    private BaseActivity mActivity;
    private Unbinder mUnBinder;
    private View view;
    private FragmentComponent mFragmentComponent;

    protected void createFragmentComponent(){
        if(mFragmentComponent==null){
            mFragmentComponent = getActivityComponent().plus(new FragmentModule(this));
        }
    }

    public FragmentComponent getFragmentComponent(){
        return mFragmentComponent;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
        }

        injectDependencies();
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(getFragmentLayout(), container, false);
        } catch (InflateException e) {

        }
        return view;

    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }


    public ActivityComponent getActivityComponent() {
        return mActivity.getActivityComponent();
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    protected abstract int getFragmentLayout();
    protected abstract void injectDependencies();
    protected abstract void setUp(View view);

    private void injectViews(final View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onError(@StringRes int resId) {

    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
