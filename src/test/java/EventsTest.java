import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.EventsPage;

public class EventsTest {

    private WebDriver driver;
    private EventsPage onPage;

    @BeforeEach
    public void init() {
        this.driver = WebDriverFactory.create();
        this.onPage = new EventsPage(driver);
        onPage.open("/events/near/open_lesson/");
        onPage.setCookieAccept();

    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

//    @Test
//    public void checkDate() {
//
//    }

//    <div class="dod_new-loader-wrapper js-dod_new-loader-wrapper dod_new-loader-wrapper_visible">
//                    <div class="dod_new-loader"></div>
//                </div>
}
