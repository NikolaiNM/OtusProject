package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

import java.util.List;

public class EventsPage extends AbsBasePage {

    private String checkingTypeOfVibinar = "//div[@class='dod_new-type__text']";

    public EventsPage(WebDriver driver) {
        super(driver);
    }



    public void scrollToEnd() {
        long previousHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
        while (true) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            try {
                Thread.sleep(500);  // Задержка между прокрутками
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.info("Поток был прерван при ожидании задержки.");
                break;
            }
            long currentHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
            if (currentHeight == previousHeight) {
                logger.info("Достигнут конец страницы.");
                break;
            }
            previousHeight = currentHeight;
        }
    }

    public void checkTextInElements(String expectedText) {
        List<WebElement> webinarElements = driver.findElements(By.xpath(checkingTypeOfVibinar));
        for (int i = 0; i < webinarElements.size(); i++) {
            WebElement element = webinarElements.get(i);
            String text = element.getText().trim();

            if (!text.equals(expectedText)) {
                logger.info("Ошибка: Элемент с индексом " + (i + 1) + " не содержит текст '"
                        + expectedText + "'. Фактический текст: '" + text + "'");
                Assertions.fail("Текст элемента на индексе " + (i + 1) + " не совпадает с ожидаемым: '"
                        + expectedText + "'. Фактический текст: '" + text + "'");
            }
        }
        logger.info("Все элементы содержат правильный текст '" + expectedText + "'");
    }

}
