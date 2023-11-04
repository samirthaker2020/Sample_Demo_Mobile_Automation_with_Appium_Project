import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class CalculatorTestTest {
    AndroidDriver<AndroidElement> driver ;
    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pie9.0");
        cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        try {

           driver = new AndroidDriver<AndroidElement>(new URL("http:127.0.0.1:4723/wd/hub"), cap);

        } catch (MalformedURLException e) {

            System.out.println(e.getMessage());

        }

    }
    @Test
    public void addition() {

        System.out.println("Application Started.....");
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"9\"]");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"1\"]");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("plus");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"9\"]");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("equals");
        el5.click();
    }
}