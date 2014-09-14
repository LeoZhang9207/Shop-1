package com.hitpoint.shop.dao;

import com.hitpoint.shop.model.Pager;
import com.hitpoint.shop.model.User;

public interface IUserDao {
	public void add(User u);
	public void update(User u);
	public User load(int id);
	public void delete(int id);
	public User loadByUsername(String username);
	public Pager<User> find(String name);
	public User login(String username,String password);
}
