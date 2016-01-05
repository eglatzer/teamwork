package com.ilad.teamwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ActionBot {
	
	WebDriver driver;
	
	//Constructor
	public ActionBot(WebDriver driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}
	
	protected void clickOnButton(By button) {
		driver.findElement(button).click();
	}
	
	protected void clickOnButton(WebElement button) {
		button.click();
	}
	
	protected void submitOnButton(By button) {
		driver.findElement(button).submit();
	}
	
	protected void submitOnButton(WebElement button) {
		button.click();
	}
		
	protected void sendKeysToTextBox(By textBox, String keys) {
		driver.findElement(textBox).sendKeys(keys);
	}
	
	protected void sendKeysToTextBox(WebElement textBox, String keys) {
		textBox.sendKeys(keys);
	}
	
	protected void selectInSelectBox(By selectBox, String selection) {
		new Select(driver.findElement(selectBox)).selectByVisibleText(selection);
	}
	
	protected void selectInSelectBox(WebElement selectBox, String selection) {
		new Select(selectBox).selectByVisibleText(selection);
	}
	
	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	protected List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
}
