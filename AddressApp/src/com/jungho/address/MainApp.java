package com.jungho.address;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static final String SCENE_ROOTLAYOUT = "view/RootLayout.fxml";
	public static final String SCENE_PERSONOVERVIEW = "view/PersonOverView.fxml";

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Address App");

		initRootLayou();
		
		showPersonOverView();
	}

	public void initRootLayou() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(MainApp.SCENE_ROOTLAYOUT));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showPersonOverView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(MainApp.SCENE_PERSONOVERVIEW));
			AnchorPane personOverView = (AnchorPane) loader.load();
			
			rootLayout.setCenter(personOverView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
