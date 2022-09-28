package com.demoQA.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {
	WebDriver driver;
	//WebElements
	By title=By.xpath("//div[text()='Alerts']");
	String alertbtn="//button[@id='alertButton']";
	String timerAlert="//button[@id='timerAlertButton']";
	String confirmAlert="//button[@id='confirmButton']";
	String promptAlert="//button[@id='promtButton']";
	By confirmTextSuceesMsg=By.xpath("//span[@id='confirmResult']");
	By promptTextSuceesMsg=By.xpath("//span[@id='promptResult']");
	//driver initilizing
	public Alerts(WebDriver driver) {
		this.driver=driver;
	}
	//page Actions
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public boolean IsAlertPresent(String alert) {
		driver.findElement(By.xpath(alert)).click();
		try {
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public String verifyAlertPopupMsg() {
		String text = " ";
		boolean flag=IsAlertPresent(alertbtn);
		if(flag) {
			Alert alert=driver.switchTo().alert();
			text=alert.getText();
			alert.accept();
		}
		return text;
	}
	public String verifyTimerAlertPopopMsg() {
		String text = " ";
		boolean flag=IsAlertPresent(timerAlert);
		if(flag) {
			driver.switchTo().alert();
			Alert alert=driver.switchTo().alert();
			text=alert.getText();
			alert.accept();
		}
		return text;
	}
	public String verifyConfirmAlertPopopMsg() {
		String text = " ";
		boolean flag=IsAlertPresent(confirmAlert);
		if(flag) {
			driver.switchTo().alert();
			Alert alert=driver.switchTo().alert();
			text=alert.getText();
		}
		return text;
	}
	public String verifyConfirmAlertSuccesfullMsg() {
		boolean flag=IsAlertPresent(confirmAlert);
		if(flag) {
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		String msg=driver.findElement(confirmTextSuceesMsg).getText();
		return msg;
	}
	public String verifyPromptAlertPopopMsg() {
		String text = " ";
		boolean flag=IsAlertPresent(promptAlert);
		if(flag) {
			driver.switchTo().alert();
			Alert alert=driver.switchTo().alert();
			text=alert.getText();
		}
		return text;
	}

	public String verifyPromptAlertInputText() {
		boolean flag=IsAlertPresent(promptAlert);
		if(flag) {
			Alert alert=driver.switchTo().alert();
			alert.sendKeys("I am Nagbhushan");
			alert.accept();
		}
		return driver.findElement(promptTextSuceesMsg).getText();
	}
}
