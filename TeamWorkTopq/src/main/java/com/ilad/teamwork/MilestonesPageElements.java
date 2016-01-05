package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MilestonesPageElements extends PageElements {
	
	//Constructor
	public MilestonesPageElements(WebDriver driver_, ActionBot actionBot_) {
		driver = driver_;
		actionBot = actionBot_;
		PageFactory.initElements(driver, this);
	}

	public TasksPageElements clickOnTasksTabAndPassToTasksPage() {
		By tasksTab = By.id("tab_tasks");
		actionBot.clickOnButton(tasksTab);
		return new TasksPageElements(driver, actionBot);
	}
}
