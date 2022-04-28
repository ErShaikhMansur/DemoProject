package com.man.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.man.dto.StudentDto;

@Service
public class PdfGeneratorService {
	@Autowired
	private StudentService service;

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(2);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.BLACK);

		cell.setPhrase(new Phrase("Student ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("E-mail", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("First Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("LastName", font));
		table.addCell(cell);

	}

	private void writeTabledata(PdfPTable table) {
		List<StudentDto> list = service.getAllStudent();

		for (StudentDto dto : list) {
			table.addCell(String.valueOf(dto.getId()));
			table.addCell(dto.getEmail());
			table.addCell(dto.getFirstName());
			table.addCell(dto.getLastName());
		}
	}


	public void exportPdf(HttpServletResponse response) throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 16, BaseColor.BLACK);
		font.setSize(18);
		PdfPTable table = new PdfPTable(4);
		
		
		Paragraph paragraph = new Paragraph("List of Student",font);
		
		Paragraph paragraph2=new Paragraph();
		paragraph2.add("     ");
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		writeTableHeader(table);
		writeTabledata(table);
		document.add(paragraph);
		document.add(paragraph2); 
		document.add(table);
		
		document.close();

	}
}
