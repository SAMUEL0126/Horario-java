package application;

import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class Registro {
	
    String query;
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    Conexion con = new Conexion();
			
	@FXML
	private TextField inputDocu;
	
	@FXML
	private Text txtDoc;
	
	@FXML
	private TextField inputName;
	
	@FXML
	private Text txtName;
	@FXML
	private TextField inputLastName;
	
	@FXML
	private Text txtLastN;
	
	@FXML
	private TextField inputAge;
	
	@FXML
	private Text txtAge;
	
	@FXML
	private TextField inputEmail;
	
	@FXML
	private Text txtEmail;
	
    @FXML
    private ComboBox<String> inputType;
    
    @FXML
    private Text txtType;
    
    @FXML
    private Button btnRegister;
    
    
    @FXML
    void crearRegistro(MouseEvent event) throws SQLException {
        //Recuperar datos del formulario
        //Validar Datos
        //Preparar la insercion
        String doc = inputDocu.getText();
        String nom = inputName.getText();
        String ape = inputLastName.getText();
        String eda = inputAge.getText();
        String ema = inputEmail.getText();
        String typ = inputType.getValue();
        if(doc==null || doc.isEmpty())
        	txtDoc.setText("Debe ingresar una Identificacion valida");
        else if(nom==null || nom.isEmpty())
            txtName.setText("Debe ingresar un Nombre valido");
        else if(ape==null || ape.isEmpty())
            txtLastN.setText("Debe ingresar un Apellido valido");
        else if(eda==null || eda.isEmpty())
            txtAge.setText("Debe ingresar una edad valida");
        else if(ema ==null || ema.isEmpty())
        	txtEmail.setText("Debe ingresar un correo valido");
        else if(typ==null || typ.isEmpty())
            txtType.setText("Debe ingresar un tipo de usuario valido");
        else{
        	if(typ=="Instructor") {
        		 query = "insert into persona (documento,nombre,apellido,edad,email,tipo)values ('"+doc+"','"+nom+"','"+ape+"','"+eda+"','"+ema+"','"+1+"')";
        	}else if(typ=="Aprendiz"){
        		 query = "insert into persona (documento,nombre,apellido,edad,email,tipo)values ('"+doc+"','"+nom+"','"+ape+"','"+eda+"','"+ema+"','"+0+"')";
        	}
            con.conectar();
            try (Statement stm = con.getCon().createStatement()){
                int rest = stm.executeUpdate(query);
                if(rest != 0){
                	alerta.setContentText("Datos Registrados con exito");
                }
                else{
                    alerta.setContentText("Error al grabar los datos por favor verifique");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            con.desconectar();
        }
        }
    
        
    
    @FXML
    void initialize(){ // Metodo de javafx que sirve para inicializar combox y demas en java apenas se abra una ventana
        // Para inicializar valores de combo de genero
        inputType.getItems().clear();
        inputType.getItems().addAll("Aprendiz", "Instructor");
       
    }
   
}
