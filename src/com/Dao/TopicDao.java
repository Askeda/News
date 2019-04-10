package com.Dao;

import java.util.List;

import com.entity.Topic;

public interface TopicDao {
public List<Topic> getall();
public boolean Tm(Topic topic);
public boolean Td(Topic topic);
public boolean Tr(Topic t);
}
