package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.MultiSelectionModel;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.DiaryButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.DiaryView;

/**
 * 
 * Implement the diary View
 * 
 * @author Kieliger
 *
 */

public class DiaryViewImpl extends CustomComponent implements DiaryView {
	

	private static final long serialVersionUID = -6250389995528614659L;
	private final static Logger logger = Logger.getLogger(DiaryViewModel.class.getName());

	private List<DiaryButtonClickListener> diaryButtonListeners = new ArrayList<>();
	
	private Button buttonAdd, buttonDelete;
	private RadioButtonGroup<String> smileyRadioGroup;
	private DateField dateField;
	private TextField textField;
	private TextArea txtArea;
	private String stringDate;
	
	private Grid<DiaryEntry> grid;
	private MultiSelectionModel<DiaryEntry> selectionModel;
	
	private VerticalLayout vLayout;
	private HorizontalLayout buttonLayout;
	
	private String title, entry, exampleText, add, deleteSelect, date, status, gridWidth, textAreaWidth, fileResource, logInfo, dateTimeFormat;
	
	public DiaryViewImpl(){
	
		title = "Title";
		entry = "Diary entry";
		exampleText = "What have you done today\n" + "How did you feel today?";
		add = "Add";
		deleteSelect = "Delete Selected";
		date = "Date";
		status = "Status";
		gridWidth = "1200";
		textAreaWidth = "50%";
		fileResource = "/WEB-INF/images/diary/smileys.JPG";
		logInfo = "Add Diary Entry click";
		dateTimeFormat = "yyyy-MM-dd";
		
		vLayout = new VerticalLayout();
		buttonLayout = new HorizontalLayout();

		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
	
		// Create a DateField
		dateField = new DateField();
		dateField.setValue(LocalDate.now());
		
		//Smiley RadioButton Group
		FileResource smileyRadio = new FileResource(new File(basepath + fileResource));
		smileyRadioGroup = new RadioButtonGroup<>();
		smileyRadioGroup.setItems(DiaryStates.Good.toString(), DiaryStates.Medium.toString(), DiaryStates.Bad.toString());
		smileyRadioGroup.setIcon(smileyRadio);
		smileyRadioGroup.setStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL);
		
		
		//Title Textfield
		textField = new TextField(title);
		
		
		// Create a text area
		txtArea = new TextArea(entry);
		txtArea.setWidth(textAreaWidth);
		txtArea.setValue(exampleText);
		
		
		//Button Add
		buttonAdd = new Button(add);
		
		buttonAdd.addClickListener(clickEvent -> {
			logger.log(Level.INFO, logInfo);
			for (DiaryButtonClickListener listener : diaryButtonListeners) {
				String dateInput = getDateField();
				String radioInput = getRadioGroup();
				String titleInput = getTextField();
				String diaryInput = getTextArea();
				
				listener.addButtonClick(dateInput, radioInput, titleInput, diaryInput);
			}	
		});
		
		//Button Delete
		buttonDelete = new Button(deleteSelect);
	
	
		//Grid Table
		grid = new Grid<>();
		
		TextField nameEditor = new TextField();
		
		grid.addColumn(DiaryEntry::getDate).setCaption(date).setWidth(120);
		grid.addColumn(DiaryEntry::getStatus).setCaption(status).setWidth(100);
		grid.addColumn(DiaryEntry::getTitle).setCaption(title).setWidth(200);
		grid.addColumn(DiaryEntry::getDiaryEntry).setEditorComponent(nameEditor, DiaryEntry::setDiaryEntry).setCaption(entry);
		
		//grid.getEditor().setEnabled(true); Schreibt änderungen nicht in DB
		
		grid.setWidth(gridWidth);
		grid.setSizeFull();
		grid.setSelectionMode(SelectionMode.NONE);

		//Grid Multiselection
		selectionModel = (MultiSelectionModel<DiaryEntry>) grid.setSelectionMode(SelectionMode.MULTI);
		selectionModel.selectAll();
		
		//Delete Multiselection
		selectionModel.addMultiSelectionListener(event -> {
			Set<DiaryEntry> toDelete = event.getAllSelectedItems();
			buttonDelete.addClickListener(clieckEvent -> {
				for (DiaryButtonClickListener listener : diaryButtonListeners) {
					listener.deleteSelected(toDelete);
				}
			});
		});

	
		buttonLayout.addComponents(buttonAdd, buttonDelete);
		vLayout.addComponents(dateField, smileyRadioGroup, textField, txtArea, buttonLayout, grid);
		setCompositionRoot(vLayout);	
	}
	
	@Override
	public void addDiaryButtonClickListener(DiaryButtonClickListener clickListener) {
		diaryButtonListeners.add(clickListener);
		
	}
	
	public String getDateField() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
		stringDate = dateField.getValue().format(formatter);
		return stringDate;
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
	

	public void initializeDiaryEntry(Set<DiaryEntry> diaryEntry){
		grid.setItems(diaryEntry);
	}
	
	public Button getDeleteButton() {
		return this.buttonDelete;
	}
}
