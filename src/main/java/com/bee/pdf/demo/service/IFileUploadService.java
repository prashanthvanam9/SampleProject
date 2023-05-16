package com.bee.pdf.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadService {

	public void uploadFile(MultipartFile file);
}
