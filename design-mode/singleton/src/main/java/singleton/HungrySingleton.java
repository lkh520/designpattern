package singleton;

/**
 * 饿汉式单例</br>
 * 该模式特点是：类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了。 </br>
 * 两步完成 1. 私有构造器，避免类在外部被实例化; 2. 申名对象的时候就初始化,不用等到加载时。 </br>
 * 注意：饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。<br>
 * 
 * @author lkh
 */
public class HungrySingleton {
	private static HungrySingleton instance = new HungrySingleton();

	private HungrySingleton() {
		System.out.println("由饿汉式单例创建一个 对象");
	}

	public static HungrySingleton getInstance() {
		return instance;
	}
}
