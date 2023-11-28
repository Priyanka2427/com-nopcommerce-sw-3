package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {


    static String baseUrl = "https://demo.nopcommerce.com/";

    // calling method from BaseTest class to open and set-up the browser

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {

        // 1.2 This method should click on the menu whatever name is passed as parameter.
        List<WebElement> topMenuList = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li/a"));
        for (WebElement element : topMenuList) {
            if (element.getText().trim().equalsIgnoreCase(menu)) {
                clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='" + menu + "']"));
                break;
            }
        }

    }

    // 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation() {
        String menu = "Computers";
        selectMenu(menu);
        String expectedTitle = getTextFromElement(By.xpath("//h1[normalize-space()='" + menu + "']"));
        String axpectedTitle = menu;
        Assert.assertEquals(expectedTitle, axpectedTitle);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}