package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.EmergencyButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.MainView;
/**
 * This view shows the latest diary entry in the dashboard and allows creating a new entry.
 * 
 * @author frutiger
 *
 */
public class DiaryDashViewImpl extends DashView implements MainView {

	private static final long serialVersionUID = 1500529579085605966L;
	private static final String PANEL_TITLE = "Latest diary entry";
	private List<ButtonClickListener> listeners = new ArrayList<ButtonClickListener>();
	private Label date = new Label();
	private Label description = new Label();

	public DiaryDashViewImpl() {
		super();
		setPanelTitle(PANEL_TITLE);
		VerticalLayout verticalLayoutContent = new VerticalLayout();
		Button goToExercisesButton = new Button("Write dairy");
		goToExercisesButton.addClickListener( e -> {
			for(ButtonClickListener listener : listeners){
				listener.buttonClick();
			}
		});
		verticalLayoutContent.addComponent(date);
		verticalLayoutContent.addComponent(description);
		verticalLayoutContent.addComponent(goToExercisesButton);
		panel.setContent(verticalLayoutContent);
		setCompositionRoot(verticalLayout);
	}
	
	@Override
	public void addListener(ButtonClickListener clickListener) {
		listeners.add(clickListener);
	}
	
	public void setLatestDate(String dateText) { 
		this.date.setValue(dateText);
	}

	public void setDescriptionText(String descriptionText) {
		this.description.setValue(descriptionText);
	}

}
