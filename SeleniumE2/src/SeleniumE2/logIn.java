package SeleniumE2;

import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class logIn {
	
	static WebDriver driver;
	private static Scanner select;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Wich browser do you want to use?");
		System.out.println("1 = FireFox");
		System.out.println("2 = Chrome");
		System.out.println("3 = Internet Explorer");
		System.out.print("Choose:");
		select = new Scanner(System.in);
		int option = select.nextInt();
		
		System.setProperty("webdriver.chrome.driver", "chrome\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "gecko\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "IE\\IEDriverServer.exe");
		
		switch(option) {
			case 1: 
				//Firefox
				driver = new FirefoxDriver();
				break;
				
			case 2:
				//Chrome
				driver = new ChromeDriver();
				break;
			case 3:
				//Internet Explorer
				driver = new InternetExplorerDriver();
				break;
			default:
				System.out.println("Invalid option");
				System.exit(0);
		}
				driver.get("http://www.newtours.demoaut.com");	
		//Enter sign on  page
		WebElement singon = driver.findElement(By.linkText("SIGN-ON"));
		singon.click();
		
		//Credentials
		WebElement user = driver.findElement(By.name("userName"));
		user.sendKeys("mercury");
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("mercury");
		
		WebElement enter = driver.findElement(By.name("login"));
		enter.submit();
		Thread.sleep(3000);
		
		// Flight Finder
		Select passcount = new Select(driver.findElement(By.name("passCount")));
		passcount.selectByValue("2");
		Select fromport = new Select(driver.findElement(By.name("fromPort")));
		fromport.selectByValue("London");
		Select frommonth = new Select(driver.findElement(By.name("fromMonth")));
		frommonth.selectByValue("1");
		Select fromday = new Select( driver.findElement(By.name("fromDay")));
		fromday.selectByValue("10");
		Select toport = new Select(driver.findElement(By.name("toPort")));
		toport.selectByValue("Acapulco");
		Select tomonth = new Select(driver.findElement(By.name("toMonth")));
		tomonth.selectByValue("9");
		Select today = new Select( driver.findElement(By.name("toDay")));
		today.selectByValue("15");
		
		List<WebElement> radioclass = driver.findElements(By.name("servClass"));
		int rSize = radioclass.size();
		for(int i = 0; i < rSize; i++) {
			String rValue = radioclass.get(i).getAttribute("value");
			if (rValue.equalsIgnoreCase("Business")) {
				radioclass.get(i).click();
				break;
			}
		}
		
		Select object = new Select(driver.findElement(By.name("airline")));
		object.selectByVisibleText("Unified Airlines");
		
		WebElement continue1 = driver.findElement(By.name("findFlights"));
		continue1.submit();
		Thread.sleep(3000);
		
		//Select Flight
		List<WebElement> out = driver.findElements(By.name("outFlight"));
		int oSize = out.size();
		for(int r = 0; r < oSize; r++) {
			String oValue = out.get(r).getAttribute("value");
			if (oValue.equalsIgnoreCase("Blue Skies Airlines$361$271$7:10")) {
				out.get(r).click();
				break;
			}
		}
		
		List<WebElement> in = driver.findElements(By.name("inFlight"));
		int iSize = in.size();
		for(int j = 0; j < iSize; j++) {
			String iValue = in.get(j).getAttribute("value");
			if (iValue.equalsIgnoreCase("Unified Airlines$633$303$18:44")) {
				in.get(j).click();
				break;
			}
		}
		
		WebElement continue2 = driver.findElement(By.name("reserveFlights"));
		continue2.submit();
		Thread.sleep(2000);
		
		//Book a Flight
		WebElement passf = driver.findElement(By.name("passFirst0"));
		passf.sendKeys("Raul");
		WebElement passl = driver.findElement(By.name("passLast0"));
		passl.sendKeys("Dzul");
		Select meal = new Select(driver.findElement(By.name("pass.0.meal")));
		meal.selectByValue("KSML");
		WebElement passf1 = driver.findElement(By.name("passFirst1"));
		passf1.sendKeys("Jack");
		WebElement passl1 = driver.findElement(By.name("passLast1"));
		passl1.sendKeys("Herr");
		Select meal1 = new Select(driver.findElement(By.name("pass.1.meal")));
		meal1.selectByValue("VGML");
		
		Select card = new Select(driver.findElement(By.name("creditCard")));
		card.selectByValue("IK");
		WebElement cnumber = driver.findElement(By.name("creditnumber"));
		cnumber.sendKeys("56463184684");
		Select ccMonth = new Select(driver.findElement(By.name("cc_exp_dt_mn")));
		ccMonth.selectByVisibleText("07");
		Select ccYear = new Select(driver.findElement(By.name("cc_exp_dt_yr")));
		ccYear.selectByVisibleText("2007");
		WebElement ccfname = driver.findElement(By.name("cc_frst_name"));
		ccfname.sendKeys("Raul");
		WebElement ccmname = driver.findElement(By.name("cc_mid_name"));
		ccmname.sendKeys("A");
		WebElement cclname = driver.findElement(By.name("cc_last_name"));
		cclname.sendKeys("Dzul");
		
		WebElement billaddress1 = driver.findElement(By.name("billAddress1"));
		billaddress1.sendKeys("Testing Bill Address 1");
		WebElement billaddress2 = driver.findElement(By.name("billAddress2"));
		billaddress2.sendKeys("Testing Bill Address 2");
		WebElement billcity = driver.findElement(By.name("billCity"));
		billcity.sendKeys("Merida");
		WebElement billstate = driver.findElement(By.name("billState"));
		billstate.sendKeys("Yucatan");
		WebElement billzip = driver.findElement(By.name("billZip"));
		billzip.sendKeys("98745");
		Select billcountry = new Select(driver.findElement(By.name("billCountry")));
		billcountry.selectByValue("132");
		
		WebElement deladdress1 = driver.findElement(By.name("delAddress1"));
		deladdress1.sendKeys("Testing Delivery Address 1");
		WebElement deladdress2 = driver.findElement(By.name("delAddress2"));
		deladdress2.sendKeys("Testing Delivery Address 2");
		WebElement delcity = driver.findElement(By.name("delCity"));
		delcity.sendKeys("Hills");
		WebElement delstate = driver.findElement(By.name("delState"));
		delstate.sendKeys("New York");
		WebElement delzip = driver.findElement(By.name("delZip"));
		delzip.sendKeys("16589");
		
		WebElement continue3 = driver.findElement(By.name("buyFlights"));
		continue3.submit();
	}
}
