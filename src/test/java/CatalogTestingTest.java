import enums.ForTestingCourse;
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

    @BeforeEach
    public void init() {
        this.driver = WebDriverFactory.create();
        this.onPage = new CatalogTestingPage(driver);
        onPage.open("/categories/testing/");
        //onPage.open("/catalog/courses?categories=programming");
        //onPage.open("/catalog/courses?categories=gamedev&difficulty_levels=advanced");
    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void countCourses() {
        onPage.acceptCookies();
        onPage.clickShowMoreButton();
        onPage.countOfCourses();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,3})  // Пример с индексом 3
    public void checkingCoursesCard(int index) {
        onPage.acceptCookies();
        onPage.clickShowMoreButton();
        onPage.clickElementByIndex(index);

        // Получаем курс по индексу через метод getCourseData()
        ForTestingCourse.CourseData course = onPage.getCourseData(index);

        // Проверяем текст для выбранного курса
        onPage.checkText(course.getNameSelector(), course.getName());
        onPage.checkText(course.getDescriptionSelector(), course.getDescription());
        onPage.checkText(course.getDurationSelector(), course.getDuration());
        onPage.checkText(course.getFormatSelector(), course.getFormat());
    }

}

