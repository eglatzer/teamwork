package com.ilad.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FirstTaskModuleElements extends PageElements {
	
	//Constructor
	public FirstTaskModuleElements(WebDriver driver_, ActionBot actionBot_) {
		driver = driver_;
		actionBot = actionBot_;
		PageFactory.initElements(driver, this);
	}
	
	public void sendKeysToTaskNameTextBox(String taskName) {
		By taskNameTextBox = By.xpath("//div[@class='bootstrap-tagsinput']/"
				+ "descendant::input[@placeholder='What needs to be done?']");
		actionBot.sendKeysToTextBox(taskNameTextBox, taskName);
	}
	
	public void selectWhoShouldDoThisInTaskAssignedToUserIdTextBox(String who) {
		By taskAssignedToUserIdTextBox = By.name("taskAssignedToUserId");
		actionBot.selectInSelectBox(taskAssignedToUserIdTextBox, who);
	}
	
	public void clickOnSaveMyChangesButton() {
		By saveMyChangesButton =
				By.xpath("//div[@class='formFooter']/descendant::input");
		actionBot.clickOnButton(saveMyChangesButton);
	}
	
	public MilestonesPageElements clickOnMilestonesTabAndPassToMilestonesPage() {
		By milestonesTab = By.id("tab_milestones");
		actionBot.clickOnButton(milestonesTab);
		return new MilestonesPageElements(driver, actionBot);
	}
}
