package com.testapplication.injection;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.CLASS;

@Scope
@Retention(CLASS)
public @interface PerFragment {
}
