package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author wyssp8
 *
 */
@Entity
public abstract class Exercise {

	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	
	private String description;
	
	private String imagePath;
	
	public Exercise(String title, String description, String imagePath){
		this.description = description;
		this.title = title;
		this.imagePath = imagePath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
