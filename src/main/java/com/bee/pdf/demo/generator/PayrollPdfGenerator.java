package com.bee.pdf.demo.generator;

import com.bee.pdf.demo.entity.Bees;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPRow;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayrollPdfGenerator {

	Logger log = LoggerFactory.getLogger(PayrollPdfGenerator.class);
	
	public void generate(Bees bee1, List<Bees> beesList, HttpServletResponse response) throws DocumentException, IOException{
		log.info("*** Inside generate of PayrollPdfGenerator :: "+bee1);
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
		fontTitle.setSize(20);
		
		if(bee1 == null || bee1.equals("null")) {
			Paragraph para1 = new Paragraph("Payroll", fontTitle);
			document.add(para1);
		}else {
			Paragraph para1 = new Paragraph("Payroll", fontTitle);
			document.add(para1);
		}
		
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new int[] {3,3,3,3,3});
		table.setSpacingBefore(5);
		
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(CMYKColor.GRAY);
		cell.setPadding(5);
		cell.setPadding(2);
		
		Font font = FontFactory.getFont(FontFactory.TIMES_BOLD);
		font.setColor(CMYKColor.WHITE);
		
		cell.setPhrase(new Phrase("Bee ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Bee Name",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Email", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Mobile No#", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("DOJ", font));
		table.addCell(cell);
		
		log.info("*** Inside bee1 :: "+bee1);
		//log.info("*** Inside beeList :: "+beesList.size());
		if(bee1 == null || bee1.equals("null")) {
			log.info("*** Inside IF beeList size :: "+beesList.size());
			for (Bees bee: beesList) {
				table.addCell(String.valueOf(bee.getId()));
				table.addCell(bee.getBeeName());
				table.addCell(bee.getEmail());
				table.addCell(bee.getMobileNo());
			}
		}else {
			log.info("*** Inside ELSE Bee1 :: "+bee1);
			table.addCell(String.valueOf(bee1.getId()));
			table.addCell(bee1.getBeeName());
			table.addCell(bee1.getEmail());
			table.addCell(bee1.getMobileNo());
			table.addCell(bee1.getDoj());
		}
		document.add(table);
		
		
		PdfPTable table1 = new PdfPTable(2);
		table1.setWidthPercentage(100f);
		table1.setWidths(new int[] {3,3});
		table1.setSpacingBefore(5);
		
		PdfPCell cell1 = new PdfPCell();
		//PdfPRow row = new PdfPRow();
		//cell1.setBackgroundColor(CMYKColor.GRAY);
		cell1.setPadding(5);
		cell1.setPaddingLeft(20);
		//cell1.setBorder(1);
		
		Font font1 = FontFactory.getFont(FontFactory.TIMES);
		font1.setColor(CMYKColor.BLACK);
		font1.setSize(10);
		
		cell1.setPhrase(new Phrase("Basic", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase("6000", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase("HRA", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase("2500", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase("Allowences", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase("5000", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase("PF", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase("800", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase("Income Tax", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase("500", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase("Professional Tax", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase("200", font1));
		table1.addCell(cell1);
		
		cell1.setPhrase(new Phrase("Total", font1));
		table1.addCell(cell1);
		cell1.setPhrase(new Phrase(String.valueOf(bee1.getSalary()), font1));
		table1.addCell(cell1);
		
		document.add(table1);
		
		document.close();
	}
}
