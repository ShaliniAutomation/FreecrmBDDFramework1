package stepDefinitions;




import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {

	WebDriver driver;

@Given("^User is already on Login Page$")
public void User_is_already_on_Login_Page(){
    // Write code here that turns the phrase above into concrete actions
	
	System.setProperty("webdriver.gecko.driver", "/Users/shaliniprajapati/Desktop/SeleniumJars/geckodriver");
	FirefoxDriver driver = new FirefoxDriver();
	driver.get("https://classic.crmpro.com"); 
}	

@When("^title of login page is Free CRM$")
public void title_of_login_page_is_Free_CRM(){
    // Write code here that turns the phrase above into concrete actions
	
	String title = driver.getTitle();
    System.out.println(title);
    Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.", title);
  
		   }

@Then("^User enters username and password$")
public void User_enters_username_and_password() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.name("username")).sendKeys("ShaliniAutomation");
	driver.findElement(By.name("password")).sendKeys("Test@1234");
}

@Then("^User clicks on Login button$")
public void User_clicks_on_Login_button()  {
	WebElement loginBtn= driver.findElement(By.xpath("//input[@type='submit']"));
    // Write code here that turns the phrase above into concrete actions
    loginBtn.click();
}

@Then("^User is on Home Page$")
public void User_is_on_Home_Page() {
    // Write code here that turns the phrase above into concrete actions
    String title= driver.getTitle();
    System.out.println("Home Page title ::"+ title);
    Assert.assertEquals("CRMPRO", title);
}

@Then("^User quit$")
public void User_quit() {
    System.out.println("Close Browser");
    driver.quit();}

}