package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ExerciseClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.ExerciseView;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.MainView;
/**
 * 
 * This view shows a random daily exercise.
 * 
 * @author frutiger
 *
 */
public class ExerciseDashViewImpl extends DashView implements MainView {

	private static final long serialVersionUID = 6314784050023003347L;
	private static final String PANEL_TITLE = "Daily Exercise";
	private List<ButtonClickListener> listeners = new ArrayList<ButtonClickListener>();
	private Label titleDaily = new Label();
	private Label descriptionDaily = new Label();
	private Image imageDaily = new Image();
	
	public ExerciseDashViewImpl() {
		super();
		setPanelTitle(PANEL_TITLE);
		VerticalLayout verticalLayoutContent = new VerticalLayout();
		
		verticalLayoutContent.addComponent(titleDaily);
		verticalLayoutContent.addComponent(descriptionDaily);
		verticalLayoutContent.addComponent(imageDaily);
			
		Button goToExercisesButton = new Button("Show all exercises");
		goToExercisesButton.addClickListener( e -> {
			for(ButtonClickListener listener : listeners){
				listener.buttonClick();
			}
		});
		
		verticalLayoutContent.addComponent(imageDaily);
		verticalLayoutContent.addComponent(goToExercisesButton);
		
		panel.setContent(verticalLayoutContent);
		setCompositionRoot(verticalLayout);
	}



	@Override
	public void addListener(ButtonClickListener clickListener) {
		listeners.add(clickListener);
	}
	
	public void setImagePathDaily(String imagePath) {
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		FileResource exerciseImage = new FileResource(new File(basepath + "/WEB-INF/images/exercises/"+ imagePath));
		imageDaily.setIcon(exerciseImage);
	}
	
	public void setTitleTextDaily(String titleText) { 
		this.titleDaily.setValue(titleText);
	}

	public void setDescriptionTextDaily(String descriptionText) {
		this.descriptionDaily.setValue(descriptionText);
	}
	
	
}
