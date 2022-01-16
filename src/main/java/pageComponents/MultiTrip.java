package pageComponents;

import java.util.HashMap;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.Abstractcomponent;
import abstractComponents.SearchFlightAvail;

public class MultiTrip extends Abstractcomponent implements SearchFlightAvail{
	public MultiTrip(WebDriver driver, By FooterPath) {
		super(driver, FooterPath);
		// TODO Auto-generated constructor stub
	}

	private By Multicity=By.id("ctl00_mainContent_rbtnl_Trip_2");
	private By popup=By.id("MultiCityModelAlert");
	private By FromCity1=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	private By toCity1=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	private By FromCity2=By.id("ctl00_mainContent_ddl_originStation2_CTXT");
	private By toCity2=By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");
	private By datecity2=By.id("ctl00_mainContent_view_date3");
	private By search=By.id("ctl00_mainContent_btn_FindFlights");
	
	/*@Override
	public void checkAvail(String origin, String destination) {*/
		// TODO Auto-generated method stub
		/*findElement(Multicity).click();
		findElement(popup).click();*/
		/*makestateready(s->selectcity(origin));
		//selectcity(origin);
		destinationcity(destination);
		selectcity1("AMD");
		destinationcity1("COK");
		findElement(search).click();
	}*/
	public void selectcity(String origin) {
		findElement(FromCity1).click();
		findElement(By.xpath("//a[@value='"+origin+"']")).click();
	}
	public void destinationcity(String destination) {
		findElement(toCity1).click();
		findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
	}
	public void selectcity1(String origin1) {
		findElement(FromCity2).click();
		
		findElement(By.xpath("(//a[@value='"+origin1+"'])[3]")).click();
	}
	public void destinationcity1(String destination1) {
		findElement(toCity2).click();
		
		findElement(By.xpath("(//a[@value='"+destination1+"'])[4]")).click();
	}
	
	//Execute around method pattern
	public void makestateready(Consumer<MultiTrip> consumer) {
		findElement(Multicity).click();
		findElement(popup).click();
		waitfortheelementtoappear(FromCity1);
		consumer.accept(this);
		
	}
	@Override
	public void checkAvail(HashMap<String, String> reservationdetails) {
		// TODO Auto-generated method stub
		makestateready(s->selectcity(reservationdetails.get("origin")));
		//selectcity(origin);
		destinationcity(reservationdetails.get("destination"));
		selectcity1(reservationdetails.get("origin1"));
		destinationcity1(reservationdetails.get("destination1"));
		findElement(search).click();
	}
	

}
