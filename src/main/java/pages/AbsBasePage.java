package pages;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbsBasePage extends AbsCommon {

    private final String BASE_URL;

    public AbsBasePage(WebDriver driver) {
        super(driver);
        this.BASE_URL = System.getProperty("base.url", "https://otus.ru");
    }

    public void cookieAccess() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.setItem('cookieAccess', 'true');");
        js.executeScript("window.localStorage.setItem('cookieAccept', 'true');");
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



    public void clickButton(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));

            // Прокрутка с учётом смещения (50 пикселей вниз от позиции элемента)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -200);", button);

            // Клик по элементу
            button.click();
            logger.info("Кнопка с селектором '" + cssSelector + "' успешно нажата.");
        } catch (Exception e) {
            logger.error("Ошибка при попытке нажать на кнопку с селектором '" + cssSelector + "': " + e.getMessage());
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
