package singleton;

import java.io.Serializable;

/**
 * 懒汉式单例</br>
 * 该模式特点是：类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例。 </br>
 * 该模式优点是：节省内存资源、保证数据内容的一致性，对某些类只创建一个实例。 </br>
 * 该模式缺点是：保证线程安全，但是每次访问时都要同步，会影响性能，且消耗更多的资源。 </br>
 * 两步完成 1. 私有构造器，避免类在外部被实例化; 2. 保证 instance 在所有线程中同步。 </br>
 * 
 * @author lkh
 */
public class LazySingleton implements Serializable{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -5610874421700628955L;
	// 初始化对象, volatile 关键字可以排除DCL模式中的并发BUG, 不会再拿到两个不同实例
	private static volatile LazySingleton instance = null;

	/**
	 * 1. 私有构造器，避免类在外部被实例化
	 * 
	 * @author lkh
	 */
	private LazySingleton(String type) {
		// 业务代码
		System.out.println("你获得了一个 "+type+" 懒汉式单例 对象 ");
	}

	/**
	 * 2. 保证 instance 在所有线程中同步, 对象只会初始化一次</br>
	 * 懒汉式单例--串型同步锁</br>
	 * null == instance 存在竞态条件, 竞态条件会导致instance引用被多次赋值，使用户得到两个不同的单例</br>
	 * 为了解决这个问题，可以使用synchronized关键字将getInstance方法改为同步方法</br>
	 * 但这样串行化的单例是很低效的, </br>
	 * 请看 getInstancePlus() 方法,使用了DCL模式,提高性能
	 * 
	 * @return
	 */
	public static synchronized LazySingleton getInstance() {
		// 在当前线程中没有实例就实例出来
		if (null == instance) {
			instance = new LazySingleton("串型同步锁");
		}
		return instance;
	}

	/**
	 * 2. 保证 instance 在所有线程中同步,对象只会初始化一次</br>
	 *  * 懒汉式单例--DCL机制（Double Check Lock，双重检查锁）</br>
	 * 使得大部分请求都不会进入阻塞代码块, </br>
	 * 
	 * @return
	 */
	public static LazySingleton getInstancePlus() {
		// 在当前线程中没有实例就实例出来
		if (instance == null) { // 当instance不为null时，仍可能指向一个“被部分初始化的对象”
			synchronized (LazySingleton.class) {
				if (instance == null) {
					instance = new LazySingleton("DCL机制");
				}
			}
		}
		return instance;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}