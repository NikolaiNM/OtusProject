package pages;

import org.openqa.selenium.*;

public class EventsPage extends AbsBasePage {


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

}
