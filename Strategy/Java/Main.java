/*
 * 场景描述：
 * 
 * 你给保时捷进行装饰后，终于可与上市卖了。
 * 现在车的价格可能根据市场需求变动随时调整，对于不同销售商订购辆数进行优惠。
 * 5辆以下不打折，5 - 10辆9.5折，10 - 20辆9折，20辆以上8.5折。
 * 请你写个程序计算销售商预定x辆需要多少钱，价格y。
 *
 */


//策略接口,计算购车总金额
interface Strategy {
	int calPrice(int price, int num);
}

//购买5辆及以下不打折
class Nodiscount implements Strategy {

	@Override
	public int calPrice(int price, int num) {
		return price * num;
	}

}

//购买6-10辆打9.5折
class Disount1 implements Strategy {

	@Override
	public int calPrice(int price, int num) {
		return (int)(price * num * 0.95);
	}

}

//补全,购买11-20辆打9折算法实现
class Discount2 implements Strategy {
	
	@Override
	public int calPrice(int price, int num) {
		return (int)(price * num * 0.9);
	}
}

//补全,购买20辆以上打8.5折算法实现
class Discount3 implements Strategy {
	
	@Override
	public int calPrice(int price, int num) {
		return (int)(price * num * 0.85);
	}
}

//上下文,根据不同策略来计算购车总金额
class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public int calPrice(int price, int num) {
		//补全计算价格算法
		return this.strategy.calPrice(price, num);
	}
}

public class Main {

	//每辆车单价10000
	public static void main(String[] args) {
		Strategy strategy;

		//计算购买3辆总金额
		strategy = new Nodiscount();
		Context context = new Context(strategy);
		System.out.println("购买3辆总金额: " + context.calPrice(10000,3));

		//补全 计算12辆总金额
		strategy = new Discount2();
		context = new Context(strategy);
		System.out.println("购买12辆总金额: " + context.calPrice(10000,12));
	}

}
