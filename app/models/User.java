package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name = "user")
public class User extends Model {
	@Required(message = "Username cannot empty")
	public String username;
	@Required(message = "Password cannot empty")
	public String password;
	@Required(message = "UnitNo cannot empty")
	public String unitNo;
	@Required(message = "Real Name cannot empty")
	public String realName;
	public String residentType;
	public String usertype;
	
	
	public static final String USER_RESIDENT = "RDT";
	public static final String USER_MANAGER = "MGR";
}
