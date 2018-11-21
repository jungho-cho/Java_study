package com.jungho.address.view;

import java.io.File;

import com.jungho.address.MainApp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class RootLayoutController {
	private MainApp mainApp;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void initialize() {
		System.out.println("RootLayoutController initialize");
	}
	@FXML
	private void onMenuNew() {
		mainApp.getPersonData().clear();
		mainApp.setPersonFilePath(null);
		
		System.out.println("RootLayoutController::onMenuNew");
	}
	
	@FXML
	private void onMenuOpen() {
		FileChooser fileChooser = new FileChooser();
		
		FileChooser.ExtensionFilter extFilter = 
				new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
		
		if (file != null) {
			mainApp.loadPersonDataFromFile(file);
		}
	}
	
	@FXML
	private void onMenuSave() {
		File personFile = mainApp.getPersonFilePath();
		if (personFile != null) {
			mainApp.savePersonDataToFile(personFile);
		} else {
			onMenuSaveAs();
		}
	}
	
	@FXML
	private void onMenuSaveAs() {
		FileChooser fileChooser = new FileChooser();
		
		FileChooser.ExtensionFilter extFilter = 
				new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		
		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
		
		if (file != null) {
			if (file.getPath().endsWith(".xml") == false) {
				file = new File(file.getPath() + ".xml");
			}
			
			mainApp.savePersonDataToFile(file);
		}
	}
	
	@FXML
	private void onMenuAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("AddressApp");
        alert.setHeaderText("About");
        alert.setContentText("About Context Text");
        alert.showAndWait();
	}
	
	@FXML
	private void onMenuExit() {
		System.exit(0);
	}
}
