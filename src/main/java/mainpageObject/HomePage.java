package mainpageObject;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.SearchFlightAvail;
import abstractComponents.StrategyFactor;
import pageComponents.Footernavigation;
import pageComponents.MultiTrip;
import pageComponents.Navigationbar;

public class HomePage {
	By FooterPath=By.id("traveller-home");
	By navigationpath=By.className("search-buttons-heading");
	WebDriver driver;
	SearchFlightAvail search;
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void gotohomepage() {
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
	}
	public Navigationbar getnavigationbar() {
		return  new Navigationbar(driver, navigationpath);
	}
	
	public Footernavigation getfooternavigation() {
		return new Footernavigation(driver,FooterPath);
	}
	
	//SDP-Strategy design pattern
	/*public void setBookingstrategy(SearchFlightAvail search) {
		this.search=search;
	}*/
	
	
	//FDP-Factory design Pattern
	public void setBookingstrategy(String stratergytype) {
		StrategyFactor strategyFactor= new StrategyFactor(driver);
		search=strategyFactor.createstratergy(stratergytype);
		this.search=search;
	}
	/*public void checkAvail(String origin, String destination) {
		// TODO Auto-generated method stub
		search.checkAvail(origin, destination);
	}*/
	
	//For using hashmap
	public void checkAvail(HashMap<String, String>reservationdetails) {
		// TODO Auto-generated method stub
		search.checkAvail(reservationdetails);
	}
	
	//For Core Framework maven dependencies
	public String gettitles() {
		System.out.println("Hello!first commit for jfrog");
		return driver.getTitle();
	}
}
