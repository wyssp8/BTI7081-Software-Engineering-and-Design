package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ExercisesViewPresenter;

public class ExerciseViewImpl extends CustomComponent {

	public ExerciseViewImpl(){
		
		String title = "";
		String description;
		HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addStyleName("outlined");
        horizontalLayout.setSpacing(false);
        horizontalLayout.setMargin(false);
        horizontalLayout.setSizeFull();
        Label test1 = new Label(title);
        horizontalLayout.addComponent(test1);
        
		this.setCompositionRoot(horizontalLayout);
		
	}
	
	public void initializeExercise(){
		
	}
	
}
