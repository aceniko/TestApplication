package com.testapplication.ui.databinding;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.testapplication.R;
import com.testapplication.constants.Constants;
import com.testapplication.core.models.api.ProductDto;
import com.testapplication.ui.activity.MainActivity;
import com.testapplication.ui.activity.base.BaseActivity;
import com.testapplication.ui.fragment.ProductDetailsFragment;
import com.testapplication.ui.fragment.ProductsFragment;

import androidx.databinding.InverseMethod;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DataBindingUtils<T> implements DataBindingActions{

    private Context context;
    private FragmentManager fragmentManager;

    public DataBindingUtils(Context context){
        this.context = context;
    }

    public boolean getBoolean(String s){
        return Boolean.valueOf(s);
    }

    @InverseMethod("getBoolean")
    public String setBoolean(boolean b){
        return String.valueOf(b);
    }

    @Override
    public boolean onClick(View view, Object object) {
        if(object instanceof ProductDto){

            fragmentManager = ((BaseActivity) context).getSupportFragmentManager();
            Fragment fragment = new ProductDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constants.ARGUMENTS, (ProductDto)object);
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getCanonicalName());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commitAllowingStateLoss();
        }
        return true;
    }

    @Override
    public boolean onLongClick(View view, Object object) {
        return true;
    }
}

