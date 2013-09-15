package hibernate.entities;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class UserEntitie {

	@Override
	public String toString() {
		String eventsNumber = "null";
		if (events != null)
			eventsNumber = String.valueOf(events.size());
		
		return "UserEntitie [userId=" + userId + ", name=" + name
				+ ", surname=" + surname + ", events=" + eventsNumber + "]";
	}

	@Override
	public int hashCode() {		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntitie other = (UserEntitie) obj;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (events.size() != other.events.size())
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public UserEntitie() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID",nullable=false)
	Integer userId;
	
	@Column(name="NAME")
	String name;
	
	@Column(name="SURNAME")
	String surname;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private Set<EventEntitie> events;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public Set<EventEntitie> getEvents() {
		return events;
	}

	public void setEvents(Set<EventEntitie> events) {
		this.events = events;
	}
	
	public UserEntitie(String name, String surname, Set<EventEntitie> events){
		this.name 		= name;
		this.surname 	= surname;
		this.events		= events;
	}
	
	public UserEntitie(String name, String surname){
		this.name 		= name;
		this.surname 	= surname;
	}
}
