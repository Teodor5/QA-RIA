   
	
	package com.example.test;

	import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;
	import static org.testng.Assert.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class FirstandSecondStep2 {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	 @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "E:\\QA\\geckodriver-v0.18.0-win64\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "https://auto.ria.com/car/vaz/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testFirstandSecondStep2() throws Exception {
	    driver.get("https://auto.ria.com/car/vaz/");
	    new Select(driver.findElement(By.id("categories"))).selectByVisibleText("Легковые");
	    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
	    new Select(driver.findElement(By.id("marks"))).selectByVisibleText("ВАЗ");
	    driver.findElement(By.cssSelector("option[value=\"88\"]")).click();
	    new Select(driver.findElement(By.id("models"))).selectByVisibleText("1111 Ока*");
	    driver.findElement(By.id("priceFrom")).clear();
	    driver.findElement(By.id("priceFrom")).sendKeys("1000");
	    driver.findElement(By.id("priceTo")).clear();
	    driver.findElement(By.id("priceTo")).sendKeys("10000");
	    new Select(driver.findElement(By.id("currency"))).selectByVisibleText("$");
	    new Select(driver.findElement(By.id("yearTo"))).selectByVisibleText("2010");
	    new Select(driver.findElement(By.id("year"))).selectByVisibleText("1990");
	    driver.findElement(By.cssSelector("button.button-primary")).click();
	    driver.findElement(By.linkText("10")).click();
	    driver.findElement(By.linkText("Следующая")).click();
	    driver.quit();
	  }

	@AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}
