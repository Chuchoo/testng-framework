package MavenizedTestNGFramewok;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SimpleSearchExample {
	
	private WebDriver driver;
	
	@BeforeSuite
	private void initDriver() throws Exception{
		System.out.println("The firefox browser is starting.");
		driver = new FirefoxDriver();				
	}
	@Test
	public void SearchInGoogle(){
		final String searchTerm = "TestNG";
		driver.get("http://google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(searchTerm);
		element.submit();
		WebElement searchelement = driver.findElement(By.name("btnG"));
		searchelement.click();
		System.out.println(driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d) {
				System.out.println("Title of the page until expected page title is met " + d.getTitle());
				return d.getTitle().toLowerCase()
						.startsWith(searchTerm.toLowerCase());				
			}
		});
		
		System.out.println("Got " +searchTerm+ " Results.");
		
	}
	@AfterSuite
	public void quitDriver(){
		driver.quit();
	}
	
	
}



