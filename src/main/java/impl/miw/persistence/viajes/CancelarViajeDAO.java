package impl.miw.persistence.viajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.miw.model.CancelacionData;
import com.miw.model.Viaje;
import com.miw.persistence.CancelarViajeDataService;

public class CancelarViajeDAO implements CancelarViajeDataService{

	public void cancelarViaje(CancelacionData cancelacion) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		int rs=0;
 
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexi�n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement("DELETE FROM RESERVAS WHERE idreserva ="+ cancelacion.getIdentificadorReserva()+" AND emailviajero = '"+cancelacion.getEmail()+"';");
			rs = ps.executeUpdate();

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
		return;
		
	}

}
