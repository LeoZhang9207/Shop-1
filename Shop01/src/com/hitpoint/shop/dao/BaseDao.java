package com.hitpoint.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hitpoint.shop.model.Pager;
import com.hitpoint.shop.model.SystemContext;
import com.hitpoint.shop.model.User;
import com.hitpoint.shop.util.MybatisUtil;
//将常用的方法抽象出来，让其他类来继承这个类
public class BaseDao<T> {
	public void add(T obj){
		SqlSession session = null;
		try{
			session = MybatisUtil.createSession();
			session.insert(obj.getClass().getName()+".add",obj);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.closeSession(session);
		}
	}
	
	public void update(T obj){
		SqlSession session = null;
		try{
			session = MybatisUtil.createSession();
			session.update(obj.getClass().getName()+".update",obj);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.closeSession(session);
		}
	}
	
	public void delete(Class<T> clz,int id){
		SqlSession session = null;
		try{
			session = MybatisUtil.createSession();
			session.delete(clz.getName()+".delete", id);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			MybatisUtil.closeSession(session);
		}
	}
	
	public T load(Class<T> clz,int id){
		SqlSession session = null;
		T t = null;
		try{
			session = MybatisUtil.createSession();
			t = (T)session.selectOne(clz.getName()+".load", id);
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			MybatisUtil.closeSession(session);
		}
		return t;
	}
	
	public List<T> list(Class<T> clz,Map<String,Object> params){
		List<T>	list = null;
		SqlSession session = null;
		try{
			session = MybatisUtil.createSession();
			list = session.selectList(clz.getName()+".list",params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MybatisUtil.closeSession(session);
		}
			
		
		return list;
	}
	
	public Pager<T> find(Class<T> clz,Map<String,Object> params){
		int pageSize = SystemContext.getPageSize();
		int pageOffset = SystemContext.getPageOffSet();
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		Pager<T> pages = new Pager<T>();
		SqlSession session = null;
		try{
			session = MybatisUtil.createSession();
			params.put("pageSize", pageSize);
			params.put("pageOffset",pageOffset);
			params.put("order", order);
			params.put("sort",sort);
			List<T> datas = session.selectList(clz.getName()+".find",params);
			pages.setDatas(datas);
			pages.setPageOffset(pageOffset);
			pages.setPageSize(pageSize);
			int totalRecord = session.selectOne(clz.getName()+".find_count",params);
			pages.setTotalRecord(totalRecord);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MybatisUtil.closeSession(session);
		}
		return pages;
		
	}
}
