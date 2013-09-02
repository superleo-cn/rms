package models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name = "about")
public class About extends Model {

	public String date;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	public String description;
}
