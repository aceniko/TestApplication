package com.testapplication.injection.component;

import com.testapplication.injection.PerFragment;
import com.testapplication.injection.module.FragmentModule;
import com.testapplication.ui.fragment.CreateProductFragment;
import com.testapplication.ui.fragment.LoginFragment;
import com.testapplication.ui.fragment.ProductsFragment;
import com.testapplication.ui.fragment.UpdateProductFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent(modules = {
        FragmentModule.class
})
public interface FragmentComponent {
    void inject(LoginFragment fragment);
    void inject(ProductsFragment fragment);
    void inject(CreateProductFragment fragment);
    void inject(UpdateProductFragment fragment);
}
