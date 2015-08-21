package GWTPlatformAplikacja.client.application.glowny;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import GWTPlatformAplikacja.client.application.stronaglownapresentorw.EventDlaLabelaEvent;
import GWTPlatformAplikacja.client.application.stronaglownapresentorw.StronaGlownaPresentorwPresenter;
import GWTPlatformAplikacja.client.place.NameTokens;
public class GlownyPresenter extends Presenter<GlownyPresenter.MyView, GlownyPresenter.MyProxy>  {
    interface MyView extends View  {
    	
    	public Button getWyslij();
    	public TextBox getTexbox();
    	public Button getWyczysci();
    	public Button getKatalogFryzurGuzik();
    	public Button getZapiszGuzik();
    	
    }
    private EventBus eventBus;
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
        this.eventBus=eventBus;
    }
    @Override
    protected void revealInParent() {
    	
    	RevealContentEvent.fire(this,StronaGlownaPresentorwPresenter.SLOT_content,  this);
    }
    
    protected void onBind() {
        super.onBind();
        
        
        
        
        registerHandler(getView().getWyslij().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				wyslijDaneNaSerwer();
			}
		}));
        
        getView().getWyczysci().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
					EventDlaLabelaEvent evencik = new EventDlaLabelaEvent();
					GlownyPresenter.this.eventBus.fireEvent(evencik);
					
			}
		});
    }
    private void wyslijDaneNaSerwer() {
    	PlaceRequest request = new PlaceRequest.Builder().nameToken(NameTokens.odpowiedzi).build().with("name", getView().getTexbox().getText());
    	placeManager.revealPlace(request);
	}
    
    @Override
    protected void onReset() {
    	super.onReset();
    	getView().getKatalogFryzurGuzik().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			PlaceRequest request = new PlaceRequest(NameTokens.katalog);
			placeManager.revealPlace(request);
			}
		});
    	
    	getView().getZapiszGuzik().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PlaceRequest request = new PlaceRequest(NameTokens.zapisz);
				placeManager.revealPlace(request);
			}
		});
    	
    }
}