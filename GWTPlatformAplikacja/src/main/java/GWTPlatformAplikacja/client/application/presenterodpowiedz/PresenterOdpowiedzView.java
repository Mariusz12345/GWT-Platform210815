package GWTPlatformAplikacja.client.application.presenterodpowiedz;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class PresenterOdpowiedzView extends ViewImpl implements PresenterOdpowiedzPresenter.MyView {
    interface Binder extends UiBinder<Widget, PresenterOdpowiedzView> {
    }

    @UiField HTML odpowiedzSerwera;
    
    

    public HTML getOdpowiedzSerwera() {
		return odpowiedzSerwera;
	}



	@Inject
    PresenterOdpowiedzView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

	@Override
	public void setOdpowiedziZSerwera(String serverOdpowiedz) {
		this.odpowiedzSerwera.setHTML(serverOdpowiedz);
		
	}
    
   
}