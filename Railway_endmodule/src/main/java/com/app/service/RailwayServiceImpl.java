package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.Category;
import com.app.entity.RailwayEntity;
import com.app.repository.RailwayRepo;
@Service
@Transactional
public class RailwayServiceImpl implements RailwayService {

	@Autowired
	private RailwayRepo railwayRepo;
	@Override
	public String addRailway( RailwayEntity railway) {
		railwayRepo.save(railway);
		return "Added Successfully!!";
	}

	@Override
	public String deleteById(Long id) {
		railwayRepo.deleteById(id);
		return "Successfully deleted!!";
	}

	@Override
	public List<RailwayEntity> getAll() {
		return railwayRepo.findAll();
		
	}

	@Override
	public List<RailwayEntity> displayByCategory(Category category) {
		
		return railwayRepo.findByCategory(category);
	}

}
