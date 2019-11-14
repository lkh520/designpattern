package singleton;
/**
 * Java 要求必须先定义 enum 实例(对象),由实例调用所被定义的任务方法,用这种特性,正好适合单例模式
 * @author lkh
 *
 */
public enum EnumSingleton {
	/**enum 实例 */
	INSTANCE;
	
	/**实例的行为 */
    public void whateverMethod() {
    	System.out.println("对像的方法");
    } 
    @Override
    public String toString() {
    	return super.toString();
    }
}
