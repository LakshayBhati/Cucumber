package Definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDefinition_SkillRary {
	
	WebDriver W;
	String url = "https://demoapp.skillrary.com/login.php?type=login";
	
	@Given("I should open the browser and navigate to the Skillrary app")
	public void i_should_open_the_browser_and_navigate_to_the_skillrary_app() {
		WebDriverManager.chromedriver().setup();
		W = new ChromeDriver();
		W.get(url);
	}
	
	@When("Enter Username {string}")
	public void enter_username(String user) {
	   W.findElement(By.name("email")).sendKeys(user);
	}
	
	@When("Enter Password {string}")
	public void enter_password(String pwd) {
	    W.findElement(By.name("password")).sendKeys(pwd);
	}
	
	@When("Click on the LoginButton")
	public void click_on_the_login_button() {
	   W.findElement(By.className("login_Btn")).click();
	}
	
	@Then("I should see the username as {string}")
	public void i_should_see_the_username_as(String username) throws InterruptedException {
		if(W.getTitle().equalsIgnoreCase("SkillRary Courses"))
		{
			String user = W.findElement(By.xpath("//div[@class='navbar-custom-menu']/ul/li[2]/a[1]/span")).getText();
			Assert.assertEquals(user, username);
		}
		else
		{
			if(W.getTitle().equalsIgnoreCase("SkillRary Ecommerce"))
			{
				String admin = W.findElement(By.xpath("//*[@class='pull-left info']/p")).getText();
				Assert.assertEquals(admin, username);
			}
		}
			
		
//	   W.findElement(By.xpath("//div[@class='navbar-custom-menu']/ul/li[2]/a[1]/span")).getText();
//	   System.out.println(W.findElement(By.xpath("//div[@class='navbar-custom-menu']/ul/li[2]/a[1]/span")).getText());
	   Thread.sleep(2000);
	   W.close();
	}
	
//	@Then("I should see the admin as {string}")
//	public void i_should_see_the_admin_as(String string) {
//		String admin = W.findElement(By.xpath("//*[@class='pull-left info']/p")).getText();
//		W.close();
//	}
	
	@Then("I should navigate the {string}")
	public void i_should_navigate_the(String string) {
		String invalid = W.findElement(By.xpath("//*[@class='registerDiv']/input")).getAttribute("value");
	    Assert.assertEquals(invalid, string);
	    W.close();
	}
}
