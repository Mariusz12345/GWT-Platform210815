package GWTPlatformAplikacja.client.application.presenterkatalogfryzur;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class PresenterKatalogFryzurView extends ViewImpl implements PresenterKatalogFryzurPresenter.MyView {
    interface Binder extends UiBinder<Widget, PresenterKatalogFryzurView> {
    }

  @UiField Button powrot;
  @UiField Button katalogGuzik;
  

    public Button getKatalogGuzik() {
	return katalogGuzik;
}


	public Button getPowrot() {
	return powrot;
}


	@Inject
    PresenterKatalogFryzurView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
   
}