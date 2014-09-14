package com.hitpoint.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hitpoint.shop.model.Pager;
import com.hitpoint.shop.model.ShopException;
import com.hitpoint.shop.model.SystemContext;
import com.hitpoint.shop.model.User;
import com.hitpoint.shop.util.MybatisUtil;

public class UserDaoImpl extends BaseDao<User> implements IUserDao {

	@Override
	public User load(int id) {
		/*SqlSession session = null;
		User u = null;
		try{
			session = MybatisUtil.createSession();
			u = (User)session.selectOne(User.class.getName()+".load", id);
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			MybatisUtil.closeSession(session);
		}
		return u;*/
		return super.load(User.class, id);
	}
	
	@Override
	public User login(String username, String password) {
		User u = this.loadByUsername(username);
		if(u==null) throw new ShopException("用户名不存在");
		if(!password.equals(u.getPassword())) throw new ShopException("用户名密码不正确！");
		return u;
	}

	@Override
	public void add(User u) {
		User tu = this.loadByUsername(u.getUsername());
		if(tu!=null) throw new ShopException("要添加的用户已存在！");
		super.add(u);
		/*SqlSession session = null;
		try{
			session = MybatisUtil.createSession();
			session.insert(User.class.getName()+".add", u);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.closeSession(session);
		}*/
	}

	@Override
	public void update(User u) {
		/*SqlSession session = null;
		try{
			session = MybatisUtil.createSession();
			session.update(User.class.getName()+".update", u);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.closeSession(session);
		}*/
		super.update(u);
	}

	@Override
	public void delete(int id) {
		/*SqlSession session = null;
		try{
			session = MybatisUtil.createSession();
			session.delete(User.class.getName()+".delete", id);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.closeSession(session);
		}*/
		//TODO 需要先删除关联对象
		super.delete(User.class, id);
	}

	@Override
	public User loadByUsername(String username) {
		SqlSession session = null;
		User u = null;
		try{
			session = MybatisUtil.createSession();
			u = (User)session.selectOne(User.class.getName()+".load_by_username", username);
			
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			MybatisUtil.closeSession(session);
		}
		
		return u;
	}

	@Override
	public Pager<User> find(String name) {
		Map<String,Object> params = new HashMap<String,Object>();
		if(name!=null || name.equals("")) params.put("name", "%"+name+"%");
		return super.find(User.class, params);
	}
}
