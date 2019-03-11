package com.vtiger.ObjectRepositoylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement userImage;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;
	
	@FindBy(linkText="Organizations")
	private WebElement  organizations;
	
	public void navigateToTaskPage() {
		organizations.click();
	}
	
	public void signout() {
		signout.click();
	}
}
