package exemplo2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GithubTest {
	@Test
	public void test02() {
		// no Windows, o driver termina em .exe. Por exemplo: "./libs/chromedriver.exe"		
		System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://github.com/");

		WebElement signUpButton = driver
				.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/div[2]/div[1]/form/button"));
		signUpButton.click();

		// check msg: "There were problems creating your account."
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[1]"));
		assertEquals("There were problems creating your account.", errorMsg.getText().trim());

		// check msg: "Username can't be blank"
		WebElement errorMsg02 = driver.findElement(By.xpath("//form/auto-check[1]/dl/dd[2]"));
		assertEquals("Username can't be blank", errorMsg02.getText().trim());

		// fill the username
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("andreendo22");
		
		//fill the email 
		WebElement email = driver.findElement(By.id("user_email"));
		email.sendKeys("andreendo22@mail.com");		
		
		driver.close();
	}
}
