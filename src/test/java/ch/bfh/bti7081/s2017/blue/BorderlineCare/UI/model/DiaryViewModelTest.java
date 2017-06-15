package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

public class DiaryViewModelTest {

	
	@Before
	public void setUp(){
		DBConnector dbConn = DBConnector.getDBConnector();
		dbConn.setAccountEmail("polo@test.com");
	}
	
	@Test
	public void testValidateDiaryEntry() {
		DiaryViewModel model = new DiaryViewModel();
		assertFalse(model.validateDiaryEntry("", "", "", ""));
		assertFalse(model.validateDiaryEntry("   ", "  ", " ", "   "));
		assertTrue(model.validateDiaryEntry("test", "test", "test", "test"));
		assertFalse(model.validateDiaryEntry("a", "b", "c", ""));
		assertFalse(model.validateDiaryEntry("", "b", "c", "d"));
		assertFalse(model.validateDiaryEntry("a", null, "c", "d"));
		assertFalse(model.validateDiaryEntry("a", "b", "", "d"));
	}
	
	@Test
	public void testGetLatestDiaryEntry(){
		DiaryViewModel model = new DiaryViewModel();
		model.getDiaryEntries().clear();
		boolean gotException = false;
		try {
			model.getLatestDiaryEntry();
		} catch (Exception e) {
			gotException = true;
		}
		assertTrue(gotException);
		DiaryEntry diaryEntry = new DiaryEntry("01.01.2017", "Good", "Title", "Entry", new LoginAccount());
		model.getDiaryEntries().add(diaryEntry);
		try {
			assertEquals(model.getLatestDiaryEntry(), diaryEntry);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
}
