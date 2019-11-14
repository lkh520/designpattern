/**
 * @author lkh
 */
package prototype;

/**
 * 抽象原型类
 * 是声明克隆方法的接口，是所有具体原型类的公共父类，它可以是接口，抽象类甚至是一个具体的实现类。
 * @author lkh
 *
 */
public interface IPrototype extends Cloneable {
	//use方法是用于“使用”的方法，具体怎么“使用”，则被交给子类去实现。
    public abstract void use(String s);
    //creatClone方法是用于复制实例的方法
    public abstract IPrototype creatClone();
}
