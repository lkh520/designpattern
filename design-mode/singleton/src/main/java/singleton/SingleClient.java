package singleton;

/**
 * 单例使用类 【例】用懒汉式单例模式模拟女朋友对象。 分析：获得一个女朋友后,就不能有新的女朋友,再次请求获得女朋友后,会判断是否为同一个人
 * 以此证明,每一个实例对象都是相同的,只会被初始化一次
 * 
 * @author Administrator
 *
 */
public class SingleClient {
	public static void main(String[] args) {
		// 在不同线程中去得到对象,对象应该是同一个, 此处用到5个线程
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				LazySingleton grilFriend = LazySingleton.getInstancePlus();
			}).start();
		}
	}
}
