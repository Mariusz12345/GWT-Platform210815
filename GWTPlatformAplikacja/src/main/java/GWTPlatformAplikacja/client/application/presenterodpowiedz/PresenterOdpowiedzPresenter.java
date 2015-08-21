package GWTPlatformAplikacja.client.application.presenterodpowiedz;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
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

import GWTPlatformAplikacja.client.application.shared.OdpowiedzZSerweraResult;
import GWTPlatformAplikacja.client.application.shared.WyslijDoSerweraAction;
import GWTPlatformAplikacja.client.application.stronaglownapresentorw.StronaGlownaPresentorwPresenter;
import GWTPlatformAplikacja.client.place.NameTokens;

public class PresenterOdpowiedzPresenter
		extends Presenter<PresenterOdpowiedzPresenter.MyView, PresenterOdpowiedzPresenter.MyProxy> {
	@Inject PlaceManager placeMenager;
	private String name = "";

	interface MyView extends View {
		void setOdpowiedziZSerwera(String serverOdpowiedz);
		public Button getPowrot();
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_PresenterOdpowiedz = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.odpowiedzi)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<PresenterOdpowiedzPresenter> {
	}

	private final DispatchAsync dispath;

	@Inject
	PresenterOdpowiedzPresenter(EventBus eventBus, MyView view, MyProxy proxy, DispatchAsync dispath) {
		super(eventBus, view, proxy, RevealType.Root);
		this.dispath = dispath;
	}

		@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, StronaGlownaPresentorwPresenter.SLOT_content, this);
	}

	protected void onBind() {
		super.onBind();

	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		name = request.getParameter("name", "wartosci Domyslan");
	}

	protected void onReset() {
		getView().getPowrot().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PlaceRequest request = new PlaceRequest(NameTokens.glowny);
				placeMenager.revealRelativePlace(request);
				
			}
		});
		getView().setOdpowiedziZSerwera("poczekaj");
		dispath.execute(new WyslijDoSerweraAction(name), new AsyncCallback<OdpowiedzZSerweraResult>() {

			@Override
			public void onFailure(Throwable caught) {
				getView().setOdpowiedziZSerwera("error" + caught.getMessage());
			}

			@Override
			public void onSuccess(OdpowiedzZSerweraResult result) {
				getView().setOdpowiedziZSerwera(result.getOdpowiedziZSerwera());
			}
		});

	}

}