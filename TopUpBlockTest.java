package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.MtsTopUpPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TopUpBlockTest extends BaseTest {
    @Test
    public void testTopUpBlock() {
        MtsTopUpPage page = new MtsTopUpPage(driver, wait);
        page.openPage("https://mts.by");

        page.dismissCookieBanner();

        String title = page.getBlockTitle();

        Assertions.assertEquals("Онлайн пополнение без комиссии", title, "Заголовок блока не совпадает с ожидаемым");

        Assertions.assertTrue(page.areLogosDisplayed(), "Логотипы платёжных систем не отображаются");

        String href = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")).getAttribute("href");
        Assertions.assertNotNull(href, "У ссылки нет атрибута href");
        Assertions.assertTrue(href.contains("mts.by"), "Ссылка ведёт на внешний ресурс");

        String currentService = page.getCurrentService();
        Assertions.assertEquals("Услуги связи", currentService, "По умолчанию должен быть выбран вариант 'Услуги связи'");

        page.enterPhone("297777777");
        page.clickContinue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Услуги связи",
            "Домашний интернет",
            "Рассрочка",
            "Задолженность"
    })
    public void testPlaceholdersForAllPaymentOptions(String optionName) {
            MtsTopUpPage page = new MtsTopUpPage(driver, wait);
            page.openPage("https://mts.by");
            page.dismissCookieBanner();


            page.selectPaymentOption(optionName);

            try { Thread.sleep(1000); } catch (InterruptedException e) {}


            boolean ok = page.checkPlaceholders(optionName);

            Assertions.assertTrue(ok, "Не все плейсхолдеры совпали для: " + optionName);

            System.out.println(optionName + " - ОК");
    }
    @Test
    public void testConfirmationScreen() {
        MtsTopUpPage page = new MtsTopUpPage(driver, wait);
        page.openPage("https://mts.by");
        page.dismissCookieBanner();

        page.selectPaymentOption("Услуги связи");
        page.enterPhone("297777777");
        page.enterAmount("10");
        page.proceedToConfirmationPage();

        String amount = page.getConfirmationAmount();
        System.out.println("Сумма: " + amount);
        Assertions.assertNotNull(amount, "Сумма не отображается");
        Assertions.assertTrue(amount.contains("BYN"), "Сумма не содержит валюту BYN");

        String payButtonText = page.getPayButtonText();
        System.out.println("Текст кнопки: " + payButtonText);
        Assertions.assertTrue(
                payButtonText.contains("Оплатить") && payButtonText.contains(amount),
                "Кнопка не содержит текст 'Оплатить' или сумму"
        );

        String phone = page.getConfirmationPhone();
        System.out.println("Номер: " + phone);
        Assertions.assertTrue(
                phone.contains("297777777") || phone.contains("375297777777"),
                "Номер телефона не совпадает. Ожидался: 297777777, Получен: " + phone
        );

        String cardLabel = page.getCardNumberLabel();
        System.out.println("Лейбл карты: " + cardLabel);
        Assertions.assertEquals(
                "Номер карты",
                cardLabel,
                "Лейбл поля карты не совпадает"
        );

        Assertions.assertTrue(
                page.isCardNumberFieldPresent(),
                "Поле номера карты не найдено"
        );

        Assertions.assertTrue(
                page.areConfirmationPaymentLogosDisplayed(),
                "Иконки платёжных систем не отображаются"
        );

    }

}