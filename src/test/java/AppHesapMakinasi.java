import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppHesapMakinasi {
    AndroidDriver<AndroidElement> driver;

        @Test
        public void deneme01() throws MalformedURLException {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\User\\IdeaProjects\\Appium-T120\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // uygulamanin yuklendigini dogrular(isInstalled)
            Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
            // uygulamanin acildigini dogrular
            Assert.assertTrue(driver.findElementByAccessibilityId("2").isDisplayed());
            // 100 un 5 katininin 500 oldugunu hesap makinasindan dogrulayalim
            driver.findElementByAccessibilityId("1").click();
            driver.findElementByAccessibilityId("0").click();
            driver.findElementByAccessibilityId("0").click();
            driver.findElementByAccessibilityId("multiply").click();
            driver.findElementByAccessibilityId("5").click();
            String sonucKutusu = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
            System.out.println(sonucKutusu);
            Assert.assertEquals(Integer.parseInt(sonucKutusu),500);
        }
    }
/*
  git init
  git add .
  git commit -m "first commit"
  git branch -M main
  git remote add origin https://github.com/ertugrulkececii/Appium_studies.git
  git push -u origin main
 */
