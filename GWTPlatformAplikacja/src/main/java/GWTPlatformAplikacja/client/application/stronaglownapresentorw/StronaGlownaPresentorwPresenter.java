package GWTPlatformAplikacja.client.application.stronaglownapresentorw;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

import GWTPlatformAplikacja.client.application.stronaglownapresentorw.EventDlaLabelaEvent.EventDlaLabelaHandler;
public class StronaGlownaPresentorwPresenter extends Presenter<StronaGlownaPresentorwPresenter.MyView, StronaGlownaPresentorwPresenter.MyProxy>  {
    interface MyView extends View  {
    	
    	public Label getLabelek();
    	
    	
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_content = new Type<RevealContentHandler<?>>();

    private final EventDlaLabelaHandler eventDlaLabelaHandler = new EventDlaLabelaHandler() {
		
		@Override
		public void onEventDlaLabela(EventDlaLabelaEvent event) {
			getView().getLabelek().setText("");
		}
	};
    
    @ProxyStandard
    interface MyProxy extends Proxy<StronaGlownaPresentorwPresenter> {
    }

    @Inject
    StronaGlownaPresentorwPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        
    }
    @Override
    protected void revealInParent() {
    	RevealRootContentEvent.fire(this, this);
    }    
    protected void onBind() {
        super.onBind();
        
        registerHandler(getEventBus().addHandler(EventDlaLabelaEvent.getType(),eventDlaLabelaHandler ));
    }
    
}