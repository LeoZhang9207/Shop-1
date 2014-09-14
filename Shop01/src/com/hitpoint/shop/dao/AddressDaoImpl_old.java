package com.hitpoint.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hitpoint.shop.model.Address;
import com.hitpoint.shop.model.User;
import com.hitpoint.shop.util.DBUtil;

public class AddressDaoImpl_old implements IAddressDao {

	@Override
	public void add(Address address, int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "insert into t_address(name,phone,postcode,user_id) values (?,?,?,?)";
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, address.getName());
			ps.setString(2, address.getPhone());
			ps.setString(3, address.getPostcode());
			ps.setInt(4, userId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(rs, ps, con);
		}
	}

	@Override
	public void update(Address address) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public Address address() {
		return null;
	}

	@Override
	public List<Address> list(int userId) {
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		List<Address> addresses= new ArrayList<Address>();
		Address address = null;
		User u = null;
		try{
			String sql = "select t1.id as 'a_id',t1.name,t1.phone,t1.postcode,"
					+ "t2.id as 'user_id',t2.nickname,t2.password,t2.username,t2.type from t_address t1 left join t_user t2 on(t1.user_id=t2.id) where user_id = ?";
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			rs = stmt.executeQuery();
			while(rs.next()){
				address = new Address();
				address.setId(rs.getInt("a_id"));
				address.setName(rs.getString("name"));
				address.setPhone(rs.getString("phone"));
				address.setPostcode(rs.getString("postcode"));
				u = new User();
				u.setId(rs.getInt("user_id"));
				u.setNickname(rs.getString("nickname"));
				u.setPassword(rs.getString("password"));
				u.setUsername(rs.getString("username"));
				u.setType(rs.getInt("type"));
				address.setUser(u);
				addresses.add(address);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.release(rs, stmt, conn);
		}
		return addresses;
	}

}
