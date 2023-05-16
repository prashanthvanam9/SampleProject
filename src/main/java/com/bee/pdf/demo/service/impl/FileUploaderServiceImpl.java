package com.bee.pdf.demo.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bee.pdf.demo.service.IFileUploadService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileUploaderServiceImpl implements IFileUploadService{

	Logger log = LoggerFactory.getLogger(FileUploaderServiceImpl.class);
	
	@Value("${app.upload.dir:${user.home}}")
	public String uploadDir;
	public void uploadFile(MultipartFile file) {
		log.info("*** Inside uploadFile of FileUploaderServiceImpl");
		try {
            Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            log.info("*** copyLocation :: "+copyLocation.toString());
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not store file " + file.getOriginalFilename()
                + ". Please try again!");
        }
	}
}
