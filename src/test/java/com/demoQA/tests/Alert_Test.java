package com.demoQA.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demoQA.Constants.Constants;
import com.demoQA.basetest.BaseClass;
import com.demoQA.page.Alert_Frame_Window_Page;
import com.demoQA.page.Alerts;

public class Alert_Test extends BaseClass{
	static Logger log=Logger.getLogger(Alert_Test.class);
	Alerts alert;
	@BeforeClass
	public void beforeClass() {
		Alert_Frame_Window_Page alert_frame=	home.goToAlert();
		alert=alert_frame.goToAlerts();
	}
	@Test(priority = 1)
	public void testAlert() {
		alert.clickAlertPopup();
		boolean flag =alert.isAlertPresent();
		Assert.assertEquals(flag, true);
		String actual=alert.getAlertPopupMsg();
		log.info("actual result : "+actual);
		String expected=Constants.EXPECTEDALERTTEXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual,expected);
	}
	
	@Test()
	public void testTitle() {
		String actual=	alert.getTitle();
		log.info("actual result : "+actual);
		String expected=Constants.ALERTPAGETITLE;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 2)
	public void testTimerAlert() {
		alert.clickTimerPopup();
		boolean flag =alert.isAlertPresent();
		Assert.assertEquals(flag, true);
		String actual=alert.getTimerAlertPopopMsg();
		log.info("actual result : "+actual);
		String expected=Constants.EXPECTEDTIMERALERTTEXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual,expected);
	}
	
	@Test(priority = 3)
	public void testConfirmAlertPopupMsg() {
		alert.clickConfirmAlertPopup();
		boolean flag =alert.isAlertPresent();
		Assert.assertEquals(flag, true);
		String actual=alert.getConfirmAlertPopopMsg();
		log.info("actual result : "+actual);
		String expected=Constants.EXPECTEDCONFIRMALERTPOPUPTEXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 4)
	public void testConfirmAlertSuccesfullMsg() {
		String actual=alert.getConfirmAlertSuccesfullMsg();
		log.info("actual result : "+actual);
		String expected=Constants.CONFIRMALERTMSG;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 5)
	public void testPromptAlertPopupMsg() {
		alert.clickPromptAlertPopup();
		boolean flag=alert.isAlertPresent();
		Assert.assertEquals(flag, true);
		String actual=alert.getPromptAlertPopopMsg();
		log.info("actual result : "+actual);
		String expected=Constants.EXPECTEDPROMPTALERTPOPUPTEXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 6)
	public void testPromptAlertInputText() {
		String actual=alert.getPromptAlertInputText();
		log.info("actual result : "+actual);
		String expected=Constants.PROMPTALERTTEXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
}

