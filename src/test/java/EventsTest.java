import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.EventsPage;

public class EventsTest {

    private WebDriver driver;
    private EventsPage onPage;

    private String allTypes = "span.dod_new-events-dropdown__input-selected";
    private String typeEvents = "a.dod_new-events-dropdown__list-item[title='Открытый вебинар']";
    private String calendarOfEvents = "a[href='https://otus.ru/events/near']";
    private String buttonMenu = "button.sc-5n5sda-0.exrzoV";
    //private String allOpenVibinar = "div.dod_new-type__text";
    private String typeVibinar = "Открытый вебинар";


    @BeforeEach
    public void init() {
        this.driver = WebDriverFactory.create();
        this.onPage = new EventsPage(driver);
        onPage.open("");
        //onPage.open("/events/near/");
        onPage.cookieAccess();

    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void checkDate() {
        onPage.clickButton(buttonMenu);
        onPage.clickButton(calendarOfEvents);
        onPage.clickButton(allTypes);
        onPage.clickButton(typeEvents);
        onPage.scrollToEnd();
        onPage.checkTextInElements(typeVibinar);

//    }
//    @Test
//    public void test2() {
//        onPage.scrollToEnd();
//    }
//
    }
}
