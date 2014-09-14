package com.hitpoint.shop.test;

import org.junit.Before;
import org.junit.Test;

import com.hitpoint.shop.dao.DaoFactory;
import com.hitpoint.shop.dao.IUserDao;
import com.hitpoint.shop.model.Pager;
import com.hitpoint.shop.model.SystemContext;
import com.hitpoint.shop.model.User;

public class TestUserDaoImpl {
	private IUserDao userdao;
	@Before
	public void init(){
		userdao = DaoFactory.getUserDao();
	}
	@Test
	public void testAdd() {
		User u = new User();
		u.setNickname("Leo");
		u.setUsername("mushroom");
		u.setPassword("123456");
		u.setType(1);
		userdao.add(u);
	}
	@Test
	public void testUpdate() {
		User u = userdao.loadByUsername("mushroom");
		u.setPassword("111111");
		userdao.update(u);
	}
	
	@Test
	public void testLoad() {
		User u  = userdao.load(3);
		System.out.println(u.getNickname());
	}

	@Test
	public void testLogin() {
		//User u = userdao.login("mushroom", "123456");
		//User u = userdao.login("mush", "123456");
		User u = userdao.login("mushroom", "123455");
		System.out.println(u.getNickname());
	}


	@Test
	public void testLoadByUsername() {
		User u = userdao.loadByUsername("mushroom");
		System.out.println(u.getNickname());
	}

	@Test
	public void testDelete() {
		userdao.delete(3);
	}
	
	@Test
	public void testFind(){
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(15);
		SystemContext.setOrder("desc");
		SystemContext.setSort("id");
		Pager<User> ps = userdao.find("张");
		//Pager<User> ps = userdao.find(null);
		System.out.println(ps.getTotalRecord());
		for(User u:ps.getDatas()){
			System.out.println(u.getId()+u.getUsername());
		}
	}
	
}
