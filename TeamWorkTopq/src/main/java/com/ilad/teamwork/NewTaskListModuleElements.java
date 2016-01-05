package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTaskListModuleElements extends PageElements {
	
	@FindBy(id = "btnCreateTaskList")
	private WebElement addThisTaskListButton;
	
	//Constructor
	public NewTaskListModuleElements(WebDriver driver_, ActionBot actionBot_) {
		driver = driver_;
		actionBot = actionBot_;
		PageFactory.initElements(driver, this);
	}
	
	public void sendKeysToNewTaskListNameTextBox(String newTaskListName) {
		By newTaskListNameTextBox = By.id("newTaskListName");
		actionBot.sendKeysToTextBox(newTaskListNameTextBox, newTaskListName);
	}
	
	public TasksPageElements clickOnAddThisTaskListButtonAndPassToTasksPageElements() {
		actionBot.clickOnButton(addThisTaskListButton);
		return new TasksPageElements(driver, actionBot);
	}
}
