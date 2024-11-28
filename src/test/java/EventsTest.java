import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.EventsPage;

public class EventsTest {

    private WebDriver driver;
    private EventsPage onPage;

    private final String allTypes = "span.dod_new-events-dropdown__input-selected";
    private final String typeEvents = "a.dod_new-events-dropdown__list-item[title='Открытый вебинар']";
    private final String calendarOfEvents = "a[href='https://otus.ru/events/near']";
    private final String buttonMenu = "button.sc-5n5sda-0.exrzoV";
    private final String typeVibinar = "Открытый вебинар";

    private final String PAGE_URL = "";


    @BeforeEach
    public void init() {
        this.driver = WebDriverFactory.create();
        this.onPage = new EventsPage(driver);
        onPage.open(PAGE_URL);
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
        onPage.clickButton(buttonMenu);
        onPage.clickButton(calendarOfEvents);
        onPage.clickButton(allTypes);
        onPage.clickButton(typeEvents);
        onPage.scrollToEnd();
        onPage.checkTextInElements(typeVibinar);
    }

    @Test
    public void validationOfDatesEvents() {
        onPage.clickButton(buttonMenu);
        onPage.clickButton(calendarOfEvents);
        onPage.clickButton(allTypes);
        onPage.clickButton(typeEvents);
        onPage.scrollToEnd();
        onPage.checkDatesInElements();
    }


}
