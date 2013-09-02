package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name = "event")
public class Event extends Model {

	@Required(message = "Event Name cannot empty.")
	public String name;
	public String description;
	@Required(message = "Date cannot empty.")
	public String date;
	@Required(message = "Color cannot empty.")
	public String color;
	public String remark;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	@Required(message = "User cannot empty.")
	public User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facilityId")
	public Facility facility;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "eventSessionId")
	public EventSession eventSession;
}
