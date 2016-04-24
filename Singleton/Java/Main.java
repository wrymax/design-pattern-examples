class NetworkManager {
	// 设置一个私有的实例，静态变量
	private static NetworkManager networkManager;

	private String host;

	// 把构造方法设为private，不允许被外界调用
	private NetworkManager(String host) {
		host = host;
	}

	// 暴露一个公有方法，返回唯一的私有实例
	public static NetworkManager getInstance() {
		if (networkManager == null) {
			// 为了线程安全，添加线程锁
			synchronized (NetworkManager.class) {
				if (networkManager == null) {
					networkManager = new NetworkManager("http://localhost:3000");
				}
			}
		}
		return networkManager;
	}
}

public class Main {
	public static void main(String[] args) {
		NetworkManager m1 = NetworkManager.getInstance();
		NetworkManager m2 = NetworkManager.getInstance();

		if (m1 == m2) {
			System.out.println("m1 equals m2, there is only on NetworkManager!");
		} else {
			System.out.println("m1 and m2 are two NetworkManagers.");
		}
	}
}
