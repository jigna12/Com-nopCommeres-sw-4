package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Mouse;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String BaseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }

    @Test
    public void testnametextverified() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics”Tab
        mouseHoverOnly(By.linkText("Electronics"));

       // 1.2 Mouse Hover on “Cell phones” and click
        mouseHoverOnly(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        // 1.3 Verify the text “Cell phones”
        String ActMsg = getTextFromElement(By.linkText("Cell phones"));
        messageValidation("Cell phones",ActMsg);
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
//        2.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnly(By.linkText("Electronics"));
//        2.2 Mouse Hover on “Cell phones” and click
        mouseHoverClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
//        2.3 Verify the text “Cell phones”
        String ActMsg = getTextFromElement(By.linkText("Cell phones"));
        messageValidation("Cell phones",ActMsg);

//        2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
//        2.5 Click on product name “Nokia Lumia 1020” link
        sendTextToElement(By.xpath("//div[@class='item-grid']//a[contains(text(),'Nokia Lumia 1020')]"), Keys.ENTER + "1");

//        2.6 Verify the text “Nokia Lumia 1020”
        String ActMsg2 = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        messageValidation("Nokia Lumia 1020",ActMsg2);
//        2.7 Verify the price “$349.00”
        String ActMsg3 = getTextFromElement(By.className("price-value-20"));
        messageValidation("$349.00", ActMsg3);

//        2.8 Change quantity to 2
        WebElement Qty=driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        Qty.click();
        Qty.sendKeys(Keys.chord(Keys.CONTROL, "a"), "2");
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
//        2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));

//        2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
//        After that close the bar clicking on the cross button.
        String ActMsg4 = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]"));
        messageValidation("The product has been added to your shopping cart", ActMsg4);
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

//        2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnly(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverClick(By.xpath("//button[contains(text(),'Go to cart')]"));
//        2.12 Verify the message "Shopping cart"
        String ActMsg5 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        messageValidation("Shopping cart", ActMsg5);


//        2.13 Verify the quantity is 2
        String ActMsg9 = getTextFromElement(By.xpath("//span[contains(text(),'2')]"));
        messageValidation("(2)",ActMsg9);
//        2.14 Verify the Total $698.00
        String ActMsg6 = getTextFromElement(By.xpath("//span[contains(text(),'$698.00') and @class='product-subtotal']"));
        messageValidation("$698.00",ActMsg6);
//        2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
//        2.16 Click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
//       2.17 Verify the Text “Welcome, Please Sign In!”
        String ActMsg7 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        messageValidation("Welcome, Please Sign In!",ActMsg7);

//        2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
//        2.19 Verify the text “Register”
        String ActMsg8 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        messageValidation("Register",ActMsg8);

//        2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Krishna");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='Email']"),"kag40@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "kag123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "kag123");

//        2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

//        2.22 Verify the message “Your registration completed”
        String ActMsg10 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        messageValidation("Your registration completed",ActMsg10);
//        2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

//        2.24 Verify the text “Shopping cart”
        String ActMsg11 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        messageValidation("Shopping cart",ActMsg11);
//      2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
//        2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));


//        2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"K P Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"KR12 2PA");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07788665544");

//        2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//label[contains(text(),'2nd Day Air ($0.00)')]"));
//        2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

//        2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//label[contains(text(),'Credit Card')]"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
//        2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Visa");

//        2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Krishna Patel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5555 5555 5555 4444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"02");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2024");
        sendTextToElement(By.id("CardCode"),"1234");

//        2.34 Click on “CONTINUE”CHECKOUT”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
//
//
//        2.35 Verify “Payment Method” is “Credit Card”
        String Actmsg12 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]"));
        System.out.println(Actmsg12);
        messageValidation("Payment Method: Credit Card",Actmsg12);

//        2.36 Verify “Shipping Method” is “2nd Day Air”
        String Actmsg13 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        System.out.println(Actmsg13);
        messageValidation("2nd Day Air",Actmsg13);

//        2.37 Verify Total is “$698.00”
        String Actmsg14 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        System.out.println(Actmsg14);
        messageValidation("$698.00",Actmsg14);

//        2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
//        2.39 Verify the Text “Thank You”
        String Actmsg15 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        System.out.println(Actmsg15);
        messageValidation("Thank you",Actmsg15);

//        2.40 Verify the message “Your order has been successfully processed!”
        Thread.sleep(3000);
        String Actmsg16 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        System.out.println(Actmsg16);
        messageValidation("Your order has been successfully processed!",Actmsg16);

//        2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
//        2.42 Verify the text “Welcome to our store”
        String Actmsg17 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        System.out.println(Actmsg17);
        messageValidation("Welcome to our store",Actmsg17);

//        2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

//        2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String URL1 = driver.getCurrentUrl();
       Assert.assertEquals(URL1, "https://demo.nopcommerce.com/");
    }
    @After
    public void closedown() {
        //closeBrowser();
    }
}