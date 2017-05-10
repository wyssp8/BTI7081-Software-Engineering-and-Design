package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.SettingsViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.SettingsViewImpl;

public class SettingsViewPresenter {

	private SettingsViewImpl settingsView;
	private static SettingsViewModel settingsModel;
	
	
	
	public SettingsViewPresenter(SettingsViewModel settingsModel , SettingsViewImpl settingsView) {
			this.settingsView = settingsView;
			this.settingsModel=settingsModel;
			
		//initialize eContacts
			settingsView.contact1.setValue(settingsModel.geteContact1());
			settingsView.contact2.setValue(settingsModel.geteContact2());
			settingsView.contact3.setValue(settingsModel.geteContact3());
			settingsView.login.setValue(settingsModel.getLogin());
			settingsView.password.setValue(settingsModel.getPassword());
			
	}
	
		//Save eContacts
	public static void saveEContacts(String c1 , String c2, String c3){
		settingsModel.seteContact1(c1);
		settingsModel.seteContact2(c2);
		settingsModel.seteContact3(c3);
	}
	

	
	
}
