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
import javafx.scene.input.MouseEvent;

public class inscripcionCurso{
	
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String dato, query;
    Conexion conect = new Conexion();
    
	@FXML
	private ComboBox<String> cmbInscripcion;
	
	@FXML
	private Button btnInscribirse;
	
	@FXML
	private TextArea txtEntrada;
	
	Controller per = new Controller();
	
	
	
	@FXML
	void inscribirCurso(MouseEvent event) throws IOException, SQLException {
		
        //Recuperar datos del formulario
        //Validar Datos
        //Preparar la insercion
        String curso = cmbInscripcion.getValue();
        System.out.println(curso.substring(0,1));
        int codCurso = Integer.parseInt(curso.substring(0,1));
        if(curso==null || curso.isEmpty())
            txtEntrada.setText("Seleccione un curso valido");
        else{
            String query1 = "Update persona set codigo = '"+codCurso+"' where idpersona= 1";
            conect.conectar();
            try (Statement stm = conect.getCon().createStatement()){
                int rest = stm.executeUpdate(query1);
                if(rest != 0){
                    txtEntrada.setText("Su inscripcion se realizo de manera exito");
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
	    query = "SELECT codigo,nombre from cursos order by nombre";
	    try (Statement stm = (conect.getCon()).createStatement()){ //Preparo el area para las consultas
	        System.out.println("Voy bien de la consulta combo");
	        rst = stm.executeQuery(query);
	        System.out.println("Voy bien dentro combo");
	        while (rst.next()) {
	            dato = String.format("%d %s", rst.getInt("codigo"), rst.getString("nombre"));
	            cmbInscripcion.getItems().add(dato);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    query = "SELECT documento from personas order by nombre";

	}
}
