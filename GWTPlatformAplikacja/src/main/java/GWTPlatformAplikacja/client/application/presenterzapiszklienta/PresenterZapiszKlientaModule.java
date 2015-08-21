package GWTPlatformAplikacja.client.application.presenterzapiszklienta;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PresenterZapiszKlientaModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PresenterZapiszKlientaPresenter.class, PresenterZapiszKlientaPresenter.MyView.class, PresenterZapiszKlientaView.class, PresenterZapiszKlientaPresenter.MyProxy.class);
    }
}