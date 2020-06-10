package example;		

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class NewTest {		
	    private WebDriver driver;		
		@Test				
		public void testEasy() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait=new WebDriverWait(driver, 20);
			driver.get("http://35.243.134.198:9090/petclinic/");  
			String title = driver.getTitle();			
			System.out.println(">>>>>>"+title);
			Assert.assertTrue(title.contains("a Spring Framework"));
			clickLinkByHref("/petclinic/vets.html");
			clickLinkByHref("/petclinic/vets.json");

		}

		public String returnTextFromBody(String text) {
			List<WebElement> pre = driver.findElements(By.tagName("pre"));
			Iterator<WebElement> i = pre.iterator();

			while(i.hasNext()) {
				WebElement anchor = i.next();
				if(anchor.getText().contains(text)) {
				return anchor.getText();
				}
			}

			return null;
		}


		public void clickLinkByHref(String href) {
			List<WebElement> anchors = driver.findElements(By.tagName("a"));
			Iterator<WebElement> i = anchors.iterator();

			while(i.hasNext()) {
				WebElement anchor = i.next();
				if(anchor.getAttribute("href").contains(href)) {
					anchor.click();
					break;
				}
			}
		}

		@BeforeTest
		public void beforeTest() {	
			//File file = new File("C:\\Users\\Mitesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			//System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mitesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
			//driver = new ChromeDriver();
			File file = new File("C:\\Test\\geckodriver.exe");
			System.out.println(file.getAbsolutePath());
			System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
			driver = new FirefoxDriver();


			 
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	
