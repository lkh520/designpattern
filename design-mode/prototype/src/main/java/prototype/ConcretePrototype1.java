/**
 * 
 */
package prototype;

/**
 * 实现了抽象原型类中声明的克隆方法，在克隆方法中返回一个自己的克隆对象, creatClone()
 * @author Administrator
 *
 */
public class ConcretePrototype1 implements IPrototype {

	/** 私有的业务属性 */
	private char decochar;

	/**
	 * 构造方法
	 * @param decochar
	 */
	public ConcretePrototype1(char decochar) {
        this.decochar = decochar;
    }
	/**
	 * 业务代码, 按业务来写
	 */
	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		for (int i = 0; i < length + 4; i++) {
			System.out.print(decochar);
		}
		System.out.println("");
		System.out.println(decochar + " " + s + " " + decochar);
		for (int i = 0; i < length + 4; i++) {
			System.out.print(decochar);
		}
		System.out.println("");
	}

	/**
	 * 复制的实现 , 浅CLONE
	 */
	@Override
	public IPrototype creatClone() {
		IPrototype p = null;
		try {
			p = (IPrototype) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
}
