/* 
 * 场景描述：
 *
 * 为了生产的安全，你决定为你的汽车工厂安装火警报警器，硬件完成了，现在你需要为这个报警器写个控制软件。用观察者模式试试吧。
 *
 */

import java.util.ArrayList;

//安装火灾报警器的工厂
interface Factory {
	//添加火灾报警器
	void attach(Alarm alarm);

	//移除火灾报警器
	void detach(Alarm alarm);

	//通知报警器
	void nofityObserver();

	//发生火灾
	void fire();
	//...
}

//安装了报警器的工厂
class PorscheFactory implements Factory {

	ArrayList<Alarm> alarms = new ArrayList<>();

	@Override
	public void attach(Alarm alarm) {
		alarms.add(alarm);
		System.out.printf("工厂添加报警器\n");
	}

	@Override
	public void detach(Alarm alarm) {
		alarms.remove(alarm);
	}

	@Override
	public void nofityObserver() {
		for (Alarm alarm : alarms) {
			alarm.rang();
		}
	}

	@Override
	public void fire() {
		//补全,工厂发生火灾,通知报警器
		nofityObserver();
	}
}

//报警器(抽象观察者)
interface Alarm {
	void rang();
}

//火灾报警器(具体观察者)
class FireAlarm implements Alarm {
	public String name;

	public FireAlarm(String _name) {
		this.name = _name;
	}

	//火灾报警器观察到工厂发行火灾鸣笛
	@Override
	public void rang() {
		System.out.println("--- 工厂发生火灾了，鸣笛！---");
	}
}

public class Main {

	public static void main(String[] args) {
		Factory f = new PorscheFactory();
		//火灾报警器
		Alarm alarm = new FireAlarm("火灾报警器");

		//补全,工厂安装火灾报警器
		f.attach(alarm);

		//补全,发生火灾了
		f.fire();
	}

}

