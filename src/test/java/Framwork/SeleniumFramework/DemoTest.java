package Framwork.SeleniumFramework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainpageObject.HomePage;
import pageComponents.MultiTrip;
import pageComponents.RoundTrip;

public class DemoTest extends BaseTest{
	WebDriver driver;
	HomePage homepage;
	//HashMap<String, String>reservationdetails= new HashMap<String, String>();
	//HashMap<String, String>reservationdetails1= new HashMap<String, String>();
	List<HashMap<String, String>>l;
	
	
	
	@BeforeTest
	public void setup() {
		driver=initializedriver();
		 homepage= new HomePage(driver);
	}
	//By sectionelement=By.id("flightSearchContainer");
	@Test(dataProvider = "getdata")
	//public void flighttest() {
	public void flighttest(HashMap<String, String>reservationdetails) {
		
	/*WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();*/
		
		//SRP-Single responsibility pattern
		homepage.gotohomepage();
		System.out.println(homepage.getfooternavigation().toselectflight());
		System.out.println(homepage.getnavigationbar().toselectflight());
		System.out.println(homepage.getfooternavigation().getlinks());
		System.out.println(homepage.getnavigationbar().getlinks());
		
		//SDP-Strategy design pattern
		//homepage.setBookingstrategy(new MultiTrip(driver, sectionelement));//similar to webdriver driver = new chromdriver();
		//homepage.setBookingstrategy(new RoundTrip(driver, sectionelement));
		//homepage.checkAvail( "CJB", "HYD");
		
		//FDP-Factory design Pattern
		//homepage.setBookingstrategy("multitrip");
		//homepage.checkAvail( "CJB", "HYD");
		
		//execute around method pattern
		
		//Using hashmap to pass more arguments to methods
		homepage.setBookingstrategy("roundtrip");
		/*HashMap<String, String>reservationdetails= new HashMap<String, String>();
		reservationdetails.put("origin", "CJB");
		reservationdetails.put("destination", "HYD");
		reservationdetails.put("origin1", "BLR");
		reservationdetails.put("destination1", "AMD");*/
		homepage.checkAvail(reservationdetails);
		
		//Hashmap with dataprovider
		
		}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	@DataProvider
	public Object[][] getdata() throws IOException{
		
		/*reservationdetails.put("origin", "CJB");
		reservationdetails.put("destination", "HYD");
		reservationdetails.put("origin1", "BLR");
		reservationdetails.put("destination1", "AMD");
		
		reservationdetails1.put("origin", "MAA");
		reservationdetails1.put("destination", "BLR");
		reservationdetails1.put("origin1", "HYD");
		reservationdetails1.put("destination1", "CJB");
		
		l.add(reservationdetails);
		l.add(reservationdetails1);*/
		
		
		//reading directly from jsonfile using jackson binding and core dependencies
		l=getjsondata(System.getProperty("user.dir")+"//src//test//java//dataLoads//addplace.json");
		Object[][]data= {
				{l.get(0)},{l.get(1)}
		};
		return data;  
		}
	
	}

