package com.jungho.address.view;

import com.jungho.address.model.Person;
import com.jungho.address.util.DateUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController {
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField streetField;
	@FXML
	private TextField postalcodeField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField birthdayField;
	
	private Stage dialogStage;
	private Person person;
	private boolean okClicked = false;
	
	@FXML
	private void initailize() {
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setPerson(Person person) {
		this.person = person;
		
		firstNameField.setText(this.person.getFirstName());
		lastNameField.setText(this.person.getLastName());
		streetField.setText(this.person.getStreet());
		cityField.setText(this.person.getCity());
		postalcodeField.setText(Integer.toString(this.person.getPostalCode()));
		birthdayField.setText(DateUtil.foramt(this.person.getBirthday()));
		birthdayField.setPromptText("dd.mm.yyyy");
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void okButtonClicked() {
		if (isInputValid()) {
			person.setFirstName(firstNameField.getText());
			person.setLastName(lastNameField.getText());
			person.setStreet(streetField.getText());
			person.setCity(cityField.getText());
			person.setPostalCode(Integer.parseInt(postalcodeField.getText()));
			person.setBirthday(DateUtil.parse(birthdayField.getText()));
			
			okClicked = true;
			dialogStage.close();
		}
	}
	
	@FXML
	private void cancelButtonClicked() {
		dialogStage.close();
	}
	
	private boolean isInputValid() {
		String errorMsg = "";
		
		if (firstNameField.getText() == null || 
			firstNameField.getText().length() == 0) {
			errorMsg += "No valid first name!\n";
		}
		if (lastNameField.getText() == null || 
			lastNameField.getText().length() == 0) {
			errorMsg += "No valid last name!\n";
		}
		if (streetField.getText() == null || 
			streetField.getText().length() == 0) {
			errorMsg += "No valid street!\n";
		}
		if (postalcodeField.getText() == null || 
			postalcodeField.getText().length() == 0) {
			errorMsg += "No valid postal code!\n";
		} else {
			try {
				Integer.parseInt(postalcodeField.getText());
			} catch (NumberFormatException e) {
				errorMsg += "No valid postal code (must be an integer)!\n";
			}
		}
		if (cityField.getText() == null || 
			cityField.getText().length() == 0) {
			errorMsg += "No valid city!\n";
		}
		if (birthdayField.getText() == null || 
			birthdayField.getText().length() == 0) {
			errorMsg += "No valid birthday!\n";
		} else {
			if (DateUtil.vaildDate(birthdayField.getText()) == false) {
				errorMsg += "No valid birthday. Use the format dd.mm.yyyy!\n";
			}
		}
		
		if (errorMsg.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invaild Fields");
			alert.setHeaderText("Please correct invaild fields");
			alert.setContentText(errorMsg);
			
			alert.showAndWait();
			
			return false;
		}
	}
}
