package models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name = "circular")
public class Circular extends Model {

	@Required(message = "Circular Name cannot empty.")
	public String name;

	public String createDate;
	
	public String startDate;
	
	public String endDate;

	@Lob
	@Basic(fetch=FetchType.EAGER)
	public String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	@Required(message = "User cannot empty.")
	public User user;
}
