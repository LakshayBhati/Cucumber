package Definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition_OrangeHRM {
	
	WebDriver W;
	String url = "https://opensource-demo.orangehrmlive.com";

	@Given("I should be in the Login page of OrangeHRM")
	public void i_should_be_in_the_login_page_of_orange_hrm() {
	    WebDriverManager.chromedriver().setup();
	    W = new ChromeDriver();
	    W.get(url);
	}
	
	@When("Enter Name")
	public void enter_name() {
	   W.findElement(By.id("txtUsername")).sendKeys("Admin");
	}
	
	@When("Enter Password")
	public void enter_password() {
		W.findElement(By.id("txtPassword")).sendKeys("admin123");
	}
	
	@When("Click on LoginButton")
	public void click_on_login_button() {
		W.findElement(By.id("btnLogin")).click();
	}
	
	@When("Login Successfull")
	public void login_successfull() {
	   if(W.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/dashboard"))
	   {
		   System.out.println("Logged In Successfully!");
	   }
	}
	
	@When("Logout")
	public void logout() throws InterruptedException {
	    Thread.sleep(2000);
	    W.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		W.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();
	}
	
	@Then("Logout Successfull")
	public void logout_successfull() {
	   if(W.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/auth/login"))
	   {
		   System.out.println("Logged Out Successfully!");
		   W.close();
	   }
	}
}
