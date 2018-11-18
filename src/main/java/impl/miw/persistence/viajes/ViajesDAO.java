package impl.miw.persistence.viajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.miw.model.Book;
import com.miw.model.BusquedaData;
import com.miw.model.Destino;
import com.miw.model.Viaje;
import com.miw.persistence.BookDataService;
import com.miw.persistence.ViajesDataService;

/**
 * Clase que implementa las operaci�nes de acceso a la base de datos para la
 * entidad LIBRO.
 * 
 * @author Daniel F. Lanvin
 * @since 24/02/2004
 * @version 1.0
 */
public class ViajesDAO implements ViajesDataService {
	/**
	 * M�todo que accede a la base de datos para recuerar la lista de libros
	 * presentes en la base de datos.
	 */
	public Vector<Viaje> getViajes() throws Exception {
		//Inicializamos el Vector de retorno.
		Vector<Viaje> resultado = new Vector<Viaje>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
 
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexi�n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement("select * from viajes");
			rs = ps.executeQuery();

			while (rs.next()) {
				//Completamos los datos del Libro en la entidad
				Viaje viaje = new Viaje();
				viaje.setIdViaje(rs.getInt("idViaje"));
				viaje.setLugarSalida(rs.getString("lugarSalida"));
				viaje.setLugarLlegada(rs.getString("lugarLlegada"));
				viaje.setFechaViaje(rs.getDate("fechaViaje"));
				viaje.setHoraSalida(rs.getString("horaSalida"));
				viaje.setHoraLlegada(rs.getString("horaLlegada"));
				viaje.setPrecio(rs.getFloat("precio"));
				//La a�adimos al Vector de resultado
				resultado.add(viaje);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		//Retornamos el vector de resultado.
		return resultado;
	}

	public String getImagenDestino(String destino) throws Exception {
		
		String resultado = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
 
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexi�n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement("select imagen from destinos where destino='"+destino+"';");
			rs = ps.executeQuery();

			while (rs.next()) {
				//Completamos los datos del Libro en la entidad
				resultado=rs.getString("imagen");
				System.out.println(resultado);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		//Retornamos el vector de resultado.
		return resultado;
	}

	public Vector<Destino> getDestinosMasPopulares() throws Exception {
		Vector<Destino> resultado = new Vector<Destino>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
 
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexi�n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement("select destino,popularidad from destinos order by popularidad desc;");
			rs = ps.executeQuery();

			while (rs.next()) {
				//Completamos los datos del Libro en la entidad
				Destino destino = new Destino();
				destino.setPopularidad(rs.getInt("popularidad"));
				destino.setDestino(rs.getString("destino"));
				//La a�adimos al Vector de resultado
				resultado.add(destino);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		//Retornamos el vector de resultado.
		return resultado;
	}

	public Viaje getViaje(int identificadorViaje) throws Exception {
		Viaje viaje = new Viaje();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
 
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexi�n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement("select * from viajes where idviaje="+identificadorViaje+";");
			rs = ps.executeQuery();

			while (rs.next()) {
				//Completamos los datos del Libro en la entidad
				viaje.setIdViaje(rs.getInt("idViaje"));
				viaje.setLugarSalida(rs.getString("lugarSalida"));
				viaje.setLugarLlegada(rs.getString("lugarLlegada"));
				viaje.setFechaViaje(rs.getDate("fechaViaje"));
				viaje.setHoraSalida(rs.getString("horaSalida"));
				viaje.setHoraLlegada(rs.getString("horaLlegada"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		//Retornamos el vector de resultado.
		return viaje;
	}

	

}