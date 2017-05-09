package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
/**
 * This view shows the latest diary entry in the dashboard and allows creating a new entry.
 * 
 * @author frutiger
 *
 */
public class DiaryDashViewImpl extends DashView {

	public DiaryDashViewImpl() {
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(new Button("Placeholder: New Diary"));
		setCompositionRoot(layout);
	}

}
