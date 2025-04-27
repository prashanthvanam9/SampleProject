package com.bee.pdf.demo.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bee.pdf.demo.entity.Bees;
import com.bee.pdf.demo.generator.PayrollPdfGenerator;
import com.bee.pdf.demo.generator.PdfGenerator;
import com.bee.pdf.demo.service.BeeService;
import com.bee.pdf.demo.service.IExcelDataService;
import com.bee.pdf.demo.service.IFileUploadService;
import com.itextpdf.html2pdf.HtmlConverter;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/app")
@Slf4j
public class BeeController {

	Logger log = LoggerFactory.getLogger(BeeController.class);
	@Autowired
	private BeeService beeService;
	
	
	  @Autowired 
	  private IFileUploadService uploadService;
	  
	  @Autowired 
	  private IExcelDataService excelService;
	 
	
	@GetMapping("/exportPDF")
	public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException{
		log.info("*** Inside generatePdfFile of BeeController");
		response.setContentType("application/pdf");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = df.format(new Date());
		log.info("Current Date and Time: "+currentDateTime);
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=Bees_" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		log.info("*** from exportPDF");
		List<Bees> bee = beeService.getBeesList();
		PdfGenerator generator = new PdfGenerator();
		//PayrollPdfGenerator generator = new PayrollPdfGenerator();
		generator.generate(null, bee, response);
	}
	
	@RequestMapping(value = "/saveBee", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView saveBee(Bees bee) {
		log.info("*** Inside saveBee of BeeController");
		ModelAndView model = new ModelAndView("login");
		beeService.addBee(bee);
		model.addObject("saveResponseMsg", "Bee ID: "+bee.getId()+" Inserted Successfully!");
		//return new ModelAndView( "redirect:/index.html");
		return model;
	}
	
	@GetMapping("/fetchAllBees")
	public ModelAndView getBees() throws IOException {
		List<Bees> bees = beeService.getBeesList();
		//log.info("*** 2222 Inside getBees of BeeController");
		//ModelAndView model=new ModelAndView();
		/*
		 * for (Bees bees : beeList) {
		 * log.info("*** 3333 Inside for : "+beeList.get(1));
		 * //log.info("Get Status :: "+new
		 * ModelAndView("redirect:/result.jsp").getStatus()); }
		 */
		//model.addObject("bees", beeList);
		//model.setViewName("result");
		//model.setStatus(HttpStatus.OK);
		//log.info("Get model object :: "+model.getModel());
		
		/*
		 * Bees bees = new Bees(); bees.setId(999L); bees.setBeeName("Radhe");
		 * bees.setEmail("radhe@test.com"); bees.setMobileNo("9999999999");
		 */
		
		//return new ModelAndView("result","WelcomeMessage","Welcome!");
		return new ModelAndView("result").addObject("beeList", bees);
		//return model;
	}
	
	/*
	 * @RequestMapping(value = "/redirecturl", method = RequestMethod.POST) public
	 * ModelAndView methodPost() { return new ModelAndView( "redirect:/login.html");
	 * 
	 * }
	 */
	
	@RequestMapping(value="/fetchBeeById", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView findBeeById(@RequestParam Long id) {
		log.info("*** Inside findBeeById of BeeController : "+id);
		Bees bee = beeService.findBeeById(id);
		log.info("*** Bee details:: "+bee);
		return new ModelAndView("result").addObject("beeInfo", bee);
	}
	
	@GetMapping("/exportBeePayroll")
	public void generateBeePDF(@RequestParam Long id, HttpServletResponse response) throws DocumentException, IOException{
		
		log.info("*** Inside generateBeePDF of BeeController id :: "+id);
		response.setContentType("application/pdf");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = df.format(new Date());
		log.info("Current Date and Time: "+currentDateTime);
		Bees bee = beeService.findBeeById(id);
		
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename="+bee.getBeeName()+ "_" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		
		log.info("*** from exportBeePayroll");
		
		//PdfGenerator generator = new PdfGenerator();
		PayrollPdfGenerator generator = new PayrollPdfGenerator();
		generator.generate(bee, null, response);
	}
	
	@RequestMapping(value="/exportHtmlToPDF", method = RequestMethod.GET)
	public ModelAndView generateHtmlToPDF() throws IOException {
		log.info("*** Inside generateHtmlToPDF "+new File("pdf-input.html").getAbsolutePath());
		return new ModelAndView("redirect:pdf-input.html");
		//HtmlConverter.convertToPdf(new File("pdf-input.html"),new File("demo-html.pdf"));
	}
	
	@RequestMapping(value = "/deleteBee", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView removeBeeById(Bees bee) {
		ModelAndView model = new ModelAndView("result");
		Long id = bee.getId();
		log.info("*** Inside removeBeeById of BeeController id :: "+id);
		beeService.removeBeeById(id);
		model.addObject("deleteResponseMsg", "Bee ID: " + id + " Deleted Successfully!");
		//model.setViewName("result");
		return model;
		//return new ModelAndView("result").addObject("responsemsg", "Deleted Successfully!");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView home() {
	    log.info("Welcome to Bee World!");      
	    return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView result() {
	    log.info("In result page!");      
	    return new ModelAndView("result");
	}
	
	@RequestMapping(value = "/updateBee", method = RequestMethod.POST)
	public ModelAndView updateBee(Bees bee) {
		ModelAndView model = new ModelAndView("result");
	    log.info("In updateBee!");
	    Long id = bee.getId();
	    beeService.updateBee(bee);
	    model.addObject("updateResponseMsg", "Bee ID: " + id + " Update Successfully!");
	    return model;
	}
	
	@RequestMapping(value = "/importBees", method = RequestMethod.GET)
	public ModelAndView importBees() {
	    log.info("In importBees page!");
	    return new ModelAndView("upload");
	}
	
	@RequestMapping(value = "uploadFile", method = RequestMethod.POST)
	public ModelAndView uploadExcel(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		log.info("In uploadExcel!");
		ModelAndView model = new ModelAndView("upload");
		uploadService.uploadFile(file);
		model.addObject("message", "You have successfully uploaded "+file.getOriginalFilename()+" !");
		//return "redirect:/";
		return model;
	}
	
	@RequestMapping(value = "/saveData", method = RequestMethod.GET)
	public String saveExcelData(Model model) {
		log.info("In saveExcelData!");
		
		List<Bees> beesList = excelService.getExxcelDataAsList();
		//log.info("In saveExcelData beesList :: "+beesList.size());
		int noOfRecords = excelService.saveExcelData(beesList);
		model.addAttribute("noOfRecords", noOfRecords);
		return "upload";
	}
	
	@RequestMapping(value = "/resetBees", method = RequestMethod.GET)
	public String resetBees(Model model) {
		log.info("In resetBees!");
		//ModelAndView model = new ModelAndView("upload");
		List<Bees> beesList = null;
		//model.addAttribute("noOfRecords", "");
	    return "upload";
	}
}
