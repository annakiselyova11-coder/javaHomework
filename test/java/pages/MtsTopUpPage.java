package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsTopUpPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By blockTitle = By.cssSelector(".pay__wrapper h2");
    private By paymentLogos = By.cssSelector(".pay__partners ul");
    private By detailsLink = By.xpath("//a[contains(text(), 'Подробнее о сервисе')]");
    private By currentService = By.cssSelector("span.select__now");
    private By phoneInput = By.id("connection-phone");
    private By continueButton = By.xpath("//button[contains(text(), 'Продолжить')]");
    private By cookieAcceptButton = By.id("cookie-agree");

    public MtsTopUpPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void dismissCookieBanner() {
        try {WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement cookieBtn = shortWait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            cookieBtn.click();
            System.out.println("Баннер куки закрыт");
        } catch (TimeoutException e) {System.out.println("Баннер куки не найден");
        }
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public String getBlockTitle() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(blockTitle)
        );
        return element.getText().replaceAll("\\s+", " ").trim();
    }

    public boolean areLogosDisplayed() {
        WebElement logos = wait.until(
                ExpectedConditions.visibilityOfElementLocated(paymentLogos)
        );
        return logos.isDisplayed();
    }

    public void clickDetailsLink() {
        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(detailsLink)
        );
        link.click();
    }

    public String getCurrentService() {
        WebElement service = wait.until(
                ExpectedConditions.visibilityOfElementLocated(currentService)
        );
        return service.getText().trim();
    }

    public void enterPhone(String phone) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(phoneInput)
        );
        input.clear();
        input.sendKeys(phone);
    }

    public void clickContinue() {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        );
        btn.click();
    }

}

