import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BasketTest extends BaseTest {

    By headerMenuComputers = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]");
    By headerMenuNotebooks = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Notebooks')]");
    By addProductToBasket = By.cssSelector("input[value^='Add']");
    By headerMenuBooks = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]");
    By gotToBasket = By.cssSelector(".ico-cart .cart-label");
    By productPrices = By.className("product-subtotal");
    By totalAmount = By.cssSelector(".product-price > strong");

    @Test(description = "Verifying correct amount in basket", groups = "smoke")
    public void basketTest(){

        hover(headerMenuComputers);
        hoverAndClick(headerMenuNotebooks);
        clickOnElement(addProductToBasket);
        clickOnElement(headerMenuBooks);
        clickOnRandomElement(addProductToBasket);
        clickOnElement(gotToBasket);
        List<WebElement> productPricesInBasket = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productPrices));
        double sum = 0 ;
        for (int i = 0; i < productPricesInBasket.size(); i++) {
            sum = sum + Double.parseDouble(productPricesInBasket.get(i).getText());
        }
        System.out.println("Zbir cena je: " + sum);

        double total = Double.parseDouble(getTextFromElement(totalAmount));

        System.out.println("Total: " + total);

        Assert.assertTrue(sum == total, "Prices sum is not equal to total amount!");

    }









}
