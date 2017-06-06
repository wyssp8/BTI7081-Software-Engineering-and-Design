package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.data.Binder.Binding;
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
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.EmergencyViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ContactButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.DiaryViewPresenter;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.DiaryButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.EmergencyButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.DiaryView;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.MainView;

public class DiaryViewImpl extends CustomComponent implements DiaryView {
	

	private static final long serialVersionUID = -6250389995528614659L;
	private final static Logger logger = Logger.getLogger(DiaryViewModel.class.getName());

	private List<DiaryButtonClickListener> diaryButtonListeners = new ArrayList<DiaryButtonClickListener>();
	
	private Button buttonAdd;
	private RadioButtonGroup<String> smileyRadioGroup;
	
	private DateField date;
	private TextField textField;
	private TextArea txtArea;
	private String stringDate;
	
	private Grid<DiaryEntry> grid;
	private MultiSelectionModel<DiaryEntry> selectionModel;
	
	
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
		smileyRadioGroup.setItems(DiaryStates.Good.toString(), "Medium", "Bad");
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
		
		TextField nameEditor = new TextField();
		
		grid.addColumn(DiaryEntry::getDate).setCaption("Date").setWidth(120);
		grid.addColumn(DiaryEntry::getStatus).setCaption("Status").setWidth(100);
		grid.addColumn(DiaryEntry::getTitle).setCaption("Title").setWidth(200);
		grid.addColumn(DiaryEntry::getDiaryEntry).setEditorComponent(nameEditor, DiaryEntry::setDiaryEntry).setCaption("Entry");
		
		grid.getEditor().setEnabled(true);
		
		grid.setWidth("1200");
		grid.setSizeFull();
		grid.setSelectionMode(SelectionMode.NONE);
		//grid.addStyleName("v-grid-cell");

		//Grid Multiselection
		//selectionModel = (MultiSelectionModel<DiaryEntry>) grid.setSelectionMode(SelectionMode.MULTI);
		//selectionModel.selectAll();
		
		//Grid Delete
		grid.addColumn(DiaryEntry -> "delete",
				new ButtonRenderer<DiaryEntry>(clickEvent -> {
					for (DiaryButtonClickListener listener : diaryButtonListeners) {
						DiaryEntry toDelete = clickEvent.getItem();
						listener.deleteButtonClick(toDelete);
					}
				}));
		
		vLayout.addComponent(grid);
		buttonAdd.addClickListener(clickEvent -> {
			logger.log(Level.INFO, "Add Diary Entry click");
			for (DiaryButtonClickListener listener : diaryButtonListeners) {
				String dateInput = getDateField();
				String radioInput = getRadioGroup();
				String titleInput = getTextField();
				String diaryInput = getTextArea();
				
					listener.addButtonClick(dateInput, radioInput, titleInput, diaryInput);
					
				
			}	
		});
		//setCompositionRoot(hLayout);
		setCompositionRoot(vLayout);
				
	}
	
	public void initAddDiaryEntry() {
		
	}
	

	
	
	public void setName(String name) {
		buttonAdd.setCaption(name);
	}
	
	public String getDateField() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		stringDate = date.getValue().format(formatter);
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

	@Override
	public void addDiaryButtonClickListener(DiaryButtonClickListener clickListener) {
		diaryButtonListeners.add(clickListener);
		
	}
	

}
