package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.Abstractcomponent;

public class Footernavigation extends Abstractcomponent{
	WebDriver driver;
	
By Flights=By.cssSelector("a[title='Flights']");
By links=By.tagName("a");
public Footernavigation(WebDriver driver, By FooterPath) {
	// TODO Auto-generated constructor stub
	super(driver,FooterPath);
}

public String toselectflight() {
	return findElement(Flights).getAttribute("class");
	//driver.findElement(Flights);
}
public int getlinks() {
return findElements(links).size();
}
}
