package com.bee.pdf.demo.service;

import java.util.List;

import com.bee.pdf.demo.entity.Bees;

public interface IExcelDataService {

	List<Bees> getExxcelDataAsList();
	
	int saveExcelData(List<Bees> bees);
}
