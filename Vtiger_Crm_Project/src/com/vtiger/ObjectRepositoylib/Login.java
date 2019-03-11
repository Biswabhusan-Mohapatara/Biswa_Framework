package com.vtiger.ObjectRepositoylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	/*utilization through Buisness Library*/
	public void loginToApp(String username, String password) {
		userNameEdt.sendKeys("admin");
		passwordEdt.sendKeys("manager");
		submitBtn.click();
	}
}
