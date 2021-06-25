package com.selenium.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.CustomerForm;
import com.selenium.pages.DisplayCustomer;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;

public class TestDisplayCustomer extends DriverSetup {

	WebDriver driver;
	CustomerForm customerForm;
	DisplayCustomer displayCustomer;
	
	public static String titletxt;
	public static String customerNametxt;
	public static String agetxt;
	public static String addresstxt;
	public static String numbertxt;
	public static String emailtxt;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
		customerForm = new CustomerForm(driver);
		displayCustomer = new DisplayCustomer(driver);
	}
	
	@Test(dataProvider="customerValid")
	public void testValidCustomerDetails(String customerName,String age,String address,String phoneNumber,String email) 
	{
		
		customerForm.setCustomerName(customerName);
		customerForm.setAge(age);
		customerForm.setAddress(address);
		customerForm.setPhoneNumber(phoneNumber);
		customerForm.setEmail(email);
		customerForm.submitForm();
		
		titletxt = displayCustomer.getTitle();
		
		customerNametxt = displayCustomer.getName();
		String[] Name = customerNametxt.split("\\s+");
		assertEquals(Name[0], customerName);
		Reporter.log(Name[0]);
		
		agetxt = displayCustomer.getAge();
		assertEquals(agetxt, age);
		Reporter.log(agetxt);
		
		addresstxt = displayCustomer.getAddress();
		assertEquals(addresstxt, address);
		Reporter.log(addresstxt);

		numbertxt = displayCustomer.getPhoneNumber();
		assertEquals(numbertxt, phoneNumber);
		Reporter.log(numbertxt);
		
		emailtxt = displayCustomer.getEmail();
		assertEquals(emailtxt, email);
		Reporter.log(emailtxt);
		
		
	}
	
	
	@DataProvider(name="customerValid")
	public Object[][] getExcelData() throws Exception {
		
		Object[][] arrayObject = ExcelUtils.readExcelData("customer_valid");
		return arrayObject;
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
}
