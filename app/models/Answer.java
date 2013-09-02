package models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name = "answer")
public class Answer extends Model {

	@Required(message = "Title cannot empty.")
	public String name;
	@Required(message = "Description cannot empty.")
	public String description;

	public String createDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@Required(message = "User cannot empty.")
	public User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "feedbackId")
	@Required(message = "Feedback cannot empty.")
	public Feedback feedback;

}
