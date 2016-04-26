/* 
 * 场景描述：
 *
 * 由于你长时间工作，经常需要喝咖啡来提神。
 * 咖啡本身很苦，可加牛奶，也可加糖，或者都加。
 * 试试装饰器来装饰你的咖啡。
 *
 */

// TODO..
interface ICoffee {
	void showCoffee();

	float showPrice();
}

//原始咖啡
class Coffee implements ICoffee {
	private String name;
	private float price;

	public Coffee(String name, float price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public void showCoffee() {
		System.out.println(name + " coffee");
	}

	@Override
	public float showPrice() {
		return price;
	}
}

//抽象装饰器
abstract class Decorator implements ICoffee {
	private ICoffee coffee;

	public void setCoffee(ICoffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public void showCoffee() {
		coffee.showCoffee();
	}

	@Override
	public float showPrice() {
		return coffee.showPrice();
	}
}

//加糖咖啡
class Sugar extends Decorator {
	@Override
	public void showCoffee() {
		System.out.println("加糖");
		super.showCoffee();
	}

	@Override
	public float showPrice() {
		return super.showPrice() + 5;
	}
}

//补全,加牛奶的咖啡
class SugarMilk extends Decorator {
	@Override
	public void showCoffee() {
		System.out.println("加牛奶");
		super.showCoffee();
	}

	@Override
	public float showPrice() {
		return super.showPrice() + 10;
	}
}

public class Main {

	public static void main(String[] args) {
		Coffee coffee = new Coffee("拿铁", 20);
		//加糖
		Decorator sugar = new Sugar();
		sugar.setCoffee(coffee);
		System.out.println(sugar.showPrice());
		
		//补全,加糖,加牛奶的咖啡
		Decorator sugerMilk = new SugarMilk();
		sugerMilk.setCoffee(coffee);
		System.out.println(sugerMilk.showPrice());
	}

}

