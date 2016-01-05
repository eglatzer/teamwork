package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements extends PageElements {
	
	By loginButton = By.id("ordLoginSubmitBtn");
	
	//Constructor
	public LoginPageElements(WebDriver driver_, ActionBot actionBot_) {
		driver = driver_;
		actionBot = actionBot_;
		PageFactory.initElements(driver, this);
	}

	public void sendKeysToUserNameTextBox(String userName) {
		By userNameTextBox = By.id("userLogin");
		actionBot.sendKeysToTextBox(userNameTextBox, userName);
	}

	public void sendKeysToUserPasswordTextBox(String userPassword) {
		By userPasswordTextBox = By.id("password");
		actionBot.sendKeysToTextBox(userPasswordTextBox, userPassword);
	}
	
	public OverviewPageElements clickOnLoginButtonAndPassToOverviewPage() {
		actionBot.clickOnButton(loginButton);
		return new OverviewPageElements(driver, actionBot);
	}
	
	public void clickOnLoginButtonAndStayAtLoginPage() {
		actionBot.clickOnButton(loginButton);
	}
}
