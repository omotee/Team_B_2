package com.seotoaster.core;

import javax.mail.MessagingException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.seotoaster.utils.SendMail;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = false,
		plugin = {"pretty", 
				"html:target/cukesReports/report-xml",
				"json:target/cukesReports/report-json.json",
				"junit:target/cukesReports/report-xml.xml"},
		features = {"classpath:com/seotoaster/features"},
		tags = {}
		)

public class RunnerCukesTest {
	
	
	
	
	@AfterClass
	public static void cleanTestEvironment() throws Throwable{
//		SendMail send = new SendMail();
//		send.postMail(SendMail.emailList, SendMail.emailSubjectTxt, SendMail.emailMsgTxt, SendMail.emailFromAddress);
	}
	
	
}
 