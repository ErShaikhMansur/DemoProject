package com.man.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.log.SysoCounter;
import com.man.service.EmailService;
import com.man.utility.EmailConstant;

@RestController
@RequestMapping(value="/Email")
public class EmailCtl {

	@Autowired
	private EmailService service;
	
	@PostMapping(value="/sendmail")
	public void sendMail() {
		service.sendSimpleMessage("arshadameenansari@gmail.com",EmailConstant.Subject,
				EmailConstant.Message);
		System.out.println("Mail Send SuccessFully.....");
	}
}
