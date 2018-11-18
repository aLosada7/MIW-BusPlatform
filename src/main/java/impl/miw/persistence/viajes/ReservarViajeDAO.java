package impl.miw.persistence.viajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.miw.model.ReservaData;
import com.miw.persistence.ReservarViajeDataService;

public class ReservarViajeDAO implements ReservarViajeDataService{

	@SuppressWarnings("resource")
	public synchronized void reservarViaje(ReservaData reserva) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		int rs=0;
		ResultSet resultSet = null;
 
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexi�n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");
			
			ps = con.prepareStatement("select max(idreserva) as maximo from reservas");
			resultSet = ps.executeQuery();
			Integer id=0;
			while (resultSet.next()) {
				 id = resultSet.getInt("maximo");
			}
			
			System.out.println("Max id found: "+id);
			
			id=id+1;

			ps = con.prepareStatement("INSERT INTO RESERVAS (idreserva,IDENTIFICADORVIAJEIDA, IDENTIFICADORVIAJEVUELTA, EXTRABICICLETA, EXTRAMASCOTA, "+
			"EXTRASURF,EXTRASKIS,SEGURO,PRECIO,NOMBRE,APELLIDOS,TIPOIDENTIFICACION,IDENTIFICACION,EMAIL) VALUES ("+id+","+reserva.getIdentificadorViajeIda()+
			","+reserva.getIdentificadorViajeVuelta()+","+reserva.isExtraBicicleta()+","+reserva.isExtraMascota()+
			","+reserva.isExtraSurf()+","+reserva.isExtraSkis()+","+reserva.isSeguro()+",0,'"+reserva.getNombre()+"','"+reserva.getApellidos()+"','"+
			reserva.getTipoIdentificacion()+"','"+reserva.getIdentificacion()+"','"+reserva.getEmail()+"');");
			rs = ps.executeUpdate();
			
			ps = con.prepareStatement("select lugarllegada from viajes where idviaje="+reserva.getIdentificadorViajeIda()+";");
			resultSet = ps.executeQuery();
			String lugar = "";
			while (resultSet.next()) {
				 lugar = resultSet.getString("lugarllegada");
			}
			
			ps = con.prepareStatement("select popularidad from destinos where destino='"+lugar+"';");
			resultSet = ps.executeQuery();
			int popularidad=0;
			while (resultSet.next()) {
				 popularidad = resultSet.getInt("popularidad");
			}
			
			popularidad=popularidad+1;
			
			ps = con.prepareStatement("UPDATE destinos SET popularidad="+popularidad+"where destino='"+lugar+"';");
					rs = ps.executeUpdate();
					
			if(reserva.getIdentificadorViajeVuelta() != 0) {
				ps = con.prepareStatement("select lugarllegada from viajes where idviaje="+reserva.getIdentificadorViajeVuelta()+";");
				resultSet = ps.executeQuery();
				lugar = "";
				while (resultSet.next()) {
					 lugar = resultSet.getString("lugarllegada");
				}
				
				ps = con.prepareStatement("select popularidad from destinos where destino='"+lugar+"';");
				resultSet = ps.executeQuery();
				popularidad=0;
				while (resultSet.next()) {
					 popularidad = resultSet.getInt("popularidad");
				}
				
				popularidad=popularidad+1;
				
				ps = con.prepareStatement("UPDATE destinos SET popularidad="+popularidad+"where destino='"+lugar+"';");
						rs = ps.executeUpdate();
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
		return;
	}

}
