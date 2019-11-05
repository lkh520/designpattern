package singleton;

/**
 * 单例使用类
 * 
 * @author Administrator
 *
 */
public class SingleClient {

	public static void main(String[] args) {
		// 获得第一个对象实例
		LazySingleton obj1 = LazySingleton.getInstance();
		// 获得第二个对象实例
		LazySingleton obj2 = LazySingleton.getInstance();
		// 判断两次的对象是否为同一个
		if (obj1 == obj2) {
			System.out.println("她们是同一人！");
		} else {
			System.out.println("她们不是同一人！");
		}
	}

}
