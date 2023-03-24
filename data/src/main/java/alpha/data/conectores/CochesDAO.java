package alpha.data.conectores;

import java.util.List;
import java.util.Map;

import alpha.data.models.Coche;

public interface CochesDAO {

	public Coche getCar(String id) ;
	
	public Map<String,String> getCarMap(String id) ;
	
	public boolean existCar(int id) ;
	
	public List <Coche> getAllCars();
	
	
}

