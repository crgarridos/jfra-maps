package com.tochange.memento_maps.map.injection;

import android.support.annotation.NonNull;

import com.tochange.memento_maps.map.interactor.Main2Interactor;
import com.tochange.memento_maps.map.interactor.impl.Main2InteractorImpl;
import com.tochange.memento_maps.map.presenter.loader.PresenterFactory;
import com.tochange.memento_maps.map.presenter.Main2Presenter;
import com.tochange.memento_maps.map.presenter.impl.Main2PresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class Main2ViewModule {
    @Provides
    public Main2Interactor provideInteractor() {
        return new Main2InteractorImpl();
    }

    @Provides
    public PresenterFactory<Main2Presenter> providePresenterFactory(@NonNull final Main2Interactor interactor) {
        return new PresenterFactory<Main2Presenter>() {
            @NonNull
            @Override
            public Main2Presenter create() {
                return new Main2PresenterImpl(interactor);
            }
        };
    }
}
