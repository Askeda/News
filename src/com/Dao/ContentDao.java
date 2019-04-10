package com.Dao;

import java.util.List;

import com.entity.Content;
public interface ContentDao {
public List<Content> getall();
public boolean Cr(Content content);
public boolean Cm(Content content);
public boolean Cd(Content content);
public int finByUserCount();
public List<Content> finBylistUser(int currPageNo, int pageSize);
}
