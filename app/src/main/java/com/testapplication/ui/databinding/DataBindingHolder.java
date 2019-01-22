package com.testapplication.ui.databinding;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

public class DataBindingHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public DataBindingHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object obj, Object obj2) {
        binding.setVariable(BR.item,obj);
        binding.setVariable(BR.handlers,obj2);
        binding.executePendingBindings();
    }
}
