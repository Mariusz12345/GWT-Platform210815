package GWTPlatformAplikacja.client.application.glowny;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class GlownyView extends ViewImpl implements GlownyPresenter.MyView {
    interface Binder extends UiBinder<Widget, GlownyView> {
    }


    @UiField Button wyslij;
    
    @UiField TextBox texbox;
    @UiField Button katalogFryzurGuzik;


	@UiField Button wyczysci;
	@UiField Button ZapiszGuzik;
	
	
	
    public Button getZapiszGuzik() {
		return ZapiszGuzik;
	}

	public Button getKatalogFryzurGuzik() {
			return katalogFryzurGuzik;
		}
    
	public Button getWyczysci() {
		return wyczysci;
	}


	public TextBox getTexbox() {
		return texbox;
	}


	public Button getWyslij() {
		return wyslij;
	}
	
	@Inject
    GlownyView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
}