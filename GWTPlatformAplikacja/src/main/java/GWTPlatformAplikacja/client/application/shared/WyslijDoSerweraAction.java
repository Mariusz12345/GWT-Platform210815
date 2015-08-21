package GWTPlatformAplikacja.client.application.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

public class WyslijDoSerweraAction extends UnsecuredActionImpl<OdpowiedzZSerweraResult> {
	
	
	private String tekstWyslanyDoSerwera;

	public WyslijDoSerweraAction(final String tekstWyslanyDoSerwera) {
		super();
		this.tekstWyslanyDoSerwera = tekstWyslanyDoSerwera;
	}
	  @SuppressWarnings("unused")
	  private WyslijDoSerweraAction() {
	  }

	public String getTekstWyslanyDoSerwera() {
		return tekstWyslanyDoSerwera;
	}
	
}