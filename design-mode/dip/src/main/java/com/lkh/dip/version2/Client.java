package com.lkh.dip.version2;

/**
 * 这是一个实验室类, 目的是将开心讲故事的逻辑串起来 
 */
public class Client {
	/**所有程序的唯一入口就是  startc main()*/
	public static void main(String[] args) {
		//开心入场
		MrHappy mrHappy = new MrHappy();
		
		//书入场
		IReader book1 = new Book();
		//开心得到书
		mrHappy.setReader(book1);
		//开心开始讲故事
		mrHappy.telling();
		
		//新闻入场
		IReader book2 = new News();
		//开心得到新闻
		mrHappy.setReader(book2);
		//开心开始讲新闻
		mrHappy.telling();
	}
}
