package singleton;

/**
  *  懒汉式单例</br>
  *  该模式特点是：类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例。	</br>
  *  该模式优点是：节省内存资源、保证数据内容的一致性，对某些类只创建一个实例。				</br>
  *  该模式缺点是：保证线程安全，但是每次访问时都要同步，会影响性能，且消耗更多的资源。			</br>
  *  两步完成 1. 私有构造器，避免类在外部被实例化; 2. 保证 instance 在所有线程中同步。				</br>
  *  注意：如果编写的是多线程程序，则不要删除上例代码中的关键字 volatile 和 synchronized，否则将存在线程非安全的问题。<br>
 * @author lkh
 */
public class LazySingleton {
	// 初始化对象
	private static volatile LazySingleton instance = null;
	
	
	/**
	 * 1. 私有构造器，避免类在外部被实例化
	 * 
	 * @author lkh
	 */
	private LazySingleton() {
		System.out.println("获得一个女朋友！");
	}

	/**
	 * 2. 保证 instance 在所有线程中同步
	 * 
	 * @return
	 */
	public static synchronized LazySingleton getInstance() {
		// 在当前线程中没有实例就实例出来
		if (instance == null) {
			instance = new LazySingleton();
		} 
		//此处只是用来测试，真实中，这里无需ELSE
		else {
	           System.out.println("已经有一个女朋友，不能脚踏多船，会翻！");
	    }
		return instance;
	}
	
	
}
