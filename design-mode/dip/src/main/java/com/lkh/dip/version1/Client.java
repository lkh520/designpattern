package com.lkh.dip.version1;

/**
 * 这是一个实验室类, 目的是将开心讲故事的逻辑串起来 
 */
public class Client {
	/**所有程序的唯一入口就是  startc main()*/
	public static void main(String[] args) {
		//开心入场
		MrHappy mrHappy = new MrHappy();
		//书入场
		Book book = new Book();
		//开心得到书
		mrHappy.setBook(book);
		//开心开始讲故事
		mrHappy.telling();
	}
}
