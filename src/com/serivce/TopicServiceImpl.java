package com.serivce;

import java.util.List;

import com.Dao.TopicDao;
import com.Dao.TopicDaoImpl;
import com.entity.Topic;

public class TopicServiceImpl implements TopicService {
		TopicDao td=new TopicDaoImpl();
	@Override
	public List<Topic> getall() {
		List<Topic>list=td.getall();
		return list;
	}
	@Override
	public boolean Tm(Topic topic) {
		// TODO Auto-generated method stub
		return td.Tm(topic);
	}
	@Override
	public boolean Td(Topic topic) {
		// TODO Auto-generated method stub
		return td.Td(topic);
	}
	@Override
	public boolean Tr(Topic t) {
		
		return td.Tr(t);
	}

}
