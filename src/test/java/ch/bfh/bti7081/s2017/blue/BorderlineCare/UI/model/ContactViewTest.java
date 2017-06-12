//package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ContactViewPresenter;
//import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.ContactViewImpl;
//
//public class ContactViewTest {
//
//	@Test
//	public void testAddContact() {
//		ContactViewImpl view = new ContactViewImpl();
//		ContactModel model = new ContactModel();
//		ContactViewPresenter presenter = new ContactViewPresenter(model, view);
//		long numOfContacts = model.getContacts().size();
//		System.out.println(numOfContacts);
//		for(int i=0; i<model.getContacts().size(); i++){
//			System.out.println(model.getContacts().get(i));
//		}
//		presenter.saveButtonClick("TestContact", 123456);
//		for(int i=0; i<model.getContacts().size(); i++){
//			System.out.println(model.getContacts().get(i));
//		}
//		System.out.println(numOfContacts);
//		assertEquals(8, model.getContacts().size());
//	}
//
//}
