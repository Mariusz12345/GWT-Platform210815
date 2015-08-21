package GWTPlatformAplikacja.client.application.glowny;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import GWTPlatformAplikacja.client.place.NameTokens;
public class GlownyPresenter extends Presenter<GlownyPresenter.MyView, GlownyPresenter.MyProxy>  {
    interface MyView extends View  {
    	
    	public Button getWyslij();
    	public TextBox getTexbox();
    	
    }
    private final PlaceManager placeManager;
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_Glowny = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.glowny)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<GlownyPresenter> {
    }

    @Inject
    GlownyPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            PlaceManager placeManager) {
        super(eventBus, view, proxy, RevealType.Root);
        this.placeManager = placeManager;
    }
    
    protected void onBind() {
        super.onBind();
        registerHandler(getView().getWyslij().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				wyslijDaneNaSerwer();
			}
		}));
    }
    private void wyslijDaneNaSerwer() {
    	PlaceRequest request = new PlaceRequest.Builder().nameToken(NameTokens.odpowiedzi).build().with("name", getView().getTexbox().getText());
    	placeManager.revealPlace(request);
		
	}
}