package client;

import java.util.HashMap;

import prototype.IPrototype;
/**
 * 
 * @author Administrator
 *
 */
public class Client {
	// 保存实例的“名字”和“实例”之间的对应关系
	private HashMap<String, IPrototype> showcase = new HashMap<String, IPrototype>();

	// register方法将接收到的一组“名字”和“Product接口”注册到showcase中。
	public void register(String name, IPrototype product) {
		showcase.put(name, product);
	}

	public IPrototype create(String productname) {
		IPrototype p = showcase.get(productname);
		return p.creatClone();
	}
}
