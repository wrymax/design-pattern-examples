// 汽车工厂
interface CarFactory {
	void productCar();
}

// 抽象工厂, 汽车工厂的工厂
interface Provider {
	CarFactory createCarFactory();
}

// 保时捷工厂
class PorscheFactory implements CarFactory {
	@Override
	public void productCar() {
		System.out.println("生产保时捷汽车");
	}
}

// 拖拉机工厂
class TractorFactory implements CarFactory {
	@Override
	public void productCar() {
		System.out.println("生产拖拉机");
	}
}

// 生产保时捷工厂的工厂
class SuperPorscheFactory implements Provider {
	@Override
	public CarFactory createCarFactory() {
		return new PorscheFactory();
	}
}

// 生产拖拉机工厂的工厂
class SuperTractorFactory implements Provider {
	@Override
	public CarFactory createCarFactory() {
		return new TractorFactory();
	}
}


public class Main {

	public static void main(String[] args) {
		//创建一个生产保时捷工厂的工厂
		Provider cf = new SuperPorscheFactory();
		//生产保时捷工厂
		CarFactory pf = cf.createCarFactory();
		//保时捷工厂生产保时捷汽车
		pf.productCar();
		//按上面示例,生产拖拉机
		Provider stf = new SuperTractorFactory();
		CarFactory tf = stf.createCarFactory();
		tf.productCar(); 
	}

}
