package singleton;

/**
 * 登记式/静态内部类单例</br>
 * 该模式特点是：这种方式只适用于静态域的情况, 保证线程安全。 </br>
 * 该模式优点是：节省内存资源、保证数据内容的一致性，对某些类只创建一个实例。 </br>
 * 该模式缺点是：只适用于静态域, 针对性强。 </br>
 * 三步完成 1.定义内部静态类, 使用饿汉式实例化。2. 私有构造器，避免类在外部被实例化; 3. 定义getInstance,只有被调时,才会实例内部类</br>
 * 
 * @author lkh
 */
public class StaticSingleton {
	/**
	 * 1.定义内部静态类, 使用饿汉式实例化。
	 * @author lkh
	 */
	private static class SingletonHolder {
		private static final StaticSingleton INSTANCE = new StaticSingleton();
	}
	/**
	 * 2. 私有构造器，避免类在外部被实例化; 
	 */
	private StaticSingleton() {
		// 业务代码
		System.out.println("你获得了一个 对象 ");
	}
	/**
	 * 3. 定义getInstance,只有被调时,才会实例内部类
	 * @return
	 */
	public static final StaticSingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
