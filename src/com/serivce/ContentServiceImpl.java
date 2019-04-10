package com.serivce;

import java.util.List;

import com.Dao.ContentDao;
import com.Dao.ContentDaoImpl;
import com.entity.Content;
import com.entity.Page;

public class ContentServiceImpl implements ContentService {
	ContentDao ad= new ContentDaoImpl();
	@Override
	public List<Content> getall() {
		
		List<Content>list=ad.getall();
		return list;
	}

	@Override
	public boolean Cr(Content content) {
		// TODO Auto-generated method stub
		return ad.Cr(content);
	}

	@Override
	public boolean Cm(Content content) {
		// TODO Auto-generated method stub
		return ad.Cm(content);
	}

	@Override
	public boolean Cd(Content content) {
		// TODO Auto-generated method stub
		return ad.Cd(content);
	}

	@Override
	public Page getUserList(int currPageNo, int pageSize) {
		// TODO Auto-generated method stub
		Page page=new Page();
		
		
		page.setCurrPageNo(currPageNo);
		page.setPageSize(pageSize);
		
		
		
		ContentDao user=new ContentDaoImpl();
		int count=user.finByUserCount();
		//System.out.println(count);
		
		page.setTotalCount(count);
		List<Content> list=user.finBylistUser(page.getCurrPageNo(),page.getPageSize());

		page.setNewsList(list);
		return page;
	}

}
