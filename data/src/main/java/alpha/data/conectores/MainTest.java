package alpha.data.conectores;



public class MainTest {

	public static void main(String[] args) {
		CochesDAO car = new CochesImpl();


		System.out.println(car.existCar(2));
		
		car.getAllCars().stream().forEach(System.out::println);
	}
}
