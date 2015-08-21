package GWTPlatformAplikacja.client.application.stronaglownapresentorw;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class StronaGlownaPresentorwModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(StronaGlownaPresentorwPresenter.class, StronaGlownaPresentorwPresenter.MyView.class, StronaGlownaPresentorwView.class, StronaGlownaPresentorwPresenter.MyProxy.class);
    }
}