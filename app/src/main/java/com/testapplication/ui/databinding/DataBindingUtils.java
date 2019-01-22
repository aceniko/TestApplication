package com.testapplication.ui.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.InverseMethod;

public class DataBindingUtils<T> implements DataBindingActions{

    private Context context;

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
        return true;
    }

    @Override
    public boolean onLongClick(View view, Object object) {
        return true;
    }
}

