package windowhandling;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OpenMultipleWindows {
	@Test
	public void openmultiplewindows() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentId = driver.getWindowHandle();
		System.out.println("parent id is :" + parentId);
		WebElement openWindow = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openWindow);
		driver.findElement(By.xpath("//button[@id='newWindowsBtn']")).click();
		Set<String> bothHandles = driver.getWindowHandles();
		for (String childId : bothHandles) {
			if (!childId.equals(parentId)) {
				driver.switchTo().window(childId);

				String title = driver.getTitle();
				if (title.equals("XPath Practice - H Y R Tutorials")) {
					WebElement dropdown = driver.findElement(By.id("selectnav2"));
					Select sel=new Select(dropdown);
					sel.selectByVisibleText("Home");
					driver.switchTo().window(parentId);
					
					String tt = driver.getTitle();
					System.out.println(tt);
					System.out.println("I am in main page");
				
					
					
				}

			}

		}

	}

}
