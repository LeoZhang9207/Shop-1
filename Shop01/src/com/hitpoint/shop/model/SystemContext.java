package com.hitpoint.shop.model;

public class SystemContext {
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageOfffset = new ThreadLocal<Integer>();
	public static ThreadLocal<Integer> getPageSize() {
		return pageSize;
	}
	public static void setPageSize(ThreadLocal<Integer> pageSize) {
		SystemContext.pageSize = pageSize;
	}
	public static ThreadLocal<Integer> getPageIndex() {
		return pageIndex;
	}
	public static void setPageIndex(ThreadLocal<Integer> pageIndex) {
		SystemContext.pageIndex = pageIndex;
	}
	public static ThreadLocal<Integer> getPageOfffset() {
		return pageOfffset;
	}
	public static void setPageOfffset(ThreadLocal<Integer> pageOfffset) {
		SystemContext.pageOfffset = pageOfffset;
	}
	
}
