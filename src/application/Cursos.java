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

public class Cursos {
	
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String dato, query;
    Conexion conect = new Conexion();
    
	
	@FXML
	private ComboBox<String> cmbHorario;
	
	@FXML
	private ComboBox<String> cmbInstructor;
	
	@FXML
	private TextField txtNombre;
	
	@FXML
	private TextArea txtEntrada;
	
	@FXML
	private Button btnCrear;
	
	@FXML
	private Button bntLimpiar;
	
	
	@FXML
	void crearCurso(MouseEvent event) throws IOException, SQLException {
		
        //Recuperar datos del formulario
        //Validar Datos
        //Preparar la insercion
        String nom = txtNombre.getText();
        String hora = cmbHorario.getValue();
        System.out.println(hora.substring(0,1));
        int idHora = Integer.parseInt(hora.substring(0,1));
        String dia = cmbInstructor.getValue();
        System.out.println(dia.substring(0,1));
        int idInstructores = Integer.parseInt(dia.substring(0,1));
        if(nom==null || nom.isEmpty())
            txtEntrada.setText("Debe ingresar una nombre valido");
        if(hora==null || hora.isEmpty())
            txtEntrada.setText("Seleccione una hora valida");
        else if(dia==null || dia.isEmpty())
            txtEntrada.setText("Seleccione un dia valido");
        else{
            String query1 = "insert into cursos (nombre,id_horario,id_instructor)values ('"+nom+"','"+idHora+"','"+idInstructores+"')";
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
	void initialize() throws IOException, SQLException{
	    //Declaro variable
	    
	    ResultSet rst;
	    //Conectarme a la base de datos        
	    conect.conectar();
	    System.out.println("Voy bien antes del combo");
	    //Preparar para recuperar datos de la base de datos. Tabla horario
	    query = "SELECT idhorario,dia,hora from horario order by dia,hora";
	    try (Statement stm = (conect.getCon()).createStatement()){ //Preparo el area para las consultas
	        System.out.println("Voy bien de la consulta combo");
	        rst = stm.executeQuery(query);
	        System.out.println("Voy bien dentro combo");
	        while (rst.next()) {
	            dato = String.format("%d %s %s", rst.getInt("idhorario"), rst.getString("dia"), rst.getString("hora"));
	            cmbHorario.getItems().add(dato);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    //Preparar para recuperar datos de la base de datos. Tabla Persona
	    query = "SELECT idpersona,nombre from persona where tipo = 1 order by nombre";
	    try (Statement stm = (conect.getCon()).createStatement()){ //Preparo el area para las consultas
	        rst = stm.executeQuery(query);
	        while (rst.next()) {
	            dato = String.format("%d %s", rst.getInt("idpersona"), rst.getString("nombre"));
	            cmbInstructor.getItems().add(dato);
	        }
	    } catch (Exception e) {
	    }
	    
	}

}
