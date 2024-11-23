package pages;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AbsBasePage extends AbsCommon {

    private final String BASE_URL;

    public AbsBasePage(WebDriver driver) {
        super(driver);
        this.BASE_URL = System.getProperty("base.url", "https://otus.ru");
    }

    public void setCookieAccept() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.setItem('cookieAccess', 'true');");
        logger.info("Куки приняты");
        js.executeScript("location.reload();");

        try {
            Thread.sleep(2500);
            logger.info("Ожидание 2 секунда после перезагрузки страницы.");
        } catch (InterruptedException e) {
            logger.info("Ошибка при ожидании паузы: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open(String path) {
        driver.get(BASE_URL + path);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }
}
