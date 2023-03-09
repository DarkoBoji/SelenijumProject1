import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utils.Utils;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    protected SoftAssert softAssert;
    Actions actions;


    @BeforeMethod(alwaysRun = true)
    public void setup(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        softAssert = new SoftAssert();
        actions = new Actions(driver);
        Utils.waitForSeconds(3);
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/#/");

        }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        //driver.quit();
    }


    protected WebElement getElement(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    protected void typeIn(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    protected void clickOnElement(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    protected String getTextFromElement(By locator){
        return getElement(locator).getText();
    }

    protected String getColorFromElement(By locator, String cssValue){
        return getElement(locator).getCssValue(cssValue);
    }

    protected boolean isElementVisible(By locator){
        List<WebElement> list = driver.findElements(locator);
        if (!list.isEmpty() && (list.get(0)!=null)){
            return list.get(0).isDisplayed();
        }
        return false;
    }

    protected void clickOnRandomElement(By locator){
        Random random = new Random();
        List<WebElement> list = driver.findElements(locator);
        int randomElement = random.nextInt(list.size());
        list.get(randomElement).click();
    }

    public void hover(By locator){
        Actions actions = new Actions(driver);
        WebElement element = getElement(locator);
        actions.moveToElement(element)
                .build()
                .perform();
    }

    public void hoverAndClick(By locator){
        Actions actions = new Actions(driver);
        WebElement element = getElement(locator);
        actions.moveToElement(element)
                .click()
                .build()
                .perform();
    }









}
