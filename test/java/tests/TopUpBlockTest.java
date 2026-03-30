package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.MtsTopUpPage;

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
}