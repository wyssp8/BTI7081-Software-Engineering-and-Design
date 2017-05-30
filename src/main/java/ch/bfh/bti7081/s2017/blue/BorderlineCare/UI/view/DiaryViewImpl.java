package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.MultiSelectionModel;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ContactButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.DiaryViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.DiaryButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.EmergencyButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.DiaryView;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.MainView;

public class DiaryViewImpl extends CustomComponent implements DiaryView {
	
	private List<DiaryButtonClickListener> diaryButtonListeners = new ArrayList<DiaryButtonClickListener>();
	
	private Button buttonAdd;
	private Button buttonDelete;
	
	private RadioButtonGroup<String> smileyRadioGroup;
	
	private DateField date;
	private TextField textField;
	private TextArea txtArea;
	
	private Grid<DiaryEntry> grid;
	MultiSelectionModel<DiaryEntry> selectionModel;
	
	
	public DiaryViewImpl(){
	
		VerticalLayout vLayout = new VerticalLayout();
		//HorizontalLayout hLayout = new HorizontalLayout();
		
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
	
		// Create a DateField
		date = new DateField();
		vLayout.addComponent(date);
		date.setValue(LocalDate.now());
		
		//Smiley RadioButton Group
		FileResource smileyRadio = new FileResource(new File(basepath + "/WEB-INF/images/diary/smileys.JPG"));
		smileyRadioGroup = new RadioButtonGroup<>();
		smileyRadioGroup.setItems("Good", "Medium", "Bad");
		smileyRadioGroup.setIcon(smileyRadio);
		smileyRadioGroup.setStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL);
		
		vLayout.addComponent(smileyRadioGroup);
		
		
		//Title Textfield
		textField = new TextField("Title");
		vLayout.addComponent(textField);
		
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
		grid.addColumn(DiaryEntry::getDate).setCaption("Date").setWidth(120);
		grid.addColumn(DiaryEntry::getStatus).setCaption("Status").setWidth(100);
		grid.addColumn(DiaryEntry::getTitle).setCaption("Title").setWidth(200);
		grid.addColumn(DiaryEntry::getDiaryEntry).setCaption("Entry");
		
		
		grid.setWidth("1200");
		//grid.addStyleName("v-grid-cell");
		
		
		//Grid Multiselection
		selectionModel = (MultiSelectionModel<DiaryEntry>) grid.setSelectionMode(SelectionMode.MULTI);
		selectionModel.selectAll();
		
		//Grid Delete
		grid.addColumn(DiaryEntry -> "delete",
				new ButtonRenderer<DiaryEntry>(clickEvent -> {
					for (DiaryButtonClickListener listener : diaryButtonListeners) {
						DiaryEntry toDelete = clickEvent.getItem();
						listener.deleteButtonClick(toDelete);
					}
				}));
		
		vLayout.addComponent(grid);
		
		//setCompositionRoot(hLayout);
		setCompositionRoot(vLayout);
				
	}
	
	public void initAddDiaryEntry() {
		buttonAdd.addClickListener(clickEvent -> {
			for (DiaryButtonClickListener listener : diaryButtonListeners) {
				LocalDate dateInput = getDateField();
				String radioInput = getRadioGroup();
				String titleInput = getTextField();
				String diaryInput = getTextArea();
				listener.addButtonClick(dateInput, radioInput, titleInput, diaryInput);
			}
		});
	}
	
	
	public void setName(String name) {
		buttonAdd.setCaption(name);
	}
	
	public LocalDate getDateField() {
		return date.getValue();
	}
	
	public String getRadioGroup() {
		return smileyRadioGroup.getValue();
	}
	
	public String getTextField() {
		return textField.getValue();
	}
	
	public String getTextArea() {
		return txtArea.getValue();
	}
	
	public MultiSelectionModel<DiaryEntry> getSelectionModel() {
		return selectionModel;
	}
	

	public void initializeDiaryEntry(List<DiaryEntry> diaryEntry){
		grid.setItems(diaryEntry);
	}

	@Override
	public void addDiaryButtonClickListener(DiaryButtonClickListener clickListener) {
		diaryButtonListeners.add(clickListener);
		
	}
	

}
