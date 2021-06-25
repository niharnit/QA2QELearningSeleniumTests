package com.selenium.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.CustomerForm;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;

public class TestCustomerForm extends DriverSetup {
	
	WebDriver driver;
	CustomerForm customerForm;
	public static String blankErrtxt;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
		customerForm = new CustomerForm(driver);
		
	}
	
	
	@Test(dataProvider="customerInvalid")
	public void testInvalidCustomerDetails (String customerName,String age,String address,String phoneNumber,String email)
	{
		
		customerForm.setCustomerName(customerName);
		customerForm.setAge(age);
		customerForm.setAddress(address);
		customerForm.setPhoneNumber(phoneNumber);
		customerForm.setEmail(email);
	
		blankErrtxt = customerForm.getErrorMessage();
		Reporter.log(blankErrtxt);
		assertEquals(blankErrtxt, "phoneNumber cannot be blank");
	}

	@DataProvider (name="customerInvalid")
	public Object[][] getExcelData() throws Exception{
		
		Object[][] arrayObject = ExcelUtils.readExcelData("customer_invalid");
		return arrayObject;
	}
	
	@AfterClass
	public void closeBrowser() {
		
		driver.close();
		
	}
	
}
