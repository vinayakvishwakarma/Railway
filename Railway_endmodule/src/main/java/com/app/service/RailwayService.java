package com.app.service;

import java.util.List;

import com.app.entity.Category;
import com.app.entity.RailwayEntity;

public interface RailwayService {

	public String addRailway(RailwayEntity railway);
	
	public String deleteById(Long id);
	
	public List<RailwayEntity> getAll();
	
	public List<RailwayEntity> displayByCategory(Category category);
	
}
