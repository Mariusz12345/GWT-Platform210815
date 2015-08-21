package GWTPlatformAplikacja.client.application.presenterzapiszklienta;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class PresenterZapiszKlientaView extends ViewImpl implements PresenterZapiszKlientaPresenter.MyView {
    interface Binder extends UiBinder<Widget, PresenterZapiszKlientaView> {
    }

  
    @Inject
    PresenterZapiszKlientaView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
 
}