package alpha.data.conectores;

import java.util.List;

import alpha.data.models.Coche;

public interface CochesDAO {

	public Coche getCar(int id) ;
	
	public boolean existCar(int id) ;
	
	public List <Coche> getAllCars();
}
