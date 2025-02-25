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

public class OpenMultipleTabsAndWindows {
	@Test
	public void openmultipletabsandwindows() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentId = driver.getWindowHandle();
		System.out.println("parent id is :" + parentId);
		WebElement openmultipletabsandwindow = driver.findElement(By.xpath("//button[@id='newTabsWindowsBtn']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openmultipletabsandwindow);
		openmultipletabsandwindow.click();
		Set<String> bothHandles = driver.getWindowHandles();
		Iterator<String> Handle = bothHandles.iterator();
		
		while(Handle.hasNext()) {
			String child = Handle.next();
			driver.switchTo().window(child);
			
			String title = driver.getTitle();
			if(title.equals("Contact Me - H Y R Tutorials")) {
				js.executeScript("window.scrollBy(0,1000)");
				driver.switchTo().window(parentId);
				System.out.println(driver.getTitle());
				System.out.println("I am in main page");
				break;
			}
			
			
			
		}
		
		
		
		
		
	}

}
