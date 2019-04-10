package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Topic;
import com.util.DatabaseUtil;

public class TopicDaoImpl implements TopicDao {
private Connection conn=null;
private ResultSet rs=null;
private PreparedStatement pst=null;
DatabaseUtil du=new DatabaseUtil();
	@Override
	public List<Topic> getall() {
		List<Topic>list=new ArrayList<Topic>();
		Topic to=null;
		conn=du.getConnection();
		String sql="select * from topic";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				to=new Topic();
				to.setTid(rs.getInt("tid"));
				to.setTname(rs.getString("tname"));
				list.add(to);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			du.closeAll(rs, pst, conn);
		}
		return list;
	}
	@Override
	public boolean Tm(Topic topic) {
		boolean flag=false;
		conn=du.getConnection();
		String sql="UPDATE topic SET  tid=?,tname=? WHERE tid=? ";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, topic.getTid());
			pst.setString(2, topic.getTname());
			pst.setInt(3, topic.getTid());
			int i=pst.executeUpdate();
			if(i>0){
				flag=true;
			}else{
				System.out.println("flag false");
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
	public boolean Td(Topic topic) {
		boolean flag=false;
		conn=du.getConnection();
		String sql="delete  from topic where tid=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, topic.getTid());
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
	public boolean Tr(Topic t) {
		boolean flag=false;
		conn=du.getConnection();
		String sql="insert into topic (tname)value(?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, t.getTname());
			if(pst.executeUpdate()>0){
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

}
