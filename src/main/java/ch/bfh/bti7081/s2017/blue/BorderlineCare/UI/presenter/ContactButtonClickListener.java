package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.util.Set;

import com.vaadin.ui.PopupView;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;

public interface ContactButtonClickListener {
	public void deleteButtonClick(PopupView popuu, Set<Contact> toDelete);
	public void saveButtonClick(String stringInput, int integerInput);
	public void cancelButtonClick();
	public void deleteContact(Contact toRemove);
	public void deleteSelected(Set<Contact> contacts);
	public void deleteContacts(Set<Contact> contacts);

}
