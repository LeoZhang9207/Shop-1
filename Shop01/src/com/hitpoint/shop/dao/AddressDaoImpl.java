package com.hitpoint.shop.dao;

import java.util.List;

import com.hitpoint.shop.model.Address;
import com.hitpoint.shop.model.ShopException;
import com.hitpoint.shop.model.User;

public class AddressDaoImpl extends BaseDao<Address> implements IAddressDao {
	private IUserDao userDao;
	public AddressDaoImpl(){
		userDao = DaoFactory.getUserDao();
	}
	
	@Override
	public void add(Address address, int userId) {
		User u = userDao.load(userId);
		if(u==null) throw new ShopException("添加地址的用户不存在");
		address.setUser(u);
		super.add(address);
	}

	@Override
	public void update(Address address) {
		super.update(address);
	}

	@Override
	public void delete(int id) {
		super.delete(Address.class, id);
	}

	@Override
	public Address load(int id) {
		return super.load(Address.class, id);
	}

	@Override
	public List<Address> list(int userId) {
		return null;
	}

}
