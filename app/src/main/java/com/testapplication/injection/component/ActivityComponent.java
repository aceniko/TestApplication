package com.testapplication.injection.component;

import com.testapplication.injection.module.FragmentModule;
import com.testapplication.ui.activity.LoginActivity;
import com.testapplication.injection.PerActivity;
import com.testapplication.injection.module.ActivityModule;
import com.testapplication.ui.activity.MainActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {
        ActivityModule.class
})
public interface ActivityComponent {
    void inject(LoginActivity activity);
    void inject(MainActivity activity);

    FragmentComponent plus(FragmentModule module);
}
