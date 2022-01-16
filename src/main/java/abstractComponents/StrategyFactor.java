package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageComponents.MultiTrip;
import pageComponents.RoundTrip;

public class StrategyFactor {
WebDriver driver;
By sectionelement=By.id("flightSearchContainer");
	public StrategyFactor(WebDriver driver) {
	// TODO Auto-generated constructor stub
		this.driver=driver;
}
	public SearchFlightAvail createstratergy(String strategytype) {
		
		if(strategytype.equalsIgnoreCase("multiTrip")) {
			return new MultiTrip(driver, sectionelement);
		}if(strategytype.equalsIgnoreCase("RoundTrip")) {
			return new RoundTrip(driver, sectionelement);
		}
		return null;
	}
}
