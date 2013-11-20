package ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class DefaultUI extends UI {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void init(VaadinRequest request) {
		VerticalLayout content = new VerticalLayout();
        setContent(content);
        setContent(new Label("This browser does not support touch events"));
    }

	public void markAsDirty() {
		// TODO Auto-generated method stub
		
	}
}
