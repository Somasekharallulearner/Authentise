package com.authentise.calculator.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestcaseOne {

	
	    private WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://www.calculator.net/conversion-calculator.html");
	        driver.manage().window().maximize();
	        
	    }

	    @Test
	    public void testLengthConversion() {
	        // Select "inches" from the "From" dropdown
	        WebElement fromOption = driver.findElement(By.xpath("//select[@name='calFrom']//option[text()='Inch']"));
	        fromOption.click();

	        // Select "centimeters" from the "To" dropdown
	        WebElement toOption = driver.findElement(By.xpath("//select[@name='calTo']//option[text()='Centimeter']"));
	        toOption.click();

	        // Enter the value to be converted (10 inches)
	        WebElement inputField = driver.findElement(By.name("fromVal"));
	        inputField.sendKeys("10");

	        // Verify the result
	        WebElement result = driver.findElement(By.xpath("//div[contains(text(), '25.4')]"));
	        String[] value = result.getText().split("=");
	        System.out.println(value[1]);
	        Assert.assertEquals(result.getText().split("=")[1].trim(),"25.4 Centimeter");
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}



