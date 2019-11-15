package com.lkh.dip.version2;

public class MrHappy {
	private IReader reader;
	/**拿书*/
	public void setReader(IReader reader) {
		System.out.println("开心开始读:"+reader.getName());
		this.reader = reader;
	}
	/**讲故事*/
	public void telling() {
		//System.out.println("开心开始讲故事");
        System.out.println(reader.getContent());
	}
}
