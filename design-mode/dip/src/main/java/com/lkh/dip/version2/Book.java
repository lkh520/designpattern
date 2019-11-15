package com.lkh.dip.version2;

public class Book implements IReader{
	public Book() {
	}
	/**书名*/
	public String getName() {
		return "《勇士和龙》";
	}
	/**内容*/
	@Override
	public String getContent() {
		return "很久很久以前， 有一群公主住在古堡中……";
	}
}
