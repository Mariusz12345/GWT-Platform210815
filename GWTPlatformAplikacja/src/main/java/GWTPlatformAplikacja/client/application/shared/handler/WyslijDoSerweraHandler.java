package GWTPlatformAplikacja.client.application.shared.handler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import GWTPlatformAplikacja.client.application.shared.OdpowiedzZSerweraResult;
import GWTPlatformAplikacja.client.application.shared.WyslijDoSerweraAction;

public class WyslijDoSerweraHandler implements ActionHandler<WyslijDoSerweraAction, OdpowiedzZSerweraResult> {
	
	 private Provider<HttpServletRequest> requestProvider;
	 private ServletContext servletContext;
	 
	 @Inject
	 WyslijDoSerweraHandler(ServletContext servletContext,
	      Provider<HttpServletRequest> requestProvider) {
	    this.servletContext = servletContext;
	    this.requestProvider = requestProvider;
	  }
	public OdpowiedzZSerweraResult execute(WyslijDoSerweraAction action, ExecutionContext context)throws ActionException{
	
		
		String wyjscie=action.getTekstWyslanyDoSerwera();
		return new OdpowiedzZSerweraResult("Odpowiedzi serwera: "+wyjscie);
	}
	@Override
	public Class<WyslijDoSerweraAction> getActionType() {
		return WyslijDoSerweraAction.class;
	}

	@Override
	public void undo(WyslijDoSerweraAction action, OdpowiedzZSerweraResult result, ExecutionContext context)
			throws ActionException {
	}
	

}
