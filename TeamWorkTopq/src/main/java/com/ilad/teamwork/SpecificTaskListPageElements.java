package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecificTaskListPageElements extends PageElements {
	
	@FindBy(xpath = "//button[@class='btn btn-success js-add-task btn-lg']")
	private WebElement addTheFirstTaskButton;
	
	@FindBy(xpath = "//li/child::button[@class='btn btn-default btn-hasIcon tipped']")
	private WebElement optionsButton;
	
	//Constructor
	public SpecificTaskListPageElements(WebDriver driver_, ActionBot actionBot_) {
		driver = driver_;
		actionBot = actionBot_;
		PageFactory.initElements(driver, this);
	}

	public FirstTaskModuleElements clickOnAddTheFirstTaskButtonAndPassToFirstTaskModule() {
		actionBot.clickOnButton(addTheFirstTaskButton);
		return new FirstTaskModuleElements(driver, actionBot);
	}
	
	public int sizeOfThisTaskList() {
		By tasksInThisTaskList = By.xpath("//span[@class='taskName']");
		return actionBot.findElements(tasksInThisTaskList).size();
	}
	
	public void clickOnOptionsButton() {
		actionBot.clickOnButton(optionsButton);
	}
	
	public void clickOnDeleteButton() {
		String id = getIdOfThisTaskList();
		By deleteButton = By.xpath
				("//a[@href='javascript:tw.DeleteTaskList( " + id + " , true )']");
		actionBot.clickOnButton(deleteButton);
	}
	
	private String getIdOfThisTaskList() {
		By locatonOfWebElementWhichContainsTheId =
				By.xpath("//span[@class='mid']/../..");
		WebElement webElementWhichContainsTheId =
				actionBot.findElement(locatonOfWebElementWhichContainsTheId);
		String stringWhichContainsTheId =
				webElementWhichContainsTheId.getAttribute("id");
		return stringWhichContainsTheId.
				substring(stringWhichContainsTheId.indexOf('4'));
	}
}
