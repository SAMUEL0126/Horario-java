package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Persona {
	
	@FXML
	private MenuItem optDates;
	
	@FXML
	private MenuItem optAccion;
	
	@FXML
	private MenuItem optInscriptio;
	
	@FXML
	private MenuItem optHorario;
	
	@FXML
	private MenuItem optSalir;
	
	
	
	
	@FXML
	void ingresarVerCursos(ActionEvent event) throws IOException  {
		try {
			Parent root = ( new FXMLLoader(getClass().getResource("inscripcion.fxml"))).load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage teatro = new Stage();
			teatro.setScene(scene);
			teatro.show();
			teatro.setTitle("Cursos");			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void verHorario(ActionEvent event) throws IOException  {
		try {
			Parent root = ( new FXMLLoader(getClass().getResource("horario.fxml"))).load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage teatro = new Stage();
			teatro.setScene(scene);
			teatro.show();
			teatro.setTitle("Horario");			
		} catch(Exception e) {
			//e.printStackTrace();
		}
	}
	
	
	@FXML
	void ingresarHorario(ActionEvent event) throws IOException  {
		try {
			Parent root = ( new FXMLLoader(getClass().getResource("horario.fxml"))).load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage teatro = new Stage();
			teatro.setScene(scene);
			teatro.show();
			teatro.setTitle("Horario");			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void ingresarCurso(ActionEvent event) throws IOException  {
		try {
			Parent root = ( new FXMLLoader(getClass().getResource("cursos.fxml"))).load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage teatro = new Stage();
			teatro.setScene(scene);
			teatro.show();
			teatro.setTitle("Horario");			
		} catch(Exception e) {
			//e.printStackTrace();
		}
	}
	
	
}
