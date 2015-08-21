package GWTPlatformAplikacja.client.application.presenterkatalogfryzur;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PresenterKatalogFryzurModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PresenterKatalogFryzurPresenter.class, PresenterKatalogFryzurPresenter.MyView.class, PresenterKatalogFryzurView.class, PresenterKatalogFryzurPresenter.MyProxy.class);
    }
}