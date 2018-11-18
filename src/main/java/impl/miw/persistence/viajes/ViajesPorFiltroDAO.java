package impl.miw.persistence.viajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.miw.model.BusquedaData;
import com.miw.model.Viaje;
import com.miw.persistence.BookDataService;
import com.miw.persistence.ViajesDataService;
import com.miw.persistence.ViajesPorFiltroDataService;

/**
 * Clase que implementa las operaci�nes de acceso a la base de datos para la
 * entidad LIBRO.
 * 
 * @author Daniel F. Lanvin
 * @since 24/02/2004
 * @version 1.0
 */
public class ViajesPorFiltroDAO implements ViajesPorFiltroDataService {
	/**
	 * M�todo que accede a la base de datos para recuerar la lista de libros
	 * presentes en la base de datos.
	 */
	public Vector<Viaje> getViajesPorFiltroIda(BusquedaData busqueda) throws Exception {
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

			ps = con.prepareStatement("select * from viajes where lugarSalida='"+busqueda.getLugarSalida()+"' AND lugarLlegada='"+busqueda.getLugarLlegada()+"'and fechaviaje='"+busqueda.getFechaIda()+"';");
			rs = ps.executeQuery();

			while (rs.next()) {
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
	
	public Vector<Viaje> getViajesPorFiltroVuelta(BusquedaData busqueda) throws Exception {
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

			ps = con.prepareStatement("select * from viajes where lugarSalida='"+busqueda.getLugarLlegada()+"' AND lugarLlegada='"+busqueda.getLugarSalida()+"'and fechaviaje='"+busqueda.getFechaVuelta()+"';");
			rs = ps.executeQuery();

			while (rs.next()) {
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

}