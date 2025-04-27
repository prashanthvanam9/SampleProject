package com.bee.pdf.demo.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bee.pdf.demo.entity.Bees;
import com.bee.pdf.demo.exception.BeeAlreadyExistsException;
import com.bee.pdf.demo.exception.BeeNotFoundException;
import com.bee.pdf.demo.repository.BeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BeeServiceImpl implements BeeService{
	
	Logger log = LoggerFactory.getLogger(BeeServiceImpl.class);
	
	@Autowired
	private BeeRepository beeRepo;
	
	@Override
	public void addBee(Bees bee) {
		log.info("***Inside addBee");
		try {
			String date = dateFormatUtil(bee.getDoj());
			Date currentdate = new Date();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * var existingBee = beeRepo.findById(bee.getId()).orElse(null); if(existingBee
		 * != null) { throw new
		 * BeeAlreadyExistsException("Bee already exists with the given ID."); }
		 */
		beeRepo.save(bee);
		log.info("***Inside addBee ::: Bee Saved!"+bee.toString());
	}
	
	public List<Bees> getBeesList(){
		log.info("***Inside getBeesList");
		return beeRepo.findAll();
	}
	
	@Override
	public Bees findBeeById(Long id){
		log.info("***Inside findBeeById : "+id);
		return beeRepo.findBeeById(id);
				 // .orElseThrow() -> new BeeNotFoundException("Bee not found with the given ID.");
	}
	
	public void removeBeeById(Long id) {
		log.info("***Inside removeBeeById : "+id);
		beeRepo.deleteById(id);
	}
	
	public void updateBee(Bees bee) {
		log.info("***Inside updateBee of BeeServiceImpl beeObj --> bee.getId() : "+ bee.getId());
		Bees beeDB = beeRepo.findBeeById(bee.getId());
		log.info("***Inside updateBee of BeeServiceImpl beeDB : "+ beeDB);
		if (Objects.nonNull(bee.getBeeName()) && !"".equalsIgnoreCase(bee.getBeeName())) {
            beeDB.setBeeName(bee.getBeeName());
        }
		if (Objects.nonNull(bee.getEmail())&& !"".equalsIgnoreCase(bee.getEmail())) {
            beeDB.setEmail(bee.getEmail());
        }
		if (Objects.nonNull(bee.getMobileNo()) && !"".equalsIgnoreCase(bee.getMobileNo())) {
            beeDB.setMobileNo(bee.getMobileNo());
        }
		if (Objects.nonNull(bee.getSalary()) && bee.getSalary() != 0) {
            beeDB.setSalary(bee.getSalary());
        }
		if (Objects.nonNull(bee.getDoj()) && !"".equalsIgnoreCase(bee.getDoj())) {
            beeDB.setDoj(bee.getDoj());
        }
		beeRepo.save(beeDB);
	}
	
	public void beeLeaves(Bees bee) {
		log.info("***Inside updateBee of BeeServiceImpl beeObj --> bee.getId() : "+ bee.getId());
	}
	
	public String dateFormatUtil(String doj) throws ParseException{
		DateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = parseFormat.parse(doj);
		String strDate = parseFormat.format(date);
		System.out.println(strDate);

		// if you get date of type 'java.sql.Date' directly from database cursor like
        //rs.getDate("created_date"), just pass it directly to format()

		SimpleDateFormat dateFormat = new SimpleDateFormat(
               "dd-MMM-yyyy");
		String stringDate = dateFormat.format(date);
		System.out.println(stringDate);
		
        return stringDate;
	}
}
