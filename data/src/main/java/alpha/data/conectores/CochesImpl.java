package alpha.data.conectores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



import alpha.data.constans.ConstansQuery;
import alpha.data.models.Coche;
import alpha.data.singleton.ConnectorSingleton;

public class CochesImpl implements CochesDAO {
	@Override
	public Coche getCar(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getCarMap(String id) {
		Map<String,String>mapas= new LinkedHashMap<String,String>();
		
		List<String>fields= new ArrayList<String>();
		fields.add(id);		
		System.out.println("id de car"+id);
		try {
			ResultSet rs = ConnectorSingleton.getResulsetBDWithParams(ConstansQuery.GET_CAR,fields).orElseThrow(RuntimeException::new);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
			for(int i = 1; i<=rsmd.getColumnCount();i++) {
				System.out.println("los rsult metaData"+rsmd.getColumnName(i));
				
				mapas.put(rsmd.getColumnName(i),rs.getString(rsmd.getColumnName(i)));
				
			}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mapas;
	}

	@Override
	public List<Coche> getAllCars() {
		List<Coche> listaCoches = new ArrayList<>();
		ResultSet rs = ConnectorSingleton.getResulsetBD(ConstansQuery.GET_ALL_CARS).get();// si no esta valor hace //
																							// exception
		try {
			
			while (rs.next()) {
				listaCoches.add(new Coche(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"),
						rs.getDouble("precio")));
			}
			
		} catch (SQLException e) {
			System.err.println("Error en getAllCars de" + this.getClass().toString());
			e.printStackTrace();
		}
		
		ConnectorSingleton.closeAll(rs);

		return listaCoches;
	}

	@Override
	public boolean existCar(int id) {// devuelve true o false del metodo de ConectorSingleton
		return ConnectorSingleton.existResulset(ConstansQuery.EXISTS_CAR, id).get();
	}


	


}
