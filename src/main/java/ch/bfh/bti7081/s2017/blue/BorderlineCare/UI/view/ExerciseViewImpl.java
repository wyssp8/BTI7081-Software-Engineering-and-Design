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
	private String titleText;
	private String descriptionText;
	private String imagePath;
	private Label title = new Label(titleText);
	private Label description = new Label(titleText);
	private Button rightButton = new Button();
	private Button leftButton = new Button();
	private Image image = new Image();
	
	public ExerciseViewImpl(){
		
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		
		FileResource leftArrowImage = new FileResource(new File(basepath + "/WEB-INF/images/arrow-left.png"));
		leftButton = new Button("Prev");
		leftButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		leftButton.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		leftButton.setIcon(leftArrowImage);
		leftButton.setHeight("100%");
		leftButton.setWidth("100%");
		
		FileResource rightArrowImage = new FileResource(new File(basepath + "/WEB-INF/images/arrow-right.png"));
		rightButton = new Button("Next");
		rightButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		rightButton.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		rightButton.setIcon(rightArrowImage);
		rightButton.setHeight("100%");
		rightButton.setWidth("100%");
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addStyleName("outlined");
        horizontalLayout.setSpacing(false);
        horizontalLayout.setMargin(false);
        horizontalLayout.setSizeFull();
        
        VerticalLayout verticalLayout = new VerticalLayout();
        title.setCaption(titleText);
        description.setCaption(descriptionText);
        horizontalLayout.addComponent(leftButton);
        horizontalLayout.addComponent(verticalLayout);
        verticalLayout.addComponent(title);
        verticalLayout.addComponent(image);
        verticalLayout.addComponent(description);
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
        horizontalLayout.setComponentAlignment(rightButton, Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(title, Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(image, Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(description, Alignment.MIDDLE_CENTER);
        
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
	
	@Override
	public void addButtonClickListener(ExerciseClickListener clickListener) {
		listeners.add(clickListener);
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		FileResource exerciseImage = new FileResource(new File(basepath + "/WEB-INF/images/exercises/"+ imagePath));
		image.setIcon(exerciseImage);
	}

}
