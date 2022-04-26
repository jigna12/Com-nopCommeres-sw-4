package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    //This method will click on element
    public void clickOnElement(By by)
    {
        WebElement element = driver.findElement(by);
        element.click();
    }
    //This method will get text from element//return type with example
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    //This method will send text on element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method click on the menu whatever name is passed as parameter
    public void selectMenu(String menu)
    {
        clickOnElement(By.linkText(menu));
    }

    //This Method Compare  ExpMsg, ActMsg
    public void messageValidation(String ExpMsg, String ActMsg)
    {
        Assert.assertEquals("Message is not as per Project Requirement:", ExpMsg, ActMsg);
    }
    //This method is ****************** Alert methods ************
    public void switchToAlert()
    {
        driver.switchTo().alert();
    }
    //This method will accept the Alert method
    public void switchToAccept()
    {
        driver.switchTo().alert().accept();
    }
    /****************************Select class methods*********************
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) throws InterruptedException
    {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void mouseHoverOnly(By by) throws InterruptedException
    {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHoover).build().perform();
    }

    public void mouseHoverClick(By by) throws InterruptedException
    {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }
}
