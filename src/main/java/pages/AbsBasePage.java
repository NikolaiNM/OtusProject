package pages;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbsBasePage extends AbsCommon {

    private final String BASE_URL;
    private String okCookiesButton = "button.sc-9a4spb-0.izekQs";

    public AbsBasePage(WebDriver driver) {
        super(driver);
        this.BASE_URL = System.getProperty("base.url", "https://otus.ru");
    }


    public void acceptCookies() {
        By okButtonLocator = By.cssSelector(okCookiesButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(okButtonLocator));
            okButton.click();
            logger.info("Куки приняты");
        } catch (Exception e) {
            logger.info("Ошибка при попытке принять куки: " + e.getMessage());
        }
    }

    public void open(String path) {
        driver.get(BASE_URL + path);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }
}
