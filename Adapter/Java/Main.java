/*
 * 场景描述：
 *
 * 你发现你的手机没电了，你的手机是micro-usb接口，你也带了数据线。
 * 但是你发现你的保时捷充电接口是Type-c接口。
 * 现在你需要制造一个转换器。
 *
 */


// 使用USB充电的接口
interface MicroUSB {
	void chargeByMicroUSB();
}

// 使用Type-C充电的接口
interface TypeC {
	void chargeByTypeC();
}

// 电池类
class Battery {
	int power;

	public Battery(int power) {
		this.power = power;
	}

	// 电量上升
	public void powerUp(int upValue) {
		if (power < 10) {
			this.setPower(power + upValue);
		} else {
			System.out.println("电量已充满！\n");
		}
	}

	// 电量下降
	public void powerDown(int downValue) {
		if (power > 0) {
			setPower(power - downValue);
		} else {
			System.out.println("电量已用完！\n");
		}

	}

	public void showPower() {
		System.out.printf("当前电量：%d\n", this.power);
	}

	// getters and setters
	public int power() {
		return this.power;
	}

	public void setPower(int _power) {
		this.power = _power;
	}
}

// 实现MicroUsb接口的手机类
class CellPhone implements MicroUSB, Runnable {

	private Battery battery;

	// 持有一个线程，用于充电
	Thread chargeThread;

	public CellPhone(int _power) {
		battery = new Battery(_power);
		chargeThread = new Thread(this, "MicroUSB充电线程");
	}

	public void chargeByMicroUSB() {
		System.out.println("手机正在通过MicroUSB接口充电...");
		// 开始线程
		chargeThread.start();
	}

	public void run() {
		while(battery.power < 10) {
			battery.powerUp(1);
			System.out.println("--- 手机获得电量");
			battery.showPower();
		}
		System.out.println("----- 手机充电线程结束！-----");
	}
}

// 实现TypeC接口的汽车类
class Car implements TypeC, Runnable {

	private Battery battery;

	// 持有一个线程，用于充电
	Thread chargeThread;

	public Car(int _power) {
		battery = new Battery(_power);
		chargeThread = new Thread(this, "TyepC充电线程");
	}

	public void chargeByTypeC() {
		System.out.println("车载TypeC正在提供充电服务...");
		// 开始线程
		chargeThread.start();
	}

	public void run() {
		while(battery.power > 0) {
			battery.powerDown(1);
			System.out.println("*** 汽车释放电量");
			battery.showPower();
		}
		System.out.println("***** 汽车充电线程结束！*****");
	}
}

// 充电转换头：适配器类
//   1. 适配器持有 MicroUSB 对象( 相当于用MicroUSB对象连接到适配器 )
//   2. 适配器实现 TypeC 接口
//   3. 持有 TypeC 对象，用于充电的另一端
class MicroUSBToTypeC implements TypeC {
	// 持有MicroUSB充电接口和
	MicroUSB microUSB;
	TypeC typeC;

	// Constructor Method
	public MicroUSBToTypeC(MicroUSB microUSB, TypeC typeC) {
		this.microUSB = microUSB;
		this.typeC = typeC;
	}

	// 实现一个TypeC的充电方法，在方法中调用MicroUSB的充电方法
	public void chargeByTypeC() {
		System.out.println("将MicroUSB转换为TypeC!");
		this.microUSB.chargeByMicroUSB();
		this.typeC.chargeByTypeC();
	}

}

public class Main {
	public static void main(String[] args) {
		// 1. 手机和汽车
		CellPhone phone = new CellPhone(0);
		Car car = new Car(10);
		// 2. 用手机连接适配器
		MicroUSBToTypeC adapter = new MicroUSBToTypeC(phone, car);
		// 3. 开始充电
		adapter.chargeByTypeC();
	}
}
