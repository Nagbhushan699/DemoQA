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
	@Test
	public void testAlert() {
		String actual=alert.verifyAlertPopupMsg();
		log.info("actual result : "+actual);
		String expected=Constants.EXPECTEDALERTTEXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual,expected);
	}
	@Test
	public void testTitle() {
		String actual=	alert.getTitle();
		log.info("actual result : "+actual);
		String expected=Constants.ALERTPAGETITLE;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void testTimerAlert() {
		String actual=alert.verifyTimerAlertPopopMsg();
		log.info("actual result : "+actual);
		String expected=Constants.EXPECTEDTIMERALERTTEXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testConfirmAlertPopupMsg() {
		String actual=alert.verifyConfirmAlertPopopMsg();
		log.info("actual result : "+actual);
		String expected=Constants.EXPECTEDCONFIRMALERTPOPUPTEXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void testConfirmAlertSuccesfullMsg() {
		String actual=alert.verifyConfirmAlertSuccesfullMsg();
		log.info("actual result : "+actual);
		String expected=Constants.CONFIRMALERTMSG;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void testPromptAlertPopupMsg() {
		String actual=alert.verifyPromptAlertPopopMsg();
		log.info("actual result : "+actual);
		String expected=Constants.EXPECTEDPROMPTALERTPOPUPTEXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void testPromptAlert() {
		String actual=alert.verifyPromptAlertInputText();
		log.info("actual result : "+actual);
		String expected=Constants.PROMPTALERTTEXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
}

