package GWTPlatformAplikacja.server.guice;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

import GWTPlatformAplikacja.client.application.shared.WyslijDoSerweraAction;
import GWTPlatformAplikacja.client.application.shared.handler.WyslijDoSerweraHandler;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
    	
    		bindHandler(WyslijDoSerweraAction.class, WyslijDoSerweraHandler.class);
    }
}
