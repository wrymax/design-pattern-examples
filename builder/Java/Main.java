// 一台车的基类，声明各种必要的属性和方法
class Car {
	// 骨架
	String frame;
	// 引擎
	String engines;
	// 轮子
	String wheel;
}

// 抽象的制造者
interface Builder {
	public void buildFrame();
	public void buildEngines();
	public void buildWheel();

	public Car buildCar();
}

// Builder实现1. 保时捷911制造者，需要实现911具体需要的建造方法
class Builder911 implements Builder {
	Car car = new Car();

	@Override
	public void buildFrame() {
		System.out.println("制造保时捷911骨架...");
	}

	@Override
	public void buildEngines() {
		System.out.println("制造保时捷911引擎...");
	}

	@Override
	public void buildWheel() {
		System.out.println("制造保时捷911车轮...");
	}

	@Override
	public Car buildCar() {
		System.out.println("组装完成保时捷911！");
		return car;
	}
}

// Builder实现2. 保时捷Cayma制造者
class BuilderCayma implements Builder {
	Car car = new Car();

	@Override
	public void buildFrame() {
		System.out.println("制造保时捷Cayma骨架...");
	}

	@Override
	public void buildEngines() {
		System.out.println("制造保时捷Cayma引擎...");
	}

	@Override
	public void buildWheel() {
		System.out.println("制造保时捷Cayma车轮...");
	}

	@Override
	public Car buildCar() {
		System.out.println("组装完成保时捷Cayma！");
		return car;
	}
}

// 生产Car的监督者
//   1. 负责『指挥』建造者Builder，监督生产流程按流程进行
//   2. 911和Cayma的生产流程一致，只是建造者不同，利用Builder的多态实现
//   3. 一个Director => 一个流程 => 控制一组Builder
class CarDirector {
	Builder builder;

	// 构造方法，把builder传入做参数
	public CarDirector(Builder builder) {
		this.builder = builder;
	}

	// 控制生产流程
	public void buildCar() {
		builder.buildFrame();
		builder.buildEngines();
		builder.buildWheel();
	}
}

public class Main {
	public static void main(String[] args) {
		// 创建911的建造者
		Builder911 builder911 = new Builder911();
		// 创建Cayma的建造者
		BuilderCayma builderCayma = new BuilderCayma();

		// 创建911生产流程的监督者
		CarDirector director911 = new CarDirector(builder911);
		// 按流程开始生产
		director911.buildCar();
		// 完工，建造者完成最终产品
		Car car911 = builder911.buildCar();

		// 创建Cayma生产流程的监督者
		CarDirector directorCayma = new CarDirector(builderCayma);
		// 按流程开始生产
		directorCayma.buildCar();
		// 完工，建造者完成最终产品
		Car carCayma = builderCayma.buildCar();
	}
}
