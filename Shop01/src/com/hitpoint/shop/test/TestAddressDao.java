package com.hitpoint.shop.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.hitpoint.shop.dao.DaoFactory;
import com.hitpoint.shop.dao.IAddressDao;
import com.hitpoint.shop.model.Address;

public class TestAddressDao {
	private IAddressDao addressDao = DaoFactory.getAddressDao();
	@Test
	public void testAdd() {
		Address address = new Address();
		String str = "上海徐汇区";
		System.out.println(str);
		//address.setName(str);
		address.setPhone("12345678");
		address.setPostcode("123123");
		address.setName(str);
		addressDao.add(address, 1);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testlist() {
		List<Address> list = addressDao.list(1);
		for(Address a:list){
			System.out.println(a.getName());
			System.out.println(a.getUser().getNickname());
		}
	}

}
