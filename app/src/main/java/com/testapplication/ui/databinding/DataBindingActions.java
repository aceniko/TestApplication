package com.testapplication.ui.databinding;

import android.view.View;

public interface DataBindingActions<T> {
    boolean onClick(View view, T object);
    boolean onLongClick(View view, T object);
}
