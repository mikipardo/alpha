package alpha.data.Gson;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;

import alpha.data.conectores.CochesImpl;
import alpha.data.models.Coche;


public class GsonMain {

	public static void main(String[] args) {

		Coche car = new Coche(0, null, null, 0);
		
		List <Coche> listCars = new CochesImpl().getAllCars();
		
		Gson gson = new Gson();
		
		String json = gson.toJson(listCars);
		
		listCars.forEach(System.out::println);
		
		System.out.println(listCars.isEmpty());
		
		System.out.println(json);
		
		String aste ="*";
		int diez =12;
		for (int i = 0; i < 10; i++) {
			for (int j = diez; j > 0; j--) {
				System.out.print(" ");
			}
			System.out.println(aste);
			aste=aste+"**";
			diez--;
		}
	}
}
