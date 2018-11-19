package com.jungho.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import com.jungho.address.model.Person;
import com.jungho.address.util.DateUtil;
import com.jungho.address.MainApp;

public class PersonOverviewController {
	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;
	
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalcodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label birthdayLabel;
	
	private MainApp mainApp;
	
	public PersonOverviewController() {
		
	}
	@FXML
	private void initialize() {
		firstNameColumn.setCellValueFactory(
				cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(
				cellData -> cellData.getValue().lastNameProperty());
		
		showPersonDetails(null);
		
		personTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showPersonDetails(newValue));
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		personTable.setItems(mainApp.getPersonData());
	}
	
	private void showPersonDetails(Person person) {
		if (person != null) {
			firstNameLabel.setText(person.getFirstName());
			lastNameLabel.setText(person.getLastName());
			streetLabel.setText(person.getStreet());
			cityLabel.setText(person.getCity());
			postalcodeLabel.setText(Integer.toString(person.getPostalCode()));
			birthdayLabel.setText(DateUtil.foramt(person.getBirthday()));
		} else {
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			streetLabel.setText("");
			cityLabel.setText("");
			postalcodeLabel.setText("");
			birthdayLabel.setText("");
		}
	}
	
	@FXML
	private void handleDeletePerson() {
		int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
		personTable.getItems().remove(selectedIndex);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("please select a person in the table");
			
			alert.showAndWait();
		}
	}
	@FXML
	private void handleNewPerson() {
		Person temp = new Person();
		boolean okClicked = mainApp.showPersonEditDialog(temp);
		if (okClicked) {
			mainApp.getPersonData().add(temp);
		}
	}
	
	@FXML
	private void handleEditPerson() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
			if (okClicked) {
				showPersonDetails(selectedPerson);
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Person Selected");
	        alert.setContentText("Please select a person in the table.");

	        alert.showAndWait();
		}
	}
}
