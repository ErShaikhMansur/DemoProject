package com.man.ctl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.man.service.PdfGeneratorService;

@RestController
public class PdfController {

	@Autowired
	private PdfGeneratorService generatorService;
	
	@GetMapping(value="/pdf/generate")
	public void pdfGenerate(HttpServletResponse response) throws DocumentException, IOException  {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
	String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	response.setHeader(headerKey, headerValue);
	
		generatorService.exportPdf(response);
	}
}
