package GWTPlatformAplikacja.client.application.presenterodpowiedz;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import GWTPlatformAplikacja.client.application.shared.OdpowiedzZSerweraResult;
import GWTPlatformAplikacja.client.application.shared.WyslijDoSerweraAction;
import GWTPlatformAplikacja.client.place.NameTokens;
public class PresenterOdpowiedzPresenter extends Presenter<PresenterOdpowiedzPresenter.MyView, PresenterOdpowiedzPresenter.MyProxy>  {
    public static final String textToServerParam = "wiadomossaDASFSDGSDGSDGSDGSDGSDGSDGci?";
    private String textToServer="wiadomosc";
    
    private String name="";
	
	interface MyView extends View  {
		void setOdpowiedziZSerwera(String serverOdpowiedz);
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterOdpowiedz = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.odpowiedzi)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterOdpowiedzPresenter> {
    }
    private final DispatchAsync dispath;
    

    @Inject
    PresenterOdpowiedzPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,DispatchAsync dispath) {
        super(eventBus, view, proxy, RevealType.Root);
        this.dispath = dispath;
    }
    
    protected void onBind() {
        super.onBind();
        
    }
    @Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		name=request.getParameter("name", "wartosci Domyslan");
	}
    protected void onReset(){
    	getView().setOdpowiedziZSerwera("poczekaj");
    	dispath.execute(new WyslijDoSerweraAction(name), new AsyncCallback<OdpowiedzZSerweraResult>() {

			@Override
			public void onFailure(Throwable caught) {
				getView().setOdpowiedziZSerwera("error"+caught.getMessage());
			}

			@Override
			public void onSuccess(OdpowiedzZSerweraResult result) {
				getView().setOdpowiedziZSerwera(result.getOdpowiedziZSerwera());
			}
		});
    	
    }
    
    
}