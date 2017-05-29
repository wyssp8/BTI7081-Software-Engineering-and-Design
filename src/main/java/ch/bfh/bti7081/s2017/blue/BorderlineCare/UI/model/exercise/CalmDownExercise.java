package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

/**
 * 
 * @author wyssp8
 *
 */
@Entity
public class CalmDownExercise extends Exercise {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="LOGINACCOUNT_EMAIL")
	private LoginAccount loginAccount;
	
	public CalmDownExercise(){
	}
	
	public CalmDownExercise(String title, String description, String path) {
		super(title, description, path);
	}

}
