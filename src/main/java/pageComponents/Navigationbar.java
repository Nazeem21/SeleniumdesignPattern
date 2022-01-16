package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.Abstractcomponent;

public class Navigationbar extends Abstractcomponent{
	By Flights=By.cssSelector("a[title='Flights']");
	By links=By.tagName("a");
	public Navigationbar(WebDriver driver, By FooterPath) {
		super(driver, FooterPath);
		// TODO Auto-generated constructor stub
	}

public String toselectflight() {
	return findElement(Flights).getAttribute("class");
	//driver.findElement(Flights);
}
public int getlinks() {
	return findElements(links).size();
}
}
