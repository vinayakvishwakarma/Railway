package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Category;
import com.app.entity.RailwayEntity;

public interface RailwayRepo extends JpaRepository<RailwayEntity, Long> {

	@Query("select p from RailwayEntity p where p.category=:category")
	List<RailwayEntity> findByCategory(Category category);

}
