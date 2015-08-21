package GWTPlatformAplikacja.client.application.stronaglownapresentorw;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class StronaGlownaPresentorwView extends ViewImpl implements StronaGlownaPresentorwPresenter.MyView {
	interface Binder extends UiBinder<Widget, StronaGlownaPresentorwView> {
	}

	@UiField
	HTMLPanel panel;
	@UiField
	Label labelek;
	

	@Inject
	StronaGlownaPresentorwView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}
	

	public Label getLabelek() {
		return labelek;
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == StronaGlownaPresentorwPresenter.SLOT_content) {
			panel.clear();

			if (content != null) {
				panel.add(content);
			}
		} else {

			super.setInSlot(slot, content);

		}
	}

}