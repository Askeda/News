package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.User;
import com.util.DatabaseUtil;

public class UserDaoImpl implements UserDao {
	private Connection conn=null;
	private ResultSet rs=null;
	DatabaseUtil du=new DatabaseUtil();
	private PreparedStatement pst=null;
	@Override
	public boolean login(User user) {
		boolean flag=false;
		conn=du.getConnection();
		String sql="select *from user where uname=? and upwd=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPwd());
			pst.executeQuery();
			if(pst.executeQuery().next()){
				flag=true;
				
			}else{
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			du.closeAll(rs, pst, conn);
		}
		return flag;
	}
	@Override
	public boolean reg(User user) {
		boolean flag=false;
		conn=du.getConnection();
		String sql="insert into user(uname,upwd)value(?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPwd());
			int i=pst.executeUpdate();
			if(i>0){
				flag=true;
				
			}else{
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			du.closeAll(rs, pst, conn);
		}		
		return flag;
	}
	@Override
	public boolean useryan(User user) {
		boolean flag=false;
		conn=du.getConnection();
		String sql="select * from user where uname=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.executeQuery();
			if(pst.executeQuery().next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			du.closeAll(rs, pst, conn);
		}
		return flag;
	}
	@Override
	public boolean Um(User user) {
		boolean flag=false;
		conn=du.getConnection();
		String sql="update user set uname=?,upwd=? where uname=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPwd());
			pst.setString(3, user.getName());
			if(pst.executeUpdate()>0){
				flag=true;
			}else{
				System.out.println("ok");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			du.closeAll(rs, pst, conn);
		}
		return flag;
	}

}
