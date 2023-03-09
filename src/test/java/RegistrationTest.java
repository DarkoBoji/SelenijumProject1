import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class RegistrationTest extends BaseTest{


    By registerLink = By.xpath("//a[@class='ico-register']");
    By selectGender = By.xpath("//input[@id='gender-male']");

    By firstNameField = By.cssSelector(".inputs label[for='FirstName'] + input");//css child elements
    By lastNameField = By.xpath("//label[text()='Last name:']/following-sibling::input"); //xpath child elements
    By emailField = By.xpath("//input[@id='Email']");
    By passwordField = By.xpath("//input[@id='Password']");
    By confirmPasswordField = By.xpath("//input[@id='ConfirmPassword']");
    By registerButton = By.xpath("//input[@id='register-button']");

    By welcomePageText = By.cssSelector(".page-body .result");
    By continueButton = By.cssSelector("input[value*='Cont']");


    @Test
    public void registerUserTest(){
        String email = Utils.generateRandomEmail();
        System.out.println("Email: " + email);
        clickOnElement(registerLink);
        clickOnElement(selectGender);

        typeIn(firstNameField, "John");
        typeIn(lastNameField, "Smith");
        typeIn(emailField, email);
        typeIn(passwordField, "test12345");
        typeIn(confirmPasswordField, "test12345");
        clickOnElement(registerButton);

        String actualText = getTextFromElement(welcomePageText);
        String expectedText = "Your registration completed";

        softAssert.assertEquals(actualText, expectedText);

        //boolean isElementPresent = getElement(continueButton).isDisplayed();
        softAssert.assertTrue(isElementVisible(continueButton), "Continue button is not present on page!");


        System.out.println("Izvrsene su sve asercije!");
        softAssert.assertAll();
    }


}