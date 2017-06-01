package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.EmergencyButtonClickListener;
/**
 * This view shows the latest diary entry in the dashboard and allows creating a new entry.
 * 
 * @author frutiger
 *
 */
public class DiaryDashViewImpl extends DashView {

	private static final long serialVersionUID = 1500529579085605966L;
	private static final String PANEL_TITLE = "Diary";
	private List<ButtonClickListener> listeners = new ArrayList<ButtonClickListener>();

	public DiaryDashViewImpl() {
		super();
		setPanelTitle(PANEL_TITLE);
		VerticalLayout verticalLayoutContent = new VerticalLayout();
		Button goToExercisesButton = new Button("Show all exercises");
		goToExercisesButton.addClickListener( e -> {
			for(ButtonClickListener listener : listeners){
				listener.buttonClick();
			}
		});
		verticalLayoutContent.addComponent(goToExercisesButton);
		verticalLayout.addComponent(verticalLayoutContent);
		setCompositionRoot(verticalLayout);
	}

}
