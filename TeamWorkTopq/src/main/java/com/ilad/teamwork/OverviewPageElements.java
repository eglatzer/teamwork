package com.ilad.teamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPageElements extends PageElements {
	
	@FindBy(id = "tab_tasks")
	protected WebElement tasksTab;
	
	//Constructor
	public OverviewPageElements(WebDriver driver_, ActionBot actionBot_) {
		driver = driver_;
		actionBot = actionBot_;
		PageFactory.initElements(driver, this);
	}
	
	public TasksPageElements clickOnTasksTabAndPassToTasksPage() {
		actionBot.clickOnButton(tasksTab);
		return new TasksPageElements(driver, actionBot);
	}
}
