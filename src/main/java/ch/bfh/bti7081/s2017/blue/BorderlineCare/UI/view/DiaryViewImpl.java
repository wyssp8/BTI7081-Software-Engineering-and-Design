package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class DiaryViewImpl extends CustomComponent {
	
	
	public DiaryViewImpl(){
		VerticalLayout vLayout = new VerticalLayout();
		HorizontalLayout hLayout = new HorizontalLayout();
		
		setCompositionRoot(hLayout);
		
		// Create a DateField
		DateField date = new DateField("Date");
		hLayout.addComponent(date);
		date.setValue(LocalDate.now());
		
		// Create a text field
		TextField tf = new TextField("A Field");
		hLayout.addComponent(tf);
		tf.setValue("Some Text");
		
		// Create Grid table
		
	}

}
