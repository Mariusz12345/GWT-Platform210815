package GWTPlatformAplikacja.client.application.presenterodpowiedz;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PresenterOdpowiedzModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PresenterOdpowiedzPresenter.class, PresenterOdpowiedzPresenter.MyView.class, PresenterOdpowiedzView.class, PresenterOdpowiedzPresenter.MyProxy.class);
    }
}