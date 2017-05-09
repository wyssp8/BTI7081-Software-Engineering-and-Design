package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise;

import java.io.File;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Image;

public abstract class Exercise {

	private String title;
	private String description;
	private Image picture;
	
	public Exercise(String title, String description, String path){
		this.description = description;
		this.title = title;
		
		//link the path to image
		FileResource resource = new FileResource(new File(path));
		this.picture = new Image(title, resource);
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

	public Image getPicture() {
		return picture;
	}

	public void setPicture(Image picture) {
		this.picture = picture;
	}
	
}
