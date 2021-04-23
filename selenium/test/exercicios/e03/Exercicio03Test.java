package exercicios.e03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

class Exercicio03Test {

	private static WebDriver d;

	@BeforeAll
	public static void beforeAll() {
		System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");
		var options = new ChromeOptions();
		options.addArguments("--headless");
		d = new ChromeDriver(options);
		d.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		d.manage().window().maximize();
	}

	@BeforeEach
	public void beforeEach() {
		d.get("https://andreendo.github.io/sample-ui-compras/index-2.html");
	}

	@AfterAll
	public static void afterEach() {
		d.close();
	}

	@Test
	void testLimparCampos() {
		var nome = d.findElement(By.name("nome"));
		nome.sendKeys("Miyagi");
		d.findElement(By.name("idade")).sendKeys("95");
		var sexoSelec = new Select(d.findElement(By.name("sexo")));
		sexoSelec.selectByVisibleText("masculino");
		d.findElement(By.name("salario")).sendKeys("4000");
//		d.findElement(By.xpath("/html/body/form/input[4]")).click();
		d.findElement(By.xpath("//input[@value='Limpar campos']")).click();		
		
		assertEquals("", nome.getText());
		assertEquals("-", sexoSelec.getFirstSelectedOption().getText());
	}
	
	@Test
	void testCalcularImpostoMenor5000() {
		d.findElement(By.name("nome")).sendKeys("Miyagi");
		d.findElement(By.name("idade")).sendKeys("95");
		var sexoSelec = new Select(d.findElement(By.name("sexo")));
		sexoSelec.selectByVisibleText("masculino");
		d.findElement(By.name("salario")).sendKeys("4000");
//		d.findElement(By.xpath("/html/body/form/input[5]")).click();
		d.findElement(By.xpath("//input[@value='Calcular']")).click();
		
		String textoImposto = d.findElement(By.id("divValorImposto")).getText();
		assertEquals("Valor a pagar de imposto: 600", textoImposto);
	}
}