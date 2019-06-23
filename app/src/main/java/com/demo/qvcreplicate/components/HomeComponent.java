package com.demo.qvcreplicate.Components;

import com.demo.qvcreplicate.Fragments.HomeFrag;

import dagger.Component;

@Component(modules = {HomeModule.class})
public interface HomeComponent {
    void inject(HomeFrag homeFrag);
}
