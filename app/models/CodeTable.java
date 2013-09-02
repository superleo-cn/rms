package models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name = "codetable")
public class CodeTable extends Model {

	@Required(message = "Name cannot empty.")
	public String name;

	@Required(message = "Value cannot empty.")
	public String value;

	public String description;

	public String createDate;

}
