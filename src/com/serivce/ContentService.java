package com.serivce;

import java.util.List;

import com.entity.Content;
import com.entity.Page;

public interface ContentService {
public List<Content> getall();
public boolean Cr(Content content);
public boolean Cm(Content content);
public boolean Cd(Content content);
public Page getUserList(int currPageNo, int pageSize);
}
