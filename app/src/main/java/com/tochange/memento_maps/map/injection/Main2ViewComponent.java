package com.tochange.memento_maps.map.injection;

import com.tochange.memento_maps.map.view.impl.Main2Activity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = Main2ViewModule.class)
public interface Main2ViewComponent {
    void inject(Main2Activity activity);
}