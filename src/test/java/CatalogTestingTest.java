import data.CourseData;
import data.ForTestingCoursesData;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import pages.CatalogTestingPage;

public class CatalogTestingTest {

    private WebDriver driver;
    private CatalogTestingPage onPage;

    private final String PAGE_URL = "/categories/testing/";

    @BeforeEach
    public void init() {
        this.driver = WebDriverFactory.create();
        this.onPage = new CatalogTestingPage(driver);
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
    public void test1() {
        onPage.clickShowMoreButton();
        onPage.countOfCourses();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,3})
    public void test2(int index) {
        onPage.clickShowMoreButton();
        onPage.clickElementByIndex(index);

        CourseData course = ForTestingCoursesData.getCourseData(index);

        onPage.checkText(course.getNameSelector(), course.getName());
        onPage.checkText(course.getDescriptionSelector(), course.getDescription());
        onPage.checkText(course.getDurationSelector(), course.getDuration());
        onPage.checkText(course.getFormatSelector(), course.getFormat());
    }

}

