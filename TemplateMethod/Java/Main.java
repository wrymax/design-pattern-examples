// 检测汽车质量的抽象模板类
abstract class AbstractQualityChecker {
	/* 一组抽象方法，让子类重写 */
	// 检测启动
	abstract void startup();
	// 检车加速
	abstract void speedup();
	// 检测制动
	abstract void brake();
	// 检测停止
	abstract void stop();

	// 控制检测流程，声明为final，防止子类重写
	public final void checkQuality() {
		startup();
		speedup();
		brake();
		stop();
		System.out.println("--- 检测完成！---\n");
	}
}

// 实现1. 保时捷911的质量检测
class QualityChecker911 extends AbstractQualityChecker {
	void startup() {
		System.out.println("检测保时捷911的启动性能...");
	}
	void speedup() {
		System.out.println("检测保时捷911的加速性能...");
	}
	void brake() {
		System.out.println("检测保时捷911的制动性能...");
	}
	void stop() {
		System.out.println("检测保时捷911的停止性能...");
	}
}

// 实现2. 保时捷Cayma的质量检测
class QualityCheckerCayma extends AbstractQualityChecker {
	void startup() {
		System.out.println("检测保时捷Cayma的启动性能...");
	}
	void speedup() {
		System.out.println("检测保时捷Cayma的加速性能...");
	}
	void brake() {
		System.out.println("检测保时捷Cayma的制动性能...");
	}
	void stop() {
		System.out.println("检测保时捷Cayma的停止性能...");
	}
}

public class Main {
	public static void main(String[] args) {
		// 911 checker
		QualityChecker911 checker911 = new QualityChecker911();
		// Cayma checker
		QualityCheckerCayma checkerCayma = new QualityCheckerCayma();

		checker911.checkQuality();
		checkerCayma.checkQuality();
	}
}
