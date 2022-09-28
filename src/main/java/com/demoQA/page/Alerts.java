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
	By alertbtn=By.xpath("//button[@id='alertButton']");
	By timerAlert=By.xpath("//button[@id='timerAlertButton']");
	By confirmAlert=By.xpath("//button[@id='confirmButton']");;
	By promptAlert=By.xpath("//button[@id='promtButton']");
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
	
	public void clickAlertPopup()
	{
		driver.findElement(alertbtn).click();
		
	}
	

	public void clickTimerPopup()
	{
		driver.findElement(timerAlert).click();
		
	}
	public void clickConfirmAlertPopup()
	{
		driver.findElement(confirmAlert).click();
		
	}
	public void clickPromptAlertPopup()
	{
		driver.findElement(promptAlert).click();
		
	}
	public boolean isAlertPresent() {
		
		try {
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public String getAlertPopupMsg() {
		
		
			Alert alert=driver.switchTo().alert();
			String text=alert.getText();
			alert.accept();
		
		return text;
	}
	public String getTimerAlertPopopMsg() {

			driver.switchTo().alert();
			Alert alert=driver.switchTo().alert();
			String text=alert.getText();
			alert.accept();
		return text;
	}
	public String getConfirmAlertPopopMsg() {
			driver.switchTo().alert();
			Alert alert=driver.switchTo().alert();
			String text=alert.getText();
		return text;
	}
	public String getConfirmAlertSuccesfullMsg() {

			Alert alert=driver.switchTo().alert();
			alert.accept();
		String msg=driver.findElement(confirmTextSuceesMsg).getText();
		return msg;
	}
	public String getPromptAlertPopopMsg() {
			Alert alert=driver.switchTo().alert();
			String text=alert.getText();
		return text;
	}

	public String getPromptAlertInputText() {
			Alert alert=driver.switchTo().alert();
			alert.sendKeys("I am Nagbhushan");
			alert.accept();
		return driver.findElement(promptTextSuceesMsg).getText();
	}
}
