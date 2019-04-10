package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Content;
import com.util.DatabaseUtil;

public class ContentDaoImpl implements ContentDao {
	private Connection conn=null;
	private ResultSet rs=null;
	private PreparedStatement pst=null;
	DatabaseUtil du=new DatabaseUtil();
	public List<Content> getall() {
		List<Content>list=new ArrayList<Content>();
		Content co=null;
		conn=du.getConnection();
		String sql="select * from news ";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				co=new Content();
				co.setNtid(rs.getInt("ntid"));
				co.setNauthor(rs.getString("nauthor"));
				co.setNcontent(rs.getString("ncontent"));
				co.setNcreateDate(rs.getString("ncreateDate"));
				co.setNid(rs.getInt("nid"));
				co.setNmodifyDate(rs.getString("nmodifyDate"));
				co.setNpicpath(rs.getString("npicpath"));
				co.setNtitle(rs.getString("ntitle"));
				co.setNsummary(rs.getString("nsummary"));
				list.add(co);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			du.closeAll(rs, pst, conn);
		}
		return list;
	}
	public boolean Cr(Content content) {
		boolean flag=false;
		conn=du.getConnection();
		String sql="insert into news (ntid,nauthor,ncontent,ntitle,nsummary)value(?,?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, content.getNtid());
			pst.setString(2, content.getNauthor());
			pst.setString(3, content.getNcontent());
			pst.setString(4, content.getNsummary());
			pst.setString(5, content.getNtitle());
			int i=pst.executeUpdate() ;
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
	public boolean Cm(Content content) {
		boolean flag=false;
		conn=du.getConnection();
		String sql="update news set nid=?,ntitle=? where nid=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, content.getNid());
			pst.setString(2, content.getNtitle());
			pst.setInt(3, content.getNid());
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
	public boolean Cd(Content content) {
		// TODO Auto-generated method stub
		boolean flag=false;
		conn=du.getConnection();
		String sql="delete from news where nid=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, content.getNid());
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
	public int finByUserCount() {
		int count=-1;
		try{	
			conn=du.getConnection();
			String sql="select count(1) from news";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			rs.next();
			count=rs.getInt(1);
		}catch (Exception e){
			// TODO Auto-generated catch block
			System.out.println("获取连接失败");
			e.printStackTrace();
		}finally{
			du.closeAll(rs,pst, conn);
		}
		return count;
	}
	public List<Content> finBylistUser(int currPageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<Content> list = new ArrayList<Content>();
		try{	
			conn=du.getConnection();
			String sql="select * from news  limit ?,?";
			int index =(currPageNo-1)*pageSize;
			pst=conn.prepareStatement(sql);
			pst.setInt(1, index);
	    	pst.setInt(2, pageSize);
	    	rs = pst.executeQuery();
	    	
	    	Content news = null;
	        while (rs.next()) {
	        	 news = new Content();
                news.setNid(rs.getInt("nid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNsummary(rs.getString("nsummary"));
                news.setNcontent(rs.getString("ncontent"));
                list.add(news);
	        }
	    	
		}catch (Exception e){
			// TODO Auto-generated catch block
			System.out.println("获取连接失败");
			e.printStackTrace();
		}finally{
			du.closeAll(rs,pst, conn);
		}
	
			return list;
	}
}
	