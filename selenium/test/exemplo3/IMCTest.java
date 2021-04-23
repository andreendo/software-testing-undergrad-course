package exemplo3;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class IMCTest {

	private static WebDriver d;
	private static JavascriptExecutor js;

	@BeforeAll
	public static void beforeAll() {
		System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");
		d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		d.manage().window().maximize();
		// apelar para o JS
		js = (JavascriptExecutor) d;
	}

	@BeforeEach
	public void beforeEach() {
		d.get("https://www.tuasaude.com/calculadora/imc/");

	}

	@AfterEach
	public void afterEach() {
		d.close();
	}

	@Test
	void test01() {
		// quando usar XPath, observe que existe varias possibilidades
//		d.findElement(By.xpath("//*[@id='gender']/div[2]/label")).click();
		d.findElement(By.xpath("//label[@class='btn' and text() = 'Homem']")).click();
		
		d.findElement(By.name("age")).sendKeys("36");
		d.findElement(By.name("height")).sendKeys("1,80");
		d.findElement(By.name("weight")).sendKeys("70");
		// faz scroll
		js.executeScript("window.scrollBy(0,400)");
		d.findElement(By.xpath("//*[@id='athleticActivity']/div[2]")).click();
		WebElement calcButton = d.findElement(By.name("calculate"));
		calcButton.click();
		// faz scroll
		js.executeScript("window.scrollBy(0,800)");
		WebElement resposta = d.findElement(By.xpath("//*[@id='bmi-calculator']/div[2]/div[1]/div"));
		assertTrue(resposta.getText().contains("21.6"));
	}
}
