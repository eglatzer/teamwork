package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPageElements extends PageElements {
	
	@FindBy(xpath = "//ul[@class='options']/descendant::span[@class='btn-addIcon']")
	private WebElement addTaskListButton;
		
	//Constructor
	public TasksPageElements(WebDriver driver_, ActionBot actionBot_) {
		driver = driver_;
		actionBot = actionBot_;
		PageFactory.initElements(driver, this);
	}

	//Getter
	public WebDriver getDriver() {
		return driver;
	}

	//Setter
	public void setDriver(WebDriver driver_) {
		driver = driver_;
	}
	
	public NewTaskListModuleElements clickOnAddTaskListButtonAndPassToNewTaskListModule() {
		actionBot.clickOnButton(addTaskListButton);
		return new NewTaskListModuleElements(driver, actionBot);
	}
	
	public SpecificTaskListPageElements clickOnSpecificTaskListAndPassToItsPage(String name) {
		By specificTaskListPage = By.xpath
				("//span[contains(text(), '" + name + "')]");
		actionBot.clickOnButton(specificTaskListPage);
		return new SpecificTaskListPageElements(driver, actionBot);
	}
	
	public boolean isThisTaskListExist(String name) {
		By thisTaskList = By.xpath("//span[contains(text(), '" + name + "')]");
		return !actionBot.findElements(thisTaskList).isEmpty();
	}
}
