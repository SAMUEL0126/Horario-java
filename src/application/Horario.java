package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Horario {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    String dato, query;
  
   
    
    Conexion conect = new Conexion();
	
	@FXML
	private ComboBox<String> comboDia;
	
	@FXML
	private ComboBox<String> comboHora;
	
	@FXML
	private ComboBox<String> comboInstructor;
	
	@FXML
	private TextField inputNombre;
	
	@FXML
	private TextArea txtEntrada;
	
	@FXML
	private Button btnGuardar;
	
	@FXML
	private Button bntLimpiarForm;
	
	
	@FXML
	void crearHorario(MouseEvent event) throws IOException, SQLException {
		
        //Recuperar datos del formulario
        //Validar Datos
        //Preparar la insercion
//        String nom = inputNombre.getText();
        String hora = comboHora.getValue();
        String dia = comboDia.getValue();
//        if(nom==null || nom.isEmpty())
//            txtEntrada.setText("Debe ingresar una nombre valido");
        if(hora==null || hora.isEmpty())
            txtEntrada.setText("Seleccione una hora valida");
        else if(dia==null || dia.isEmpty())
            txtEntrada.setText("Seleccione un dia valido");
        else{
            String query1 = "insert into horario (dia,hora)values ('"+dia+"','"+hora+"')";
            conect.conectar();
            try (Statement stm = conect.getCon().createStatement()){
                int rest = stm.executeUpdate(query1);
                if(rest != 0){
                    txtEntrada.setText("Datos Registrados con exito");
                }
                else{
                    txtEntrada.setText("Error al grabar los datos por favor verifique");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            conect.desconectar();
        }

    }
	
	

    @FXML
    void initialize() throws SQLException{ // Metodo de javafx que sirve para inicializar combox y demas en java apenas se abra una ventana
        // Para inicializar valores de combo de genero
        comboHora.getItems().clear();
        comboDia.getItems().clear();
        comboHora.getItems().addAll("6:00","7:00","8:00","9:00","10:00","11:00","12:00");
        comboDia.getItems().addAll("Lunes","Martes","Miercoles","Jueves","Viernes");

        }
    
     }



    


