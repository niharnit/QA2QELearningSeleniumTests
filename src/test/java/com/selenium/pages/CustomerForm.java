package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerForm {
	
	WebDriver driver;
	public CustomerForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy (how=How.NAME, name="cname")
	WebElement CustomerName;
	
	@FindBy (how=How.NAME, name="age")
	WebElement Age;
	
	@FindBy (how=How.NAME, name="address")
	WebElement Address;
	
	@FindBy (how=How.NAME, name="phonenumber")
	WebElement PhoneNumber;
	
	@FindBy (how=How.NAME, name="email")
	WebElement Email;
	
	@FindBy (how=How.XPATH, xpath="//*[@id='submit']")
	WebElement Submit;
	
	@FindBy (how=How.XPATH, xpath="//*[@id='message']")
	WebElement ErrMsg;
	
	public void setCustomerName(String cName) {
		CustomerName.sendKeys(cName); 
	}
	
	public void setAge(String age) {
		Age.sendKeys(age); 
		}
	
	public void setAddress(String address) {
		Address.sendKeys(address); 
		}
	
	public void setPhoneNumber(String phonenumber) {
		PhoneNumber.sendKeys(phonenumber); 
		}
	
	public void setEmail(String email) {
		Email.sendKeys(email); 
		}
	
	public String getErrorMessage() {
		String txt = ErrMsg.getText();
		return txt;
		}
	
	public void submitForm() {
		Submit.click();
	}
	
}
