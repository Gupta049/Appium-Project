package realdeviceapp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {
    public AndroidDriver driver;

    @BeforeClass
    public void setUrl() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformName", "Android");
        dc.setCapability("udid","8d77e3e0");
        dc.setCapability("deviceName", "realme 5i");
        dc.setCapability("platformVersion", "10");
        dc.setCapability("appPackage", "advanced.scientific.calculator.calc991.plus");
        dc.setCapability("appActivity", "advanced.scientific.calculator.calc991.plus.splash.SplashScreenActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }

    @Test
    public void run(){

    }
}
