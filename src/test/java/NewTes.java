import factory.WebDriverFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.NewPage;

import java.util.List;

public class NewTes {

    private WebDriver driver;
    private NewPage onPage;

    @BeforeEach
    public void init() {
        this.driver = WebDriverFactory.create();
        this.onPage = new NewPage(driver);
        //onPage.open("/categories/testing/");
        onPage.open("/catalog/courses?categories=programming");
        //onPage.open("/catalog/courses?categories=gamedev&difficulty_levels=advanced");
    }

//    @AfterEach
//    public void close() {
//        if (this.driver != null) {
//            this.driver.quit();
//        }
//    }

    @Test
    public void extractCourseNames() {
        onPage.acceptCookies(); // Принимаем куки
        String parentLocator = "div.sc-18q05a6-1.bwGwUO"; // Локатор родительских элементов

        // Вызов метода с правильным названием через объект onPage
        List<String> courseNames = onPage.extractTextsByTraversal(parentLocator);

        // Выводим названия курсов в консоль
        for (String name : courseNames) {
            System.out.println("Курс: " + name);
        }
    }

//    @Test
//    public void chekingCoursesCard() {
//        onPage.acceptCookies();
//        onPage.clickShowMoreButton();
//        onPage.countOfCourses();
//
//    }

}