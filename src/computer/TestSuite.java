package computer;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TestSuite extends Utility {
    String BaseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }

    @Test
    public void Testname(){
        selectMenu("Computers");//Click on Computer Menu
        selectMenu("Desktops");//Click on Desktop
       clickOnElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));//Select Sort By position "Name: Z to A"
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        selectMenu("Computers");//2.1 Click on Computer Menu
        selectMenu("Desktops");//2.2 Click on Desktop
        clickOnElement(By.xpath("//select[@id='products-orderby']"));//2.3 Select Sort By position "Name: A to Z

        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //2.5 Verify the Text "Build your own computer"
        String actTab = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        System.out.println("Actual Tab Name Is:" +actTab);

        messageValidation("Build your own computer",actTab); //Validate actual and expected message
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(By.xpath("//option[contains(text(),'2.2 GHz Intel Pentium Dual-Core E2200')]"));
        //2.7.Select "8GB [+$60.00]" using Select class.
        clickOnElement(By.xpath("//option[contains(text(),'8GB')]"));

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //2.11 Verify the price "$1,475.00"
        clickOnElement(By.xpath("//span[@id='price-value-1']"));

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String ActMsg = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        System.out.println("Actual Tab Name Is:" +ActMsg);
        messageValidation("The product has been added to your shopping cart",ActMsg);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.***********************
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement mainmenu = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement submenu = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        actions.moveToElement(mainmenu).moveToElement(submenu).click().build().perform();

        //2.15 Verify the message "Shopping cart"
        Thread.sleep(3000);
        String Actmsg2= getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        System.out.println(Actmsg2);
        messageValidation("Shopping cart",Actmsg2 );

       //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        WebElement Qty=driver.findElement(By.className("qty-input"));
        Qty.click();
        Qty.sendKeys(Keys.chord(Keys.CONTROL, "a"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

       // 2.17 Verify the Total
        String ActMsg3 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        System.out.println("Actual Tab Name Is:" +ActMsg3);
        messageValidation("$2,950.00",ActMsg3);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(3000);
        String Actmsg4 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        System.out.println(Actmsg4);
        messageValidation("Welcome, Please Sign In!",Actmsg4);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Krishna");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"kag21@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"K P Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"KR12 2PA");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07788665544");


        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 new-address-next-step-button']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//label[contains(text(),'Next Day Air ($0.00)')]"));
        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        // 2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//label[contains(text(),'Credit Card')]"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        // 2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");

        // 2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Krishna Patel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5555 5555 5555 4444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"02");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2024");
        sendTextToElement(By.id("CardCode"),"1234");

       // 2.29 Click on “CONTINUE”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.30 Verify “Payment Method” is “Credit Card”
        String Actmsg5 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]"));
        System.out.println(Actmsg5);
        messageValidation("Payment Method: Credit Card",Actmsg5);

       //2.32 Verify “Shipping Method” is “Next Day Air”
        String Actmsg6 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]"));
        System.out.println(Actmsg6);
        messageValidation("Shipping Method: Next Day Air",Actmsg6);

        //2.33 Verify Total is “$2,950.00”
        String Actmsg10 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        System.out.println(Actmsg10);
        messageValidation("$2,950.00",Actmsg10);

       // 2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
       //2.35 Verify the Text “Thank You”
        String Actmsg7 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        System.out.println(Actmsg7);
        messageValidation("Thank you",Actmsg7);

        //2.36 Verify the message “Your order has been successfully processed!”
        Thread.sleep(3000);
        String Actmsg8 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        System.out.println(Actmsg8);
        messageValidation("Your order has been successfully processed!",Actmsg8);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        String Actmsg9 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        System.out.println(Actmsg9);
        messageValidation("Welcome to our store",Actmsg9);
    }
    @After
    public void closedown(){
        closeBrowser();
    }
}