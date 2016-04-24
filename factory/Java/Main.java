interface CarFactory {
	void productCar();
}

class BenzFactory implements CarFactory {
	@Override
		public void productCar() {
			System.out.println("Produce a Benz!");
		}
}

class TractorFactory implements CarFactory {
	@Override
		public void productCar() {
			System.out.println("Produce a Tractor!");
		}
}

public class Main {
	public static void main(String[] args) {
		// Benz
		CarFactory benz = new BenzFactory();
		benz.productCar();
		
		// Tractor
		CarFactory tractor = new TractorFactory();
		tractor.productCar();
	}
}
