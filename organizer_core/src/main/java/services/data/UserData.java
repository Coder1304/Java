package services.data;



import java.util.Set;

public class UserData {

	public UserData() {
		super();
	}

	String name;
	String surname;
	
	private Set<EventData> events;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Set<EventData> getEvents() {
		return events;
	}

	public void setEvents(Set<EventData> events) {
		this.events = events;
	}
	
	public UserData(String name, String surname, Set<EventData> events){
		this.name 		= name;
		this.surname 	= surname;
		this.events		= events;
	}
	
	public UserData(String name, String surname){
		this.name 		= name;
		this.surname 	= surname;
	}
}
