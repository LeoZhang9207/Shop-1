package com.hitpoint.shop.model;

public class ShopException extends RuntimeException {

	private static final long serialVersionUID = 7664136640807424587L;

	public ShopException(){
		super();
	}
	public ShopException(String message,Throwable cause){
		super(message,cause);
	}
	
	public ShopException(String message){
		super(message);
	}
	public ShopException(Throwable cause){
		super(cause);
	}
}
