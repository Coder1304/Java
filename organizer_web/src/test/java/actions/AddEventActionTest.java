package actions;

import static org.mockito.Mockito.mock;

import org.actions.AddEventAction;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vaadin.ui.Calendar;
import com.vaadin.ui.Notification;

public class AddEventActionTest {

	@Test
	public void checkAction() {
		AddEventAction obj = new AddEventAction();

		Assert.assertEquals(obj.getCaption(), "Add Event");
	}

	@Test
	public void addEventNegativ() {

		Calendar cal = mock(Calendar.class);
		Object date = new Object();

		AddEventAction obj = new AddEventAction();

		PowerMockito.mockStatic(Notification.class);

		try {
			PowerMockito.verifyStatic(Mockito.times(1));
			obj.makeAction(cal, date);
		} catch (NullPointerException e) {
		}
	}

}
