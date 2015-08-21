package GWTPlatformAplikacja.client.application.presenterwidgetwyborfryzury;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PresenterWidgetWyborFryzuryModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(PresenterWidgetWyborFryzuryPresenter.class, PresenterWidgetWyborFryzuryPresenter.MyView.class, PresenterWidgetWyborFryzuryView.class);
    }
}