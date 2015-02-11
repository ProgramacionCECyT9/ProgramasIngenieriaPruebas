import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class TClave {

	private String nombre=null;
	private String contra=null;
	private String permisos=null;
	Connection conn=null;
	Statement stat=null;
	ResultSet rs=null;

	private boolean conecta(){
		boolean resp=false;
		System.out.println("reconocer driver");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception ex) {
			System.out.println("Fallo driver: "+ex);
		}
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/","root","antares05");
			resp=true;
		} catch (SQLException se) {
			System.out.println("Mensaje: "+se.getMessage());
			System.out.println("Estado: "+se.getSQLState());
			System.out.println("Error: "+se.getErrorCode());
		}
		return resp;
	}

	private int busca(String nn) {
		int resp=0;
		try{
			stat=conn.createStatement();
			rs=stat.executeQuery("use claves;");
			rs=stat.executeQuery("select * from clavebas where nombre='"+nn+"';");
			String datos;
			while (rs.next()) {
				datos="nombre= "+rs.getString("nombre");
				datos=datos +" contrasenia= "+rs.getString("contra");
				System.out.println(datos);
				nombre=rs.getString("nombre");
				contra=rs.getString("contra");
				permisos=rs.getString("permiso");
				resp=1;
			}
		} catch (SQLException se) {
			System.out.println("LMensaje: "+se.getMessage());
			System.out.println("LEstado: "+se.getSQLState());
			System.out.println("LError: "+se.getErrorCode());
		}
		System.out.println("Terminamos por ahora");
		return resp;
	}

	public int identif(String nn, String cc) {
		int resp=0;
		int bres;
		if (conecta()) {
			if ((bres=busca(nn))==1) {
				if ((nombre.equals(nn))&& (contra.equals(cc)))
					resp=1; else resp = -1; //contraseña errónea
			}
			else resp =-2; // usuario no existe
		}
		else resp=-3; //problema de conexión
		return resp;
	}
	public String damePermisos() {
		return permisos;
	}
}