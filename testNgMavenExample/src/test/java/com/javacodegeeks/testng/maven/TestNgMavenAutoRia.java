package com.javacodegeeks.testng.maven;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgMavenAutoRia {

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
	  public void AppTest2() throws Exception {
	    driver.get("https://auto.ria.com/car/vaz/");
	    new Select(driver.findElement(By.id("categories"))).selectByVisibleText("��������");
	    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
	    new Select(driver.findElement(By.id("marks"))).selectByVisibleText("���");
	    driver.findElement(By.cssSelector("option[value=\"88\"]")).click();
	    new Select(driver.findElement(By.id("models"))).selectByVisibleText("1111 ���*");
	    driver.findElement(By.id("priceFrom")).clear();
	    driver.findElement(By.id("priceFrom")).sendKeys("1000");
	    driver.findElement(By.id("priceTo")).clear();
	    driver.findElement(By.id("priceTo")).sendKeys("10000");
	    new Select(driver.findElement(By.id("currency"))).selectByVisibleText("$");
	    new Select(driver.findElement(By.id("yearTo"))).selectByVisibleText("2010");
	    new Select(driver.findElement(By.id("year"))).selectByVisibleText("1990");
	    driver.findElement(By.cssSelector("button.button-primary")).click();
	    driver.findElement(By.linkText("10")).click();
	    driver.findElement(By.linkText("���������")).click();
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
	/*@Test
	public void oneMoreTest() {
		System.out.println("This is a TestNG-Maven based test");
	}*/
}
