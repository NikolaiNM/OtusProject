import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.EventsPage;

public class EventsTest {

    private WebDriver driver;
    private EventsPage onPage;

    @BeforeEach
    public void init() {
        this.driver = WebDriverFactory.create();
        this.onPage = new EventsPage(driver);
        onPage.openPage();
        onPage.cookieAccess();

    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void checkingTypesOfEvents() {
        onPage.openPage();
        onPage.clickButtonMenu();
        onPage.clickCalendarOfEvents();
        onPage.selectEventType();
        onPage.scrollToEnd();
        onPage.checkTextInElements();
    }

    @Test
    public void validationOfDatesEvents() {
        onPage.openPage();
        onPage.clickButtonMenu();
        onPage.clickCalendarOfEvents();
        onPage.selectEventType();
        onPage.scrollToEnd();
        onPage.checkDatesInElements();
    }
}
