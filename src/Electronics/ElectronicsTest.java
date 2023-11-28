package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

import java.util.Random;

public class ElectronicsTest extends Utility {

    static String baseUrl = "https://demo.nopcommerce.com/";

    // calling method from BaseTest class to open and set-up the browser

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // 1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        // 1.2 Mouse Hover on “Cell phones” and click
        mouseHoverOnElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        // 1.3 Verify the text “Cell phones”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
    }

    // 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        // 1.2 Mouse Hover on “Cell phones” and click
        mouseHoverOnElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        // 1.3 Verify the text “Cell phones”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
        // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        // 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']"));
        // 2.6 Verify the text “Nokia Lumia 1020”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"), "Nokia Lumia 1020");
        // 2.7 Verify the price “$349.00”
        verifyTheStringMessage(By.xpath("//span[@id='price-value-20']"), "$349.00");
        // 2.8 Change quantity to 2
        String s = Keys.CONTROL + "a";
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), s);
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        // 2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        // 2.10 Verify the Message "The product has been added to your shopping cart" on To green Bar After that close the bar clicking on the cross button.
        verifyTheStringMessage(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");
        clickOnElement(By.xpath("//span[@title='Close']"));
        // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        // 2.12 Verify the message "Shopping cart"
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        // 2.13 Verify the quantity is 2
        String expectedValue = driver.findElement(By.xpath("//input[@class = 'qty-input']")).getAttribute("value");
        String actualValue = "2";
        Assert.assertEquals(expectedValue, actualValue);
        // 2.14 Verify the Total $698.00
        verifyTheStringMessage(By.xpath("//span[@class='product-subtotal']"), "$698.00");
        // 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // 2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.17 Verify the Text “Welcome, Please Sign In!”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"), "Welcome, Please Sign In!");
        // 2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        // 2.19 Verify the text “Register”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Register']"), "Register");
        // 2.20 Fill the mandatory fields (First Name)
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Abcd");
        // 2.20 Fill the mandatory fields (Last Name)
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Xyz");
        // 2.20 Fill the mandatory fields (Email)
        Random random = new Random();
        String gmail = "abcd" + random.nextInt() + "@gmail.com";
        sendTextToElement(By.xpath("//input[@id='Email']"), gmail);
        // 2.20 Fill the mandatory fields (Password)
        sendTextToElement(By.xpath("//input[@id='Password']"), "abcd123");
        // 2.20 Fill the mandatory fields (Confirm Password)
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "abcd123");
        // 2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        // 2.22 Verify the message “Your registration completed”
        verifyTheStringMessage(By.xpath("//div[@class='result']"), "Your registration completed");
        // 2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        // 2.24 Verify the text “Shopping card”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");

        // Login steps
        clickOnElement(By.xpath("//a[normalize-space()='Log in']"));
        sendTextToElement(By.id("Email"), gmail);
        sendTextToElement(By.id("Password"), "abcd123");
        clickOnElement(By.xpath("//button[normalize-space()='Log in']"));

        // 2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // 2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Harrow");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "1, abcd Street");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA3 0AB");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07424811185");
        // 2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@value = '2nd Day Air___Shipping.FixedByWeightByTotal']"));
        // 2.30 Click on “CONTINUE”
        clickOnElement(By.className("button-1 shipping-method-next-step-button"));
        // 2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        // 2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");
        // 2.33 Fill all the details (Card Holder Name)
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Abcdxyz");
        // 2.33 Fill all the details (Card Number)
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4111111111111111");
        // 2.33 Fill all the details (Card Expiry Date)
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        // 2.33 Fill all the details (Card Expiry Year)
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        // 2.33 Fill all the details (Card Secure Code)
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        // 2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        // 2.35 Verify “Payment Method” is “Credit Card”
        verifyTheStringMessage(By.xpath("//span[normalize-space()='Credit Card']"), "Credit Card");
        // 2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyTheStringMessage(By.xpath("//span[normalize-space()='2nd Day Air']"), "2nd Day Air");
        // 2.37 Verify Total is “$698.00”
        verifyTheStringMessage(By.xpath("//span[@class='product-subtotal']"), "$698.00");
        // 2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        // 2.39 Verify the Text “Thank You”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Thank you']"), "Thank You");
        // 2.40 Verify the message “Your order has been successfully processed!”
        verifyTheStringMessage(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"), "Your order has been successfully processed!");
        // 2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        // 2.42 Verify the text “Welcome to our store”
        verifyTheStringMessage(By.xpath("//h2[normalize-space()='Welcome to our store']"), "Welcome to our store");
        // 2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));
        // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String currentUrl = driver.getCurrentUrl();
        String actualUrl = "https://demo.nopcommerce.com/";
        Assert.assertEquals(actualUrl, currentUrl);
    }


    @After
    public void tearDown() {
        //  closeBrowser();
    }


}
