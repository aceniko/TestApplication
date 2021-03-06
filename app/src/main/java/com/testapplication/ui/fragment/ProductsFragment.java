package com.testapplication.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.testapplication.R;
import com.testapplication.core.models.api.ProductDto;
import com.testapplication.ui.databinding.BaseAdapter;
import com.testapplication.ui.databinding.DataBindingActions;
import com.testapplication.ui.fragment.base.BaseFragment;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class ProductsFragment extends BaseFragment {

    public static String TAG = ProductsFragment.class.getCanonicalName();


    BaseAdapter<ProductDto> adapter;
    ArrayList<ProductDto> products;
    LinearLayoutManager linearLayoutManager;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_products;
    }

    @Override
    protected void injectDependencies() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setUp(View view) {

        products = new ArrayList<>();
        adapter = new BaseAdapter(getBaseActivity(), R.layout.item_product, products);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setHasFixedSize(true);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

//        adapter.setLoading(true);
        setupDummyList();
    }

    private void setupDummyList(){
        for(int i=0; i<10; i++){
            ProductDto productDto = new ProductDto();
            productDto.setName("Product " + String.valueOf(i));
            products.add(productDto);
        }
    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onSuccess(Object result) {

        //todo: Setup list
    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }

    @OnClick(R.id.btn_add)
    public void onClickAdd(){
        FragmentManager fragmentManager = getBaseActivity().getSupportFragmentManager();
        Fragment fragment = new ProductDetailsFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getCanonicalName());
        fragmentTransaction.commitAllowingStateLoss();
    }
}
