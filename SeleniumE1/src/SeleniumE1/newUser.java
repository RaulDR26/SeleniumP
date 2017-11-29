package SeleniumE1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.Scanner;

public class newUser {
	
	private static Scanner select;
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
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
				WebElement singon = driver.findElement(By.linkText("REGISTER"));
				singon.click();	

				//New credentials
				WebElement fname = driver.findElement(By.name("firstName"));
				fname.sendKeys("Raul");
				WebElement lname = driver.findElement(By.name("lastName"));
				lname.sendKeys("Dzul");
				WebElement phone = driver.findElement(By.name("phone"));
				phone.sendKeys("9998765432");
				WebElement email = driver.findElement(By.id("userName"));
				email.sendKeys("raul@mail.com");
				WebElement address = driver.findElement(By.name("address1"));
				address.sendKeys("home #566");
				WebElement city = driver.findElement(By.name("city"));
				city.sendKeys("Merida");
				WebElement state = driver.findElement(By.name("state"));
				state.sendKeys("Yucatan");
				WebElement code = driver.findElement(By.name("postalCode"));
				code.sendKeys("97455");
				WebElement user = driver.findElement(By.name("email"));
				user.sendKeys("TRaul");
				WebElement pass = driver.findElement(By.name("password"));
				pass.sendKeys("testing");
				WebElement pass2 = driver.findElement(By.name("confirmPassword"));
				pass2.sendKeys("testing");	
				
				//Submit
				WebElement submit = driver.findElement(By.name("register"));
				submit.submit();
				System.out.println("User created succesfully");
				Thread.sleep(4000);
				
				//Verification
				WebElement login = driver.findElement(By.linkText("sign-in"));
				login.click();
				                                                                                                                                                                                                                                               
				//Credentials
				WebElement fUser = driver.findElement(By.name("userName"));
				fUser.sendKeys("TRaul");
				WebElement fPass = driver.findElement(By.name("password"));
				fPass.sendKeys("testing");
				
				WebElement enter = driver.findElement(By.name("login"));
				enter.click();
		}	
	}
