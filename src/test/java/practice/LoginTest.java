package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	
	 @DataProvider(name = "loginData")
	    public Object[][] loginData() {
	        // Provide the full path to your Excel file and the sheet name
	        return ExcelUtils.getExcelData("path/to/your/excel.xlsx", "Sheet1");
	    }

	    @Test(dataProvider = "loginData")
	    public void testLogin(String username, String password) {
	        // Set up WebDriver (ensure chromedriver is set in your system path or specify its location)
	        WebDriver driver = new ChromeDriver();
	        try {
	            driver.get("http://example.com/login");

	            // Enter username and password retrieved from Excel
	            driver.findElement(By.id("username")).sendKeys(username);
	            driver.findElement(By.id("password")).sendKeys(password);
	            driver.findElement(By.id("loginButton")).click();

	            // Add assertions here to validate login success/failure
	        } finally {
	            driver.quit();
	        }
	    }

}
