package com.bee.pdf.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bee.pdf.demo.entity.Bees;

public interface BeeService {

	void addBee(Bees bee);
	
	List<Bees> getBeesList();
	
	Bees findBeeById(Long id);
	
	void removeBeeById(Long id);
	
	void updateBee(Bees bee);
	
	void beeLeaves(Bees bee);
	
}
