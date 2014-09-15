package com.hitpoint.shop.dao;

public class DaoFactory {

	public static IAddressDao getAddressDao() {
		
		return new AddressDaoImpl();
	}
	
	public static IUserDao getUserDao(){
		return new UserDaoImpl();
	}
}
