package GWTPlatformAplikacja.client.application.stronaglownapresentorw;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class EventDlaLabelaEvent extends GwtEvent<EventDlaLabelaEvent.EventDlaLabelaHandler> {
    private static Type<EventDlaLabelaHandler> TYPE = new Type<EventDlaLabelaHandler>();
    
    public interface EventDlaLabelaHandler extends EventHandler {
        void onEventDlaLabela(EventDlaLabelaEvent event);
    }
    
    

    public static Type<EventDlaLabelaHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final EventDlaLabelaHandler handler) {
        handler.onEventDlaLabela(this);
    }

    @Override
    public Type<EventDlaLabelaHandler> getAssociatedType() {
        return TYPE;
    }
    
}