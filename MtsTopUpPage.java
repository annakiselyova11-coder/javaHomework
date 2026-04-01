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
    private By serviceDropdown = By.cssSelector("button.select__header");
    private By dropdownOption = By.cssSelector("p.select__option");
    private By connectionAmountInput = By.id("connection-sum");
    private By homeInternetInput = By.id("internet-sum");
    private By internetPhoneInput = By.id("internet-phone");
    private By installmentInput = By.id("score-instalment");
    private By installmentSumInput = By.id("instalment-sum");
    private By debtInput = By.id("score-arrears");
    private By arrearsSumInput = By.id("arrears-sum");
    private By connectionEmail = By.id("connection-email");
    private By internetEmail = By.id("internet-email");
    private By installmentEmail = By.id("instalment-email");
    private By arrearsEmail = By.id("arrears-email");
    private By confirmationAmount = By.xpath("//div[contains(@class, 'pay-description__cost')]//span[contains(text(), 'BYN')]");
    private By payButtonAmount = By.cssSelector("button[type='submit'] span");
    private By confirmationPhone = By.cssSelector(".pay-description__text span");
    private By cardNumberField = By.id("cc-number");
    private By cardExpiryField = By.cssSelector("input[placeholder='ММ / ГГ']");
    private By cardCvvField = By.xpath("//label[contains(text(), 'CVC')]/preceding-sibling::div//input");
    private By cardNumberLabel = By.xpath("//label[contains(text(), 'Номер карты')]");
    private By paymentLogosContainer = By.cssSelector(".cards-brands__container");
    private By payButton = By.cssSelector("button[type='submit']");
    private By paymentIframe = By.cssSelector("iframe.payment-widget-iframe");


    public MtsTopUpPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void dismissCookieBanner() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement cookieBtn = shortWait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            cookieBtn.click();
            System.out.println("Баннер куки закрыт");
        } catch (TimeoutException e) {
            System.out.println("Баннер куки не найден");
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
    public void enterAmount(String amount) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(connectionAmountInput)
        );
        input.clear();
        input.sendKeys(amount);
    }

    public void clickContinue() {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        );
        btn.click();
    }

    public void switchToPaymentIframe() {
        WebDriverWait iframeWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        iframeWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentIframe));
        System.out.println("✓ Переключено на iframe: checkout.bepaid.by");
    }

    public void selectPaymentOption(String optionName) {
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(serviceDropdown)
        );
        dropdown.click();

        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//p[contains(@class, 'select__option') and contains(text(), '" + optionName + "')]")
                )
        );
        option.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getFieldPlaceholder() {
        By[] possibleFields = {
                phoneInput,
                homeInternetInput,
                installmentInput,
                debtInput
        };

        for (By field : possibleFields) {
            try {
                WebElement element = driver.findElement(field);
                if (element.isDisplayed()) {
                    return element.getAttribute("placeholder");
                }
            } catch (Exception e) {

            }
        }
        return null;
    }

    public boolean checkPlaceholders(String option) {
        if (option.equals("Услуги связи")) {
            return "Номер телефона".equals(getPlaceholder(phoneInput)) &&
                    "Сумма".equals(getPlaceholder(connectionAmountInput)) &&
                    "E-mail для отправки чека".equals(getPlaceholder(connectionEmail));
        }
        if (option.equals("Домашний интернет")) {
            return "Номер абонента".equals(getPlaceholder(internetPhoneInput)) &&
                    "Сумма".equals(getPlaceholder(homeInternetInput)) &&
                    "E-mail для отправки чека".equals(getPlaceholder(internetEmail));
        }
        if (option.equals("Рассрочка")) {
            return "Номер счета на 44".equals(getPlaceholder(installmentInput)) &&
                    "Сумма".equals(getPlaceholder(installmentSumInput)) &&
                    "E-mail для отправки чека".equals(getPlaceholder(installmentEmail));
        }
        if (option.equals("Задолженность")) {
            return "Номер счета на 2073".equals(getPlaceholder(debtInput)) &&
                    "Сумма".equals(getPlaceholder(arrearsSumInput)) &&
                    "E-mail для отправки чека".equals(getPlaceholder(arrearsEmail));
        }
        return false;
    }

    private String getPlaceholder(By locator) {
        try {
            WebElement el = driver.findElement(locator);
            return el.getAttribute("placeholder");
        } catch (Exception e) {
            return null;
        }
    }

    public String getConfirmationAmount() {
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement amount = longWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[contains(@class, 'pay-description__cost')]//span[contains(text(), 'BYN')]")
                )
        );
        return amount.getText().trim();
    }
    public void waitForConfirmationPage() {
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        longWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector(".pay-description__cost")
                )
        );
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }

    public String getPayButtonText() {
        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(payButton)
        );
        return button.getText().trim();
    }

    public String getConfirmationPhone() {
        WebElement phone = wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmationPhone)
        );
        return phone.getText().trim();
    }
    public String getCardNumberLabel() {
        WebElement label = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cardNumberLabel)
        );
        return label.getText().trim();
    }

    public boolean areConfirmationPaymentLogosDisplayed() {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(paymentLogosContainer)
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isCardNumberFieldPresent() {
        try {
            return driver.findElement(cardNumberField).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void switchToMainContent() {
        driver.switchTo().defaultContent();
        System.out.println("Возврат к основному документу");
    }

    public void proceedToConfirmationPage() {
        clickContinue();
        switchToPaymentIframe();
        waitForConfirmationPage();
    }

}



