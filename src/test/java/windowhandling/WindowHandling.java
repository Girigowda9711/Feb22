package windowhandling;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandling {
	@Test
	public void handlingwindow() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentId = driver.getWindowHandle();
		System.out.println("parent id is :" + parentId);
		WebElement openWindow = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openWindow);
		openWindow.click();
		Set<String> bothHandles = driver.getWindowHandles();
		
		for(String child:bothHandles) {
			if(!child.equals(parentId)) {
				driver.switchTo().window(child);
				js.executeScript("window.scrollBy(0,500)");
				driver.switchTo().window(parentId);
				System.out.println(driver.getTitle());
				System.out.println("I am in parent window");
				break;
				
				
			}
			
			
		}

	}

}
