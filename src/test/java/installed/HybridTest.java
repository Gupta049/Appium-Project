package installed;

import com.appium.Base;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class HybridTest extends Base {

    @Test
    public void hybridTest() throws InterruptedException {
        //Scroll and Select India from the dropdown
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
        //Type name in text field
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arpita");
        driver.hideKeyboard(); // for hiding keyboard
        //select radio button
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(5000);
        //Scroll until air jordan 9 retro
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));"));
        Thread.sleep(5000);
        //Select Air Jordan 9 Reto
        //int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).size();
        System.out.println("total number of product " + count);
        for (int i=0; i<count; i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Air Jordan 9 Reto")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
}
