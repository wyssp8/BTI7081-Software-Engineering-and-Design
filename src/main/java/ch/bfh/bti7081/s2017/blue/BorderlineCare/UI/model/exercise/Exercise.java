package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise;
/**
 * 
 * @author wyssp8
 *
 */
public abstract class Exercise {

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
	
}
