package com.tochange.memento_maps.map.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.tochange.memento_maps.map.R;
import com.tochange.memento_maps.map.view.Main2View;
import com.tochange.memento_maps.map.presenter.loader.PresenterFactory;
import com.tochange.memento_maps.map.presenter.Main2Presenter;
import com.tochange.memento_maps.map.injection.AppComponent;
import com.tochange.memento_maps.map.injection.Main2ViewModule;
import com.tochange.memento_maps.map.injection.DaggerMain2ViewComponent;

import javax.inject.Inject;

public final class Main2Activity extends BaseActivity<Main2Presenter, Main2View> implements Main2View {
    @Inject
    PresenterFactory<Main2Presenter> mPresenterFactory;

    // Your presenter is available using the mPresenter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerMain2ViewComponent.builder()
                .appComponent(parentComponent)
                .main2ViewModule(new Main2ViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<Main2Presenter> getPresenterFactory() {
        return mPresenterFactory;
    }
}
