package com.hitpoint.shop.dao;

import java.util.List;

import com.hitpoint.shop.model.Address;

public interface IAddressDao {
	public void add(Address address,int userId);
	public void update(Address address);
	public void delete(int id);
	public Address load(int id);
	public List<Address> list(int userId);
}
