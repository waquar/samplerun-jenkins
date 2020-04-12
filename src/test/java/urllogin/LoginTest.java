package urllogin;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LoginTest {
	WebDriver driver;
	
    @BeforeTest
    public void beforetest(){
        System.setProperty("webdriver.chrome.driver","/users/waquaralam/Automation_Addons/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
       
    }
    
    @Test
    public void login() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(10000);
        Assert.assertEquals(driver.getTitle(),"My Store");
        driver.findElement(By.linkText("Login")).click();                     //  //*[@class='login']
        driver.findElement(By.id("user_email")).sendKeys("abc@email.com");   //  //input[@id='email']
        driver.findElement(By.id("user_password")).sendKeys("gora12");        // //input[@id='passwd']
        driver.findElement(By.name("commit")).click();						  // //*[@class='icon-lock left']
        Thread.sleep(4000);
    }
    
    
    @AfterTest
    public void aftertest(){
        WebElement icon = driver.findElement(By.className("gravatar"));     //     //*[@class='logout']
        if (icon != null) {
            driver.findElement(By.className("gravatar")).click();            //     
            driver.findElement(By.linkText("Log Out"));
            Assert.assertEquals(driver.getTitle(),"Login - My Store");
            driver.quit();
        }
        else{
            System.out.println("log in not successful");       
            driver.quit();
        }
    }
}
