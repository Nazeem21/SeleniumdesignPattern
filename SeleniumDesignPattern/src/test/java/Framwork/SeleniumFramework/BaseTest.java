package Framwork.SeleniumFramework;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
public WebDriver initializedriver() {
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	return driver;
}
public List<HashMap<String, String>> getjsondata(String jsonpath) throws IOException {
	//Object mapper is from jackson databind and core dependency, used to person actions on json files
	ObjectMapper mapper= new ObjectMapper();
	//Using File utils to read the file and convert to string
	String jsoncontent=FileUtils.readFileToString(new File(jsonpath),StandardCharsets.UTF_8);//to overcome the exception we use standard charsets and also to eliminate unstablilty
	//One time activity,Type reference is used to convert json to list of hashmap
	 List<HashMap<String, String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String, String>>>(){});
	return data;
}
}
