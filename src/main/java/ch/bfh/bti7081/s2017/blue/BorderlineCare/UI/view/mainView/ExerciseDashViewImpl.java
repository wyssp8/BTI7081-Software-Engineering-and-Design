package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
/**
 * 
 * This view shows a random daily exercise.
 * 
 * @author frutiger
 *
 */
public class ExerciseDashViewImpl extends DashView {

	private static final long serialVersionUID = 6314784050023003347L;

	public ExerciseDashViewImpl() {
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(new Button("Placeholder: New Exercise"));
		setCompositionRoot(layout);
	}
}
