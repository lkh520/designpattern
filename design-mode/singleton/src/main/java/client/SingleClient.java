package client;

import singleton.EnumSingleton;
import singleton.HungrySingleton;
import singleton.LazySingleton;
import singleton.StaticSingleton;

/**
 * 单例使用类 【例】用懒汉式单例模式模拟对象。 分析：获得一个对象后,就不能有新的对象 以此证明,每一个实例对象都是相同的,只会被初始化一次
 * 
 * @author lkh
 *
 */
public class SingleClient {
	public static void main(String[] args) {
		// 共五段,对应所对应的类,类中都有说明

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				LazySingleton grilFriend = LazySingleton.getInstancePlus();
			}).start();
		}
		
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				LazySingleton grilFriend = LazySingleton.getInstance();
			}).start();
		}

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				HungrySingleton ss = HungrySingleton.getInstance();
			}).start();
		}

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				StaticSingleton ss = StaticSingleton.getInstance();
			}).start();
		}

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				EnumSingleton.INSTANCE.whateverMethod();
			}).start();
		}
	}
}
