package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ExerciseClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.ExerciseView;
/**
 * 
 * @author wyssp8
 *
 */
public class ExerciseViewImpl extends CustomComponent implements ExerciseView {

	private static final long serialVersionUID = 2890501565667684097L;
	private List<ExerciseClickListener> listeners = new ArrayList<ExerciseClickListener>();
	private Label titleCalm = new Label();
	private Label descriptionCalm = new Label();
	private Label titleDaily = new Label();
	private Label descriptionDaily = new Label();
	private Button rightButtonCalm = new Button();
	private Button leftButtonCalm = new Button();
	private Button rightButtonDaily = new Button();
	private Button leftButtonDaily = new Button();
	private Image imageCalm = new Image();
	private Image imageDaily = new Image();
	
	private Label dailyExerciseStateDescription;
	private Button dailyExerciseStartButton;
	private Button dailyExerciseCancelButton;
	private Button dailyExerciseDoneButton;
	
	private static String TITLE_DAILY_EXERCISE = "Daily exercise";
	private static String TITLE_CALM_DOWN_EXERCISE = "Calm-down exercise";
	
	public ExerciseViewImpl(){
		
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		
		FileResource leftArrowImage = new FileResource(new File(basepath + "/WEB-INF/images/arrow-left.png"));
		leftButtonCalm = new Button("Prev");
		leftButtonCalm.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		leftButtonCalm.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		leftButtonCalm.setIcon(leftArrowImage);
		leftButtonCalm.setHeight("100%");
		leftButtonCalm.setWidth("100%");
		
		FileResource rightArrowImage = new FileResource(new File(basepath + "/WEB-INF/images/arrow-right.png"));
		rightButtonCalm = new Button("Next");
		rightButtonCalm.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		rightButtonCalm.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		rightButtonCalm.setIcon(rightArrowImage);
		rightButtonCalm.setHeight("100%");
		rightButtonCalm.setWidth("100%");
		
		
		leftButtonDaily = new Button("Prev");
		leftButtonDaily.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		leftButtonDaily.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		leftButtonDaily.setIcon(leftArrowImage);
		leftButtonDaily.setHeight("100%");
		leftButtonDaily.setWidth("100%");
		
		rightButtonDaily = new Button("Next");
		rightButtonDaily.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		rightButtonDaily.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		rightButtonDaily.setIcon(rightArrowImage);
		rightButtonDaily.setHeight("100%");
		rightButtonDaily.setWidth("100%");
		
		
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addStyleName("outlined");
        horizontalLayout.setSpacing(false);
        horizontalLayout.setMargin(false);
        horizontalLayout.setSizeFull();
        
        VerticalLayout verticalLayout = new VerticalLayout();
        horizontalLayout.addComponent(leftButtonCalm);
        horizontalLayout.addComponent(verticalLayout);
        verticalLayout.addComponent(titleCalm);
        verticalLayout.addComponent(imageCalm);
        verticalLayout.addComponent(descriptionCalm);
        horizontalLayout.addComponent(rightButtonCalm);
        
       
        
        rightButtonCalm.addClickListener(e -> {
        	for (ExerciseClickListener listener: listeners) {
				listener.nextButtonClickCalm();
			}
        });
        leftButtonCalm.addClickListener(e -> {
        	for (ExerciseClickListener listener: listeners) {
				listener.prevButtonClickCalm();
			}
        });
        rightButtonDaily.addClickListener(e -> {
        	for (ExerciseClickListener listener: listeners) {
				listener.nextButtonClickDaily();
			}
        });
        leftButtonDaily.addClickListener(e -> {
        	for (ExerciseClickListener listener: listeners) {
				listener.prevButtonClickDaily();
			}
        });
        horizontalLayout.setSizeFull();
        horizontalLayout.setComponentAlignment(leftButtonCalm, Alignment.MIDDLE_CENTER);
        horizontalLayout.setComponentAlignment(rightButtonCalm, Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(titleCalm, Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(imageCalm, Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(descriptionCalm, Alignment.MIDDLE_CENTER);
        
		VerticalLayout baseVerticalLayout = new VerticalLayout();
		
		
		
		
		dailyExerciseStateDescription = new Label();
		
		Label headTitleDaily = new Label(TITLE_DAILY_EXERCISE);
		Label headTitleCalmDown = new Label(TITLE_CALM_DOWN_EXERCISE);
		
		dailyExerciseStartButton = new Button("Start");
		dailyExerciseStartButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		dailyExerciseStartButton.addClickListener(click ->{
        	for (ExerciseClickListener listener: listeners) {
				listener.exerciseStarted();
			}
		});
		
		dailyExerciseCancelButton = new Button("Cancel");
		dailyExerciseCancelButton.setStyleName(ValoTheme.BUTTON_DANGER);
		dailyExerciseCancelButton.addClickListener(click ->{
        	for (ExerciseClickListener listener: listeners) {
				listener.exerciseCanceled();
			}
			
		});
		
		dailyExerciseDoneButton = new Button("Done");
		dailyExerciseDoneButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		dailyExerciseDoneButton.addClickListener(click ->{
        	for (ExerciseClickListener listener: listeners) {
				listener.exerciseDone();
			}
		});
        
		
		HorizontalLayout horizontalLayoutDaily = new HorizontalLayout();
        horizontalLayoutDaily.addStyleName("outlined");
        horizontalLayoutDaily.setSpacing(false);
        horizontalLayoutDaily.setMargin(false);
        horizontalLayoutDaily.setSizeFull();
        horizontalLayoutDaily.addComponent(leftButtonDaily);
        
        VerticalLayout imageStateLayout = new VerticalLayout();
        imageStateLayout.addComponent(imageDaily);
        imageStateLayout.addComponent(dailyExerciseStateDescription);
        horizontalLayoutDaily.addComponent(imageStateLayout);
        
        VerticalLayout layoutDescription = new VerticalLayout();
        layoutDescription.addComponent(titleDaily);
        layoutDescription.addComponent(descriptionDaily);
		horizontalLayoutDaily.addComponent(layoutDescription);
		
		VerticalLayout layoutButtons = new VerticalLayout();
		layoutButtons.addComponent(dailyExerciseStartButton);
		layoutButtons.addComponent(dailyExerciseCancelButton);
		layoutButtons.addComponent(dailyExerciseDoneButton);
		
		horizontalLayoutDaily.addComponent(layoutButtons);
        horizontalLayoutDaily.addComponent(rightButtonDaily);
        horizontalLayoutDaily.setComponentAlignment(imageStateLayout, Alignment.MIDDLE_CENTER);
        horizontalLayoutDaily.setComponentAlignment(layoutButtons, Alignment.MIDDLE_CENTER);
        horizontalLayoutDaily.setComponentAlignment(leftButtonDaily, Alignment.MIDDLE_CENTER);
        horizontalLayoutDaily.setComponentAlignment(rightButtonDaily, Alignment.MIDDLE_CENTER);
		
		
		baseVerticalLayout.addComponent(headTitleCalmDown);
        baseVerticalLayout.setComponentAlignment(headTitleCalmDown, Alignment.MIDDLE_CENTER);
		baseVerticalLayout.addComponent(horizontalLayout);
		baseVerticalLayout.addComponent(headTitleDaily);
        baseVerticalLayout.setComponentAlignment(headTitleDaily, Alignment.MIDDLE_CENTER);
		baseVerticalLayout.addComponent(horizontalLayoutDaily);
		this.setCompositionRoot(baseVerticalLayout);
		
	}


	public void setTitleTextCalm(String titleText) {
		this.titleCalm.setValue(titleText);
	}


	public void setDescriptionTextCalm(String descriptionText) {
		this.descriptionCalm.setValue(descriptionText);
	}
	
	@Override
	public void addButtonClickListener(ExerciseClickListener clickListener) {
		listeners.add(clickListener);
	}

	public void setImagePathCalm(String imagePath) {
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		FileResource exerciseImage = new FileResource(new File(basepath + "/WEB-INF/images/exercises/"+ imagePath));
		imageCalm.setIcon(exerciseImage);
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
	
	public void setDailyExerciseStateDescription(String label) {
		this.dailyExerciseStateDescription.setValue(label);
	}


	public void setDailyExerciseButton(Button dailyExerciseButton) {
		this.dailyExerciseStartButton = dailyExerciseButton;
	}
	
	public void setDailyExerciseStartButtonVisibility(boolean visibility){
		dailyExerciseStartButton.setVisible(visibility);
	}
	
	public void setDailyExerciseCancelButtonVisibility(boolean visibility){
		dailyExerciseCancelButton.setVisible(visibility);
	}
	
	public void setDailyExerciseDoneButtonVisibility(boolean visibility){
		dailyExerciseDoneButton.setVisible(visibility);
	}
	
	public void setStateStyle(String styleName){
		dailyExerciseStateDescription.setStyleName(styleName);
	}
	

}
