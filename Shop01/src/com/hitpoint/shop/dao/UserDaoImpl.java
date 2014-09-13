package com.hitpoint.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hitpoint.shop.model.Address;
import com.hitpoint.shop.model.User;
import com.hitpoint.shop.util.DBUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public User load(int id) {
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		List<Address> addresses= new ArrayList<Address>();
		Address address = null;
		User u = null;
		try {
			conn = DBUtil.getConnection();
//select t1.*,t2.* from t_user t1 left join t_address t2 on (t1.id=t2.user_id) where t1.id = ?
			String sql = "select * from t_user where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs =stmt.executeQuery();
			while(rs.next()){
				u = new User();
				u.setId(rs.getInt("id"));
				u.setNickname(rs.getString("nickname"));
				u.setPassword(rs.getString("password"));
				u.setType(rs.getInt("type"));
				u.setUsername(rs.getString("username"));
			}
			sql = "select * from t_address where user_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				address  = new Address();
				address.setId(rs.getInt("id"));
				address.setName(rs.getString("name"));
				address.setPhone(rs.getString("phone"));
				address.setPostcode(rs.getString("postcode"));
				addresses.add(address);
			}
			u.setAddress(addresses);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(rs, stmt, conn);
		}
		
		return u;
	}

}
