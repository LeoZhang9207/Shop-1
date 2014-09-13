package com.hitpoint.shop.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hitpoint.shop.dao.IUserDao;
import com.hitpoint.shop.dao.UserDaoFactory;
import com.hitpoint.shop.model.Address;
import com.hitpoint.shop.model.User;

public class TestUserDao {
	private IUserDao userdao = UserDaoFactory.getUserDao();
	@Test
	public void testLoad() {
		User u = userdao.load(1);
		System.out.println(u.getNickname());
		for(Address a:u.getAddress()){
			System.out.println(a.getName());
		}
	}
}
