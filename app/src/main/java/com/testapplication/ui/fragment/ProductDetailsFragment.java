package com.testapplication.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testapplication.BR;
import com.testapplication.R;
import com.testapplication.constants.Constants;
import com.testapplication.core.models.api.ProductDto;
import com.testapplication.ui.databinding.DataBindingUtils;
import com.testapplication.ui.fragment.base.BaseFragment;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public class ProductDetailsFragment extends BaseFragment {

    private ProductDto productDto;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        productDto = getArguments().getParcelable(Constants.ARGUMENTS);
        ViewDataBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_product_details, container, false);
        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        binding.setVariable(BR.product, productDto);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_product_details;
    }

    @Override
    protected void injectDependencies() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onSuccess(Object result) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }
}
