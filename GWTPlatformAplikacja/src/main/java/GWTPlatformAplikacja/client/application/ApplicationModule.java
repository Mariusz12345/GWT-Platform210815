package GWTPlatformAplikacja.client.application;

import GWTPlatformAplikacja.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import GWTPlatformAplikacja.client.application.glowny.GlownyModule;
import GWTPlatformAplikacja.client.application.presenterodpowiedz.PresenterOdpowiedzModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new PresenterOdpowiedzModule());
		install(new GlownyModule());
		install(new HomeModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
