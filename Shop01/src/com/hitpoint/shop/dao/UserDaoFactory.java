package com.hitpoint.shop.dao;

public class UserDaoFactory {

	public static IUserDao getUserDao() {
		return new UserDaoImpl();
	}

}
