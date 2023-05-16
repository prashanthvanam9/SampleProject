package com.bee.pdf.demo.generator;

import com.bee.pdf.demo.entity.Bees;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PdfGenerator {

	Logger log = LoggerFactory.getLogger(PdfGenerator.class);
	
	public void generate(Bees bee1, List<Bees> beesList, HttpServletResponse response) throws DocumentException, IOException{
		log.info("*** Inside generate of PdfGenerator :: "+bee1);
		float logoImgScale[] = {40,40};
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Image img = Image.getInstance("C:\\Users\\prvanam\\Downloads\\sampleImg.png");
		img.scalePercent(logoImgScale[0], logoImgScale[1]);
		img.setAlignment(Element.ALIGN_LEFT);
		document.add(img);
		
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES);
		fontTitle.setSize(20);
		
		if(bee1 == null || bee1.equals("null")) {
			Paragraph para1 = new Paragraph("List of Bees", fontTitle);
			document.add(para1);
		}else {
			Paragraph para1 = new Paragraph("Payroll", fontTitle);
			document.add(para1);
		}
			
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100f);
		table.setWidths(new int[] {1,3,5,3,3,3});
		table.setSpacingBefore(5);
		
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(CMYKColor.GRAY);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.TIMES_BOLD);
		font.setColor(CMYKColor.WHITE);
		
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Bee Name",font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Email", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Mobile No", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Salary", font));
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
				table.addCell(String.valueOf(bee.getSalary()));
				table.addCell(bee.getDoj());
			}
		}else {
			log.info("*** Inside ELSE Bee1 :: "+bee1);
			table.addCell(String.valueOf(bee1.getId()));
			table.addCell(bee1.getBeeName());
			table.addCell(bee1.getEmail());
			table.addCell(bee1.getMobileNo());
			table.addCell(String.valueOf(bee1.getSalary()));
			table.addCell(bee1.getDoj());
		}
		document.add(table);
		document.close();
	}
}
