package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiaryViewModelTest {

	@Test
	public void testValidateDiaryEntry() {
		DiaryViewModel model = new DiaryViewModel();
		assertFalse(model.validateDiaryEntry("", "", "", ""));
		assertFalse(model.validateDiaryEntry("   ", "  ", " ", "   "));
		assertTrue(model.validateDiaryEntry("test", "test", "test", "test"));
		assertFalse(model.validateDiaryEntry("a", "b", "c", ""));
		assertFalse(model.validateDiaryEntry("", "b", "c", "d"));
		assertFalse(model.validateDiaryEntry("a", "", "c", "d"));
		assertFalse(model.validateDiaryEntry("a", "b", "", "d"));
	}
}
