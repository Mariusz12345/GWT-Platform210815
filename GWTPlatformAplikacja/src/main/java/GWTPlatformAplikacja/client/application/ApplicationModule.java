package GWTPlatformAplikacja.client.application;

import GWTPlatformAplikacja.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import GWTPlatformAplikacja.client.application.glowny.GlownyModule;
import GWTPlatformAplikacja.client.application.presenterodpowiedz.PresenterOdpowiedzModule;
import GWTPlatformAplikacja.client.application.stronaglownapresentorw.StronaGlownaPresentorwModule;
import GWTPlatformAplikacja.client.application.presenterkatalogfryzur.PresenterKatalogFryzurModule;
import GWTPlatformAplikacja.client.application.presenterwidgetwyborfryzury.PresenterWidgetWyborFryzuryModule;
import GWTPlatformAplikacja.client.application.presenterzapiszklienta.PresenterZapiszKlientaModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
		install(new PresenterZapiszKlientaModule());
		install(new PresenterWidgetWyborFryzuryModule());
		install(new PresenterKatalogFryzurModule());
		install(new StronaGlownaPresentorwModule());
		install(new PresenterOdpowiedzModule());
		install(new GlownyModule());
		install(new HomeModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
