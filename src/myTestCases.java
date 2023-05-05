import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.bouncycastle.jcajce.provider.symmetric.DES;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class myTestCases {

	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;
	SoftAssert myAssert = new SoftAssert();
	
	@BeforeTest
	public void myBeforeTest() {

		// for browser and application
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); // kolna
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "HTU"); // kolna - bas 7nger esm elmob

		// for browser

//		 caps.setCapability("chromedriverExecutable",
//		 "C:\\Users\\User\\OneDrive\\Desktop\\New folder (19)\\chromedriver.exe"); //
		// change the path
//		 caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome"); // kolna

		// for application

		File CalculatorApp = new File("src/myApps/calculator.apk");

		caps.setCapability(MobileCapabilityType.APP, CalculatorApp.getAbsolutePath());

	}

//	@Test()
//	public void open_the_Browser() throws MalformedURLException {
//		
//
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps); // kolna in each test case
//		
//		driver.get("https://www.youtube.com");
//	}

	@Test()
	public void Open_the_application() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click(); 
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
		String actualResult = driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
		String expectedResult = "7894561230";
		myAssert.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult);





	}

	@AfterTest 
	public void after () {
		myAssert.assertAll();
	}
}
