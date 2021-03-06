package com.hitpoint.shop.model;

public class SystemContext {
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
	private static ThreadLocal<String> order = new ThreadLocal<String>();
	private static ThreadLocal<String> sort = new ThreadLocal<String>();
	
	public static String getOrder() {
		return order.get();
	}
	public static void setOrder(String _order) {
		order.set(_order);
	}
	public static void removeOrder(){
		order.remove();
	}
	public static String getSort() {
		return sort.get();
	}
	public static void setSort(String _sort) {
		sort.set(_sort);
	}
	public static void removeSort(){
		sort.remove();
	}
	
	public static int getPageOffSet(){
		return pageOffset.get();
	}
	public static void setPageOffset(int _pageOffset){
		pageOffset.set(_pageOffset);
	}
	public static void removePageOffset(){
		pageOffset.remove();
	}
	
	public static int getPageSize(){
		return pageSize.get();
	}
	public static void setPageSize(int _pagesize){
		pageSize.set(_pagesize);
	}
	public static void removePageSize(){
		pageSize.remove();
	}
	public static int getPageIndex(){
		return pageIndex.get();
	}
	public static void setPageIndex(int _pageIndex){
		pageIndex.set(_pageIndex);
	}
	public void removePageIndex(){
		pageIndex.remove();
	}
}
