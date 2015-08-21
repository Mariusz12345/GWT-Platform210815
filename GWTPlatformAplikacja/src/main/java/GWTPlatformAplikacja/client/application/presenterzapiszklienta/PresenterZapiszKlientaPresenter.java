package GWTPlatformAplikacja.client.application.presenterzapiszklienta;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import GWTPlatformAplikacja.client.place.NameTokens;
public class PresenterZapiszKlientaPresenter extends Presenter<PresenterZapiszKlientaPresenter.MyView, PresenterZapiszKlientaPresenter.MyProxy>  {
    interface MyView extends View  {
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterZapiszKlienta = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.zapisz)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterZapiszKlientaPresenter> {
    }

    @Inject
    PresenterZapiszKlientaPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        
    }
    
    protected void onBind() {
        super.onBind();
    }
    
}