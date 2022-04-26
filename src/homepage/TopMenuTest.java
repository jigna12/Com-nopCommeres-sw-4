package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String BaseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }

/*1. create class "TopMenuTest"
            1.1 create method with name "selectMenu" it has one parameter name "menu" of  type string
	1.2 This method should click on the menu whatever name is passed as parameter.
	1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
*/

    @Test//1
    public void verifyPageNavigation()
    {
        selectMenu("Computers");
        String actTab = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));//Find the text element for computer Tab and get the text
        System.out.println("Actual Tab Name Is:" +actTab);
        messageValidation("Computers",actTab);//Validate actual and expected message

        selectMenu("Electronics");
        String actTab1 = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));//Find the text element for Electronics Tab and get the text
        System.out.println("Actual Tab Name Is:" +actTab1);
        messageValidation("Electronics",actTab1);//Validate actual and expected message

        selectMenu("Apparel");
        String actTab2 = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));//Find the text element for Apparel Tab and get the text
        System.out.println("Actual Tab Name Is:" +actTab2);
        messageValidation("Apparel",actTab2);//Validate actual and expected message

        selectMenu("Digital downloads");
        String actTab3 = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));//Find the text element for Digital downloads Tab and get the text
        System.out.println("Actual Tab Name Is:" +actTab3);
        messageValidation("Digital downloads",actTab3);//Validate actual and expected message

        selectMenu("Books");
        String actTab4 = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));//Find the text element for Books Tab and get the text
        System.out.println("Actual Tab Name Is:" +actTab4);
        messageValidation("Books",actTab4);//Validate actual and expected message

        selectMenu("Jewelry");
        String actTab5 = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));//Find the text element for Jewelry Tab and get the text
        System.out.println("Actual Tab Name Is:" +actTab5);
        messageValidation("Jewelry",actTab5);//Validate actual and expected message

        selectMenu("Gift Cards");
        String actTab6 = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));//Find the text element for Gift Cards Tab and get the text
        System.out.println("Actual Tab Name Is:" +actTab6);
        messageValidation("Gift Cards",actTab6);//Validate actual and expected message
    }
    @After
    public void closedown(){
        closeBrowser();
    }
}