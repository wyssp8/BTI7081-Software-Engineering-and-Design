package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;


import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ExerciseClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.ExerciseView;

public class ExerciseViewImpl extends CustomComponent implements ExerciseView {

	private List<ExerciseClickListener> listeners = new ArrayList<ExerciseClickListener>();
	private String titleText;
	private String descriptionText;
	private String imagePath;
	private Label title = new Label(titleText);
	private Label description = new Label(titleText);
	private Button rightButton = new Button();
	private Button leftButton = new Button();
	
	public ExerciseViewImpl(){
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addStyleName("outlined");
        horizontalLayout.setSpacing(false);
        horizontalLayout.setMargin(false);
        horizontalLayout.setSizeFull();
        
        title.setCaption(titleText);
        description.setCaption(descriptionText);
        horizontalLayout.addComponent(leftButton);
        horizontalLayout.addComponent(title);
        horizontalLayout.addComponent(description);
        horizontalLayout.addComponent(rightButton);
        rightButton.addClickListener(e -> {
        	for (ExerciseClickListener listener: listeners) {
				listener.nextButtonClick();
			}
        });
        leftButton.addClickListener(e -> {
        	for (ExerciseClickListener listener: listeners) {
				listener.prevButtonClick();
			}
        });
        horizontalLayout.setSizeFull();
		horizontalLayout.setComponentAlignment(leftButton, Alignment.MIDDLE_CENTER);
		this.setCompositionRoot(horizontalLayout);
		
	}
	
	

	public String getTitleText() {
		return titleText;
	}

	public void setTitleText(String titleText) {
		this.titleText = titleText;
		this.title.setCaption(titleText);
	}

	public String getDescriptionText() {
		return descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
		this.description.setCaption(descriptionText);
	}

	public String getPath() {
		return imagePath;
	}

	public void setPath(String path) {
		this.imagePath = path;
	}
	
	public void changeView(){
		
	}



	@Override
	public void addButtonClickListener(ExerciseClickListener clickListener) {
		listeners.add(clickListener);
	}

}
