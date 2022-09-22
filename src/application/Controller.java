package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	
	
	
	@FXML
	private TextField inputUser;

	@FXML
	private PasswordField inputPassword;
	
	@FXML
	private Button btnLogin;
	
	@FXML
	private Button btnRegister;
	
	@FXML 
	private Label label;
	
	
	@FXML
	void btnIngresar(ActionEvent event) throws SQLException, IOException{
		String email = inputUser.getText();
        String documento = inputPassword.getText();
        Conexion conect = new Conexion();
        conect.conectar();
        if(conect.isConectado()){
        	System.out.println("Estoy dentro if");
            String query = "SELECT idpersona from persona where email = '"+email+"' AND documento = '"+documento+"' AND tipo = '"+1+"'";
            try (Statement stm = (conect.getCon()).createStatement()){
                ResultSet rst = stm.executeQuery(query);
                if(rst.next()){
                    //System.out.println("entra");
                    //Cerrrar la ventana anterior
                    //System.out.println("btnIngr: "+btnIngr);
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.close();
                    //Crear la nueva ventana
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("homeInstructores.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    //stage.close();
                    stage.setTitle("Home");
                    stage.setScene(scene);
                    //FXMLHomeController data = (FXMLHomeController)loader.getController();
                    //data.setBienvenidoLbl("Hola : "+login+" Bienvenido.");
                    
                    stage.show();
                    conect.desconectar();
                      
                }
                if(conect.isConectado()){
                	System.out.println("Estoy dentro if");
                    	String query1 = "SELECT idpersona from persona where email = '"+email+"' AND documento = '"+documento+"' AND tipo = '"+0+"'";
                    try (Statement stm1 = (conect.getCon()).createStatement()){
                    	System.out.println("Estoy dentro try");
                        ResultSet rst1 = stm1.executeQuery(query1);
                        if(rst1.next()){
                            //System.out.println("entra");
                            //Cerrrar la ventana anterior
                            //System.out.println("btnIngr: "+btnIngr);
                            Stage stage = (Stage) btnLogin.getScene().getWindow();
                            stage.close();
                            //Crear la nueva ventana
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("homeStudiantes.fxml"));
                            Parent root = loader.load();
                            Scene scene = new Scene(root);
                            stage = new Stage();
                            //stage.close();
                            stage.setTitle("Home");
                            stage.setScene(scene);
                            //FXMLHomeController data = (FXMLHomeController)loader.getController();
                            //data.setBienvenidoLbl("Hola : "+login+" Bienvenido.");
                            
                            stage.show();
                            conect.desconectar();
                
                        }           
                else
                    label.setText("Usuario o Clave no validos");
                
            } catch (Exception e) {
                System.out.println("ERROR: Aborting...");
                e.printStackTrace();
      
        }
        }
}
        }
	}
	
	
	
	@FXML
	void ingresarRegistro(ActionEvent event) throws IOException  {
		try {
			Parent root = ( new FXMLLoader(getClass().getResource("register.fxml"))).load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage teatro = new Stage();
			teatro.setScene(scene);
			teatro.show();
			teatro.setTitle("Registro");			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
