package com.demoQA.tests;

import org.testng.annotations.Test;


import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.testng.Assert;
import com.demoQA.Constants.Constants;
import com.demoQA.basetest.BaseClass;
import com.demoQA.page.Elements;

public class HomePage_Test extends BaseClass{
	static Logger log=Logger.getLogger(HomePage_Test.class);
@Test
public void testElement() {
      Elements element=home.goToElementsPage();
      String actual=element.checkTitle();
  	log.info("actual result : "+actual);
      String expected=Constants.ELEMENT_TITLE;
      log.info("expected result : "+expected);
      AssertJUnit.assertEquals(actual, expected);
}
}
