package abstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Abstractcomponent {
	
	WebElement FooterPath;
	WebDriver driver;
	public Abstractcomponent(WebDriver driver,By FooterPath) {
		this.FooterPath=driver.findElement(FooterPath);
		this.driver=driver;
	}
	public WebElement findElement(By Flights) {
		 return FooterPath.findElement(Flights);
	}
	public List<WebElement> findElements(By Flights) {
		 return FooterPath.findElements(Flights);
	}
	public void waitfortheelementtoappear(By findby) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}

}
