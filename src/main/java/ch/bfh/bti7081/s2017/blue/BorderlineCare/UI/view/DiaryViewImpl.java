package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.MainView;

public class DiaryViewImpl extends CustomComponent implements MainView, ClickListener {
	
	private List<ButtonClickListener> listeners = new ArrayList<ButtonClickListener>();
	private Button button;
	
	public DateField date;
	public TextArea txtArea;
	
	private Grid<DiaryEntry> grid;
	private List<DiaryEntry> diaryEntry;
	
	
	public DiaryViewImpl(){
	
		VerticalLayout vLayout = new VerticalLayout();
		//HorizontalLayout hLayout = new HorizontalLayout();
	
		// Create a DateField
		date = new DateField();
		vLayout.addComponent(date);
		date.setValue(LocalDate.now());
		
		// Create a text area
		txtArea = new TextArea("Diary entry");
		txtArea.setWidth("50%");
		txtArea.setValue("What have you done today\n" + "How did you feel today?");
		vLayout.addComponent(txtArea);
		
		//Button
		button = new Button("Add");
		vLayout.addComponent(button);
		button.addClickListener(this);
		
		//Grid Table
		grid = new Grid<>();
		grid.addColumn(DiaryEntry::getDate).setCaption("Date");
		grid.addColumn(DiaryEntry::getDiaryEntry).setCaption("Entry");
		vLayout.addComponent(grid);
		
		//setCompositionRoot(hLayout);
		setCompositionRoot(vLayout);
		
	}
	
	public void setName(String name) {
		button.setCaption(name);
	}

	public void addListener(ButtonClickListener clickListener) {
		listeners.add(clickListener);
	}


	public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
		for(ButtonClickListener listener : listeners){
			listener.buttonClick();
		}
	}
	
	public void initializeDiaryEntry(List<DiaryEntry> diaryEntry){
		grid.setItems(diaryEntry);
	}

}
