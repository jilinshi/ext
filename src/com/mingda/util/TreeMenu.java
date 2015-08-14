package com.mingda.util;

import java.util.List;

public class TreeMenu {
	private long menuid;
	private long pid;
	private long id;
	private String text;
	private String url;
	private boolean leaf;
	private List<TreeMenu> children;
	public long getMenuid() {
		return menuid;
	}
	public void setMenuid(long menuid) {
		this.menuid = menuid;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public List<TreeMenu> getChildren() {
		return children;
	}
	public void setChildren(List<TreeMenu> children) {
		this.children = children;
	}
	
	

}
