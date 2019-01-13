package com.testapplication.injection.module;

import android.support.v4.app.Fragment;

import com.testapplication.injection.PerFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment fragment){
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    Fragment provideFragment(){
        return mFragment;
    }
}
