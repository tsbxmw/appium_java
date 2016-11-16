package appium_java;

import java.io.File;
import java.net.URL;
import java.sql.Time;

import org.apache.xalan.templates.ElemElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class test {
	
	private AndroidDriver driver = null;
	@Before
	public void setUp() throws Exception{
		//System.setProperty("user.dir", "./");
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot,"apps");
		File app = new File(appDir,"app-release.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "test_android");
		capabilities.setCapability("platformVersion", "6.0.1");
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.example.app_test");
		capabilities.setCapability("appActivity", ".StartShow");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
	}
	@After
	public void tearDown(){
		if(driver!=null)
			driver.quit();
	}

	@Test
	public void test_app(){	
		//driver.swipe(0, 9, 19, 99, 1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element = driver.findElement(By.id("user"));
		element.clear();
		element.sendKeys("123");
		element = driver.findElement(By.id("pass"));
		element.clear();
		element.sendKeys("123");
		driver.pressKeyCode(4);
		element = driver.findElement(By.id("button_login"));
		element.click();
		/*WebElement element = driver.findElementByAndroidUIAutomator("com.android.calculator2:id/digit_7");
		element.click();

		try {
			Thread.sleep(10000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
