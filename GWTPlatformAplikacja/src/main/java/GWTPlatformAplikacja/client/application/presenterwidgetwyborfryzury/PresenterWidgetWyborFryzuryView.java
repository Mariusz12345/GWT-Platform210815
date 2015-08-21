package GWTPlatformAplikacja.client.application.presenterwidgetwyborfryzury;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;

class PresenterWidgetWyborFryzuryView extends PopupViewImpl implements PresenterWidgetWyborFryzuryPresenter.MyView {
    interface Binder extends UiBinder<Widget, PresenterWidgetWyborFryzuryView> {
    }

    @UiField Button okButton;
    
    @Inject
    PresenterWidgetWyborFryzuryView(EventBus eventBus, Binder uiBinder) {
        super(eventBus);
    
        initWidget(uiBinder.createAndBindUi(this));
    }
    

    public Button getOkButton() {
		return okButton;
	}



	
    
}