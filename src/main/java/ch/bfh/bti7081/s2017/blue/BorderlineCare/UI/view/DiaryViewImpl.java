package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.time.LocalDate;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class DiaryViewImpl extends CustomComponent {
	
	
	public DiaryViewImpl(){
		
		VerticalLayout vLayout = new VerticalLayout();
		//HorizontalLayout hLayout = new HorizontalLayout();
		
		//setCompositionRoot(hLayout);
		setCompositionRoot(vLayout);
		
		
		// Create a DateField
		DateField date = new DateField();
		vLayout.addComponent(date);
		date.setValue(LocalDate.now());
		
		// Create a text area
		TextArea txtArea = new TextArea("Diary entry");
		txtArea.setValue("What have you done today\n" + "How did you feel today?");
		vLayout.addComponent(txtArea);
		
		//Button
		Button button = new Button("Add");
		vLayout.addComponent(button);
		
		//Grid Table
		Grid grid = new Grid("My diary entries");
		vLayout.addComponent(grid);
		
		
	}

}
