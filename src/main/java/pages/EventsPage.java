package pages;

import org.openqa.selenium.*;

public class EventsPage extends AbsBasePage {

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

}
