package com.lkh.dip.version2;

public class News implements IReader{

	
	@Override
	public String getName() {
		return "《中国新闻》";
	}

	@Override
	public String getContent() {
		return "中国是世界四大文明古国之一，有着悠久的历史，距今约5000年前，以中原地区为中心开始出现聚落组织进而形成国家，后历经多次民族交融和朝代更迭，直至形成多民族国家的大一统局面";
	}
}
