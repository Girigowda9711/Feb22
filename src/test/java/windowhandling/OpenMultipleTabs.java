package windowhandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenMultipleTabs {
	@Test
	public void openmultipletabs() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentId = driver.getWindowHandle();
		System.out.println("parent id is :" + parentId);
		WebElement openmultipletabs = driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openmultipletabs);
		openmultipletabs.click();
		Set<String> bothHandles = driver.getWindowHandles();
		Iterator<String> Handle = bothHandles.iterator();
		
		while(Handle.hasNext()) {
			String childId = Handle.next();
			driver.switchTo().window(childId);
			
			String title = driver.getTitle();
			if(title.equals("AlertsDemo - H Y R Tutorials")) {
				driver.findElement(By.xpath("//button[@id='alertBox']")).click();
				driver.switchTo().alert().accept();
				driver.switchTo().window(parentId);
				System.out.println(driver.getTitle());
				System.out.println("I am in main page");
				break;
				
			}
			
		}
		
	}

}
