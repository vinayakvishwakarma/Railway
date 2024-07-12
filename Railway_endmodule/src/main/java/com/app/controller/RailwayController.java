package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Category;
import com.app.entity.RailwayEntity;
import com.app.service.RailwayService;



@RestController
@RequestMapping("/railway")
public class RailwayController {

	@Autowired
	private RailwayService railwayService;
	@PostMapping
	public ResponseEntity<?> addRailway(@RequestBody RailwayEntity railway){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(railwayService.addRailway(railway));
			
		}
		catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRailway(@PathVariable @Valid Long id){
		try {
			return ResponseEntity.status(HttpStatus.FOUND).body(railwayService.deleteById(id));
		}
		catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.FOUND).body(railwayService.getAll());
		}
		catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	@GetMapping("/{category}")
	public ResponseEntity<?> getByCategory(@PathVariable String category){
		try{Category ct=Category.valueOf(category.toUpperCase());
		return ResponseEntity.status(HttpStatus.FOUND).body(railwayService.displayByCategory(ct));
		}
		catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
	
	
}
