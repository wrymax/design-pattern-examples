/*
 * 场景描述：
 *
 * 之前你的保时捷工厂生产流水线都不是自动化的，现在升级成自动化了。
 * 老板叫你写个控制程序，来控制保时捷的生产流程，要求：
 * 操作超级简单，操作员不需要去记住生产流程，只需要按开始生产按钮就可以了。
 *
 */
class Frame {
	public void create() {
		System.out.println("组装骨架");
	}
}

class Engine {
	public void create() {
		System.out.println("组装引擎");
	}
}

class Wheel {
	public void create() {
		System.out.println("组装轮子");
	}
}

class CarController {
	private Frame frame;
	private Engine engine;
	private Wheel wheel;

	public CarController() {
		frame = new Frame();
		engine = new Engine();
		wheel = new Wheel();
	}

	public void build() {
		frame.create();
		engine.create();
		wheel.create();

		System.out.println("--- 组装完成！---");
	}
}

public class Main {
	public static void main(String[] args) {
		CarController controller = new CarController();
		controller.build();
	}
}
