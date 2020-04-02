package exemplo1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

class FirstTest {

	@Test
	public void test01() {
		System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.com.br/");
		WebElement searchInput = driver.findElement(By.name("q"));
		searchInput.sendKeys("teste de software");
		searchInput.submit();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("teste");
			}
		});

		assertTrue(driver.getTitle().startsWith("teste de software"));
		driver.close();
	}

}
