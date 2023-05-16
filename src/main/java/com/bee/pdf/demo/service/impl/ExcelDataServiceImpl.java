package com.bee.pdf.demo.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bee.pdf.demo.entity.Bees;
import com.bee.pdf.demo.repository.BeeRepository;
import com.bee.pdf.demo.service.IExcelDataService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExcelDataServiceImpl implements IExcelDataService{

	Logger log = LoggerFactory.getLogger(ExcelDataServiceImpl.class);
	@Value("${app.upload.file:${user.home}}")
	public String EXCEL_FILE_PATH;
	
	@Autowired
	BeeRepository beeRepo;
	
	Workbook workbook;
	
	public List<Bees> getExxcelDataAsList() throws EncryptedDocumentException{
		log.info("*** Inside getExxcelDataAsList of ExcelDataServiceImpl");
		List<String> list = new ArrayList<String>();
		
		DataFormatter dataFormatter = new DataFormatter();
		
		try {
			workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
		}catch(Exception e) {
			e.printStackTrace();
		}
		log.info("Workbook has " + workbook.getNumberOfSheets() + " Sheets");
		
		Sheet sheet = workbook.getSheetAt(0);
		
		int noOfCols = sheet.getRow(0).getLastCellNum();
		log.info("Sheet has " + noOfCols + " Columns");
		
		for(Row row : sheet) {
			for(Cell cell : row) {
				String cellValue = dataFormatter.formatCellValue(cell);
				list.add(cellValue);
			}
		}
		
		List<Bees> beesList = createBeesList(list, noOfCols);
		log.info("*** beesList :: "+beesList.size());
		return beesList;
	}
	
	public List<Bees> createBeesList(List<String> excelData, int noOfCols){
		log.info("*** Inside createBeesList of ExcelDataServiceImpl :: noOfCols: "+noOfCols+" excelData.size(): "+excelData.size());
		ArrayList<Bees> beesList = new ArrayList<Bees>();
		
		int i = noOfCols;
		do {
			//Bees bees = new Bees();
			log.info("*** Inside for get("+i+"): "+excelData.get(i));
			Bees beeDB = beeRepo.findBeeById(Long.valueOf(excelData.get(i)));
			log.info("*** Inside While: beeDB "+beeDB);
			if(beeDB != null) {
				break;
			}else {
				log.info("*** Inside While - else :");
				Bees bee = new Bees();
				bee.setId(Long.valueOf(excelData.get(i)));
				bee.setBeeName(excelData.get(i+1));
				bee.setEmail(excelData.get(i+2));
				bee.setMobileNo(excelData.get(i+3));
				bee.setSalary(Long.valueOf(excelData.get(i+4)));
				bee.setDoj(excelData.get(i+5));
				beesList.add(bee);
				i = i + (noOfCols);
			}
		}while(i < excelData.size());
		
		
		/*
		 * for (int j=noOfCols;j < excelData.size();j++) {
		 * log.info("*** Inside for get("+j+"): "+excelData.get(j)); // if(j == ) Bees
		 * beeDB = beeRepo.findBeeById(Long.valueOf(excelData.get(j))); if(beeDB !=
		 * null) { log.info("*** Bee "+beeDB.getId()+" already Exists!"); }else {
		 * log.info("*** New Bee beeDB: "+beeDB); Bees bee = new Bees();
		 * bee.setId(Long.valueOf(excelData.get(j)));
		 * bee.setBeeName(excelData.get(j+1)); bee.setEmail(excelData.get(j+2));
		 * bee.setMobileNo(excelData.get(j+3));
		 * bee.setSalary(Long.valueOf(excelData.get(j+4)));
		 * bee.setDoj(excelData.get(j+5)); beesList.add(bee); }
		 * 
		 * log.info("*** Inside for :: Out of Else beesList: "+beesList.size()); }
		 */
		return beesList;
	}
	
	public int saveExcelData(List<Bees> bee) {
		log.info("*** Inside saveExcelData of ExcelDataServiceImpl bee: "+bee.size());
		bee = beeRepo.saveAll(bee);
		return bee.size();
	}
}
