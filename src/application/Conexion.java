package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private Connection con;
	private String usuario = "xFaiL";
	private String password = "0526sebas";
	private boolean conectado;
	
	public Connection getCon() {
        return con;
    }
	
	public boolean isConectado() {
        return conectado;
    }

    public Conexion () {
        //this.host = null;
        this.con = null;
        this.conectado = false;
        
    }
    
    public void conectar() throws SQLException{
       try {
            //obtener el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/horariocasa",usuario,password);
            this.conectado=true;
            System.out.println("conectado");
        } catch (ClassNotFoundException e) {
            this.conectado=false;
            e.printStackTrace();
        }
    }
    
    public void desconectar(){
        if(this.conectado){
            this.conectado=false;
            try{
                this.con.close();
            }
            catch(SQLException ex){
                this.con=null;
            }
        }
    }
}
