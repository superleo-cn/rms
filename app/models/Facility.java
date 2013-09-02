package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name = "facility")
public class Facility extends Model {

	@Required(message = "Facility Name cannot empty.")
	public String name;
	public String description;
	
	//@OneToMany(mappedBy = "facility", targetEntity=Event.class, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	//List<Event> event;
}
