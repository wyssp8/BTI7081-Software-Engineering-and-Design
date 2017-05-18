package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.DiaryButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.EmergencyButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.DiaryView;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.MainView;

public class DiaryViewImpl extends CustomComponent implements DiaryView {
	
	private List<DiaryButtonClickListener> diaryButtonListeners = new ArrayList<DiaryButtonClickListener>();
	
	private Button buttonAdd;
	private Button buttonGood;
	private Button buttonMedium;
	private Button buttonBad;
	
	private DateField date;
	private TextArea txtArea;
	
	private Grid<DiaryEntry> grid;
	
	
	public DiaryViewImpl(){
	
		VerticalLayout vLayout = new VerticalLayout();
		//HorizontalLayout hLayout = new HorizontalLayout();
		
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
	
		// Create a DateField
		date = new DateField();
		vLayout.addComponent(date);
		date.setValue(LocalDate.now());
		
		//Buttons SmileyGood
		FileResource goodImage = new FileResource(new File(basepath + "/WEB-INF/images/diary/smiley_good.JPG"));
		buttonGood = new Button();
		buttonGood.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		buttonGood.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		buttonGood.setIcon(goodImage);
		
		buttonGood.addClickListener(e -> {
			for (DiaryButtonClickListener listener : diaryButtonListeners) {
				listener.smileyGoodButtonClick();
			}
		});
		
		buttonGood.setHeight("50px");
		buttonGood.setWidth("50px");
		vLayout.addComponent(buttonGood);
		
		
		//Buttons SmileyMedium
		buttonMedium = new Button("Medium");
		vLayout.addComponent(buttonMedium);
		
		
		//Buttons SmileyBad
		buttonBad = new Button("Bad");
		vLayout.addComponent(buttonBad);
		
		// Create a text area
		txtArea = new TextArea("Diary entry");
		txtArea.setWidth("50%");
		txtArea.setValue("What have you done today\n" + "How did you feel today?");
		vLayout.addComponent(txtArea);
		
		//Button Add
		buttonAdd = new Button("Add");
		vLayout.addComponent(buttonAdd);
		
		
		
		//Grid Table
		grid = new Grid<>();
		grid.addColumn(DiaryEntry::getDate).setCaption("Date");
		grid.addColumn(DiaryEntry::getStatus).setCaption("Status");
		grid.addColumn(DiaryEntry::getTitle).setCaption("Title");
		grid.addColumn(DiaryEntry::getDiaryEntry).setCaption("Entry");
		grid.setWidth("1000");
		vLayout.addComponent(grid);
		
		//setCompositionRoot(hLayout);
		setCompositionRoot(vLayout);
		
	}
	
	public void setName(String name) {
		buttonAdd.setCaption(name);
	}
	
	public TextArea getTextArea() {
		return txtArea;
	}

	public void initializeDiaryEntry(List<DiaryEntry> diaryEntry){
		grid.setItems(diaryEntry);
	}

	@Override
	public void addDiaryButtonClickListener(DiaryButtonClickListener clickListener) {
		diaryButtonListeners.add(clickListener);
		
	}
}
