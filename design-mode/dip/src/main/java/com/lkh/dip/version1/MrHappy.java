package com.lkh.dip.version1;

public class MrHappy {
	private Book book;
	
	public Book getBook() {
		return book;
	}
	/**拿书*/
	public void setBook(Book book) {
		System.out.println("开心开始读:"+book.getName());
		this.book = book;
	}
	/**讲故事*/
	public void telling() {
		//System.out.println("开心开始讲故事");
        System.out.println(book.getContent());
	}
}
