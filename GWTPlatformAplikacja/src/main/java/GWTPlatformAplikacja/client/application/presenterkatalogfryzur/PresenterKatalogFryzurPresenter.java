package GWTPlatformAplikacja.client.application.presenterkatalogfryzur;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Button;
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

import GWTPlatformAplikacja.client.application.presenterwidgetwyborfryzury.PresenterWidgetWyborFryzuryPresenter;
import GWTPlatformAplikacja.client.application.stronaglownapresentorw.StronaGlownaPresentorwPresenter;
import GWTPlatformAplikacja.client.place.NameTokens;
public class PresenterKatalogFryzurPresenter extends Presenter<PresenterKatalogFryzurPresenter.MyView, PresenterKatalogFryzurPresenter.MyProxy>  {
    interface MyView extends View  {
    	
    	
    	 public Button getPowrot();
    	  public Button getKatalogGuzik();
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterKatalogFryzur = new Type<RevealContentHandler<?>>();
    PlaceManager menager;
    @NameToken(NameTokens.katalog)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterKatalogFryzurPresenter> {
    }
    @Inject PresenterWidgetWyborFryzuryPresenter presenterWidget;

    @Inject
    PresenterKatalogFryzurPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            PlaceManager menager) {
        super(eventBus, view, proxy, RevealType.Root);
        this.menager=menager;
    }
    @Override
    protected void revealInParent() {
    	
    	RevealContentEvent.fire(this,StronaGlownaPresentorwPresenter.SLOT_content,  this);
    }
    @Override
    protected void onBind() {
    	super.onBind();
    	
    	getView().getKatalogGuzik().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				addToPopupSlot(presenterWidget);
			}
		});
    }
  @Override
  protected void onReset() {
	super.onReset();
	getView().getPowrot().addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = new PlaceRequest(NameTokens.glowny);
			menager.revealPlace(request);
		}
	});
	
}
    
}