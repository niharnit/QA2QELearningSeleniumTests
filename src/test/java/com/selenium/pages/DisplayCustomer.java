package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DisplayCustomer {

	WebDriver driver;
	
	public DisplayCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}
	
	@FindBy (how=How.XPATH, xpath="/html/body/h2")
	WebElement Title;
	
	@FindBy (how=How.XPATH, xpath="/html/body/table/tbody/tr[1]/td[2]")
	WebElement DisplayName;
	
	@FindBy (how=How.XPATH, xpath="/html/body/table/tbody/tr[2]/td[2]")
	WebElement DisplayAge;
	
	@FindBy (how=How.XPATH, xpath="/html/body/table/tbody/tr[3]/td[2]")
	WebElement DisplayAddress;
	
	@FindBy (how=How.XPATH, xpath="/html/body/table/tbody/tr[4]/td[2]")
	WebElement DisplayPhone;
	
	@FindBy (how=How.XPATH, xpath="/html/body/table/tbody/tr[5]/td[2]")
	WebElement DisplayEmail;
	
	
	public String getTitle() {
		String title = Title.getText();
		return title;
	}
	
	public String getName() {
		String Name = DisplayName.getText();
		return Name;
	}
	
	public String getAge() {
		String age = DisplayAge.getText();
		return age;
	}
	
	public String getEmail() {
		String email = DisplayEmail.getText();
		return email;
	}
	
	public String getAddress() {
		String address = DisplayAddress.getText();
		return address;
	}
	
	public String getPhoneNumber() {
		String phone = DisplayPhone.getText();
		return phone;
	}
	
}
