package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name = "feedback")
public class Feedback extends Model {

	@Required(message = "Title cannot empty.")
	public String name;
	@Required(message = "Description cannot empty.")
	public String description;

	public String createDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@Required(message = "User cannot empty.")
	public User user;

	@OneToMany(mappedBy = "feedback", targetEntity=Answer.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Answer> answers;

}
