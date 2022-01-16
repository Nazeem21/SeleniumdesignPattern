package pageComponents;

import java.util.HashMap;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstractComponents.Abstractcomponent;
import abstractComponents.SearchFlightAvail;

public class RoundTrip extends Abstractcomponent implements SearchFlightAvail{

	public RoundTrip(WebDriver driver, By FooterPath) {
		super(driver, FooterPath);
		// TODO Auto-generated constructor stub
	}

	private By roundtrip=By.id("ctl00_mainContent_rbtnl_Trip_1");
	private By from=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	private By checkbox=By.id("ctl00_mainContent_chk_IndArm");
	private By search=By.id("ctl00_mainContent_btn_FindFlights");
	private By To=By.id("ctl00_mainContent_ddl_destinationStation1");
	//private By returndate=By.id("ctl00_mainContent_view_date2");
	private By departdate=By.id("ctl00_mainContent_view_date1");
	
	/*@Override
	public void checkAvail(String origin, String destination) {
		// TODO Auto-generated method stub
		//findElement(roundtrip).click();
		makestateready(s->selectcity(origin));
		//selectcity(origin);
		destinationcity(destination);
		selectdate();
		findElement(checkbox).click();
		findElement(search).click();
	}*/
	public void selectdate() {
		// TODO Auto-generated method stub
		findElement(departdate).click();
		findElement(By.xpath("//a[contains(text(),'13')]")).click();
		//findElement(returndate).click();
		//findElement(By.xpath("//a[contains(text(),'14')]")).click();
	}
	public void selectcity(String origin) {
		findElement(from).click();
		findElement(By.xpath("//a[@value='"+origin+"']")).click();
	}
	public void destinationcity(String destination) {
		findElement(from).click();
		findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
	}
	
	public void makestateready(Consumer<RoundTrip>consumer) {
		findElement(roundtrip).click();
		waitfortheelementtoappear(from);
		consumer.accept(this);
	}
	public void checkAvail(String origin, String destination) {
		// TODO Auto-generated method stub
		//findElement(roundtrip).click();
		makestateready(s->selectcity(origin));
		//selectcity(origin);
		destinationcity(destination);
		selectdate();
		findElement(checkbox).click();
		findElement(search).click();
	}
	@Override
	public void checkAvail(HashMap<String, String> reservationdetails) {
		// TODO Auto-generated method stub
		makestateready(s->selectcity(reservationdetails.get("origin")));
		//selectcity(origin);
		destinationcity(reservationdetails.get("destination"));
		selectdate();
		findElement(checkbox).click();
		findElement(search).click();
	}

}
