package data;

import org.openqa.selenium.By;

import java.util.List;

public class ForTestingCoursesData {

    public static final List<CourseData> COURSES = List.of(
            new CourseData(
                    By.cssSelector("h1.sc-1og4wiw-0.sc-s2pydo-1.iLVLDh.diGrSa"),
                    "Java QA Engineer. Professional",
                    By.cssSelector(".sc-s2pydo-3 > p:nth-child(1)"),
                    "Курс по автоматизированному тестированию на Java: продвинутые инструменты, " +
                            "новые карьерные возможности",
                    By.xpath("//div[@class='sc-3cb1l3-3 jeNzke']/descendant::p[position()=3]"),
                    "4 месяца",
                    By.xpath("//div[@class='sc-3cb1l3-3 jeNzke']/descendant::p[position()=4]"),
                    "Онлайн"
            ),
            new CourseData(
                    By.cssSelector("h1.sc-1og4wiw-0.sc-s2pydo-1.iLVLDh.diGrSa"),
                    "Python QA Engineer",
                    By.cssSelector(".sc-s2pydo-3 > p:nth-child(1)"),
                    "Курс по автоматизации тестирования на Python: освойте фреймворк PyTest, " +
                            "автоматизируйте тесты UI и API",
                    By.xpath("//div[@class='sc-3cb1l3-3 jeNzke']/descendant::p[position()=2]"),
                    "5 месяцев",
                    By.xpath("//div[@class='sc-3cb1l3-3 jeNzke']/descendant::p[position()=3]"),
                    "Онлайн"
            ),
            new CourseData(
                    By.cssSelector("h1.sc-1og4wiw-0.sc-s2pydo-1.iLVLDh.diGrSa"),
                    "Game QA Engineer",
                    By.cssSelector(".sc-s2pydo-3 > p:nth-child(1)"),
                    "Научитесь с нуля тестировать игры на платформах:\n" +
                            "iOS, Android, PlayStation, Xbox, Switch и PC",
                    By.xpath("//div[@class='sc-3cb1l3-3 jeNzke']/descendant::p[position()=2]"),
                    "4 месяца",
                    By.xpath("//div[@class='sc-3cb1l3-3 jeNzke']/descendant::p[position()=3]"),
                    "Онлайн"
            ),
            new CourseData(
                    By.cssSelector("h1.sc-1og4wiw-0.sc-s2pydo-1.iLVLDh.diGrSa"),
                    "Нагрузочное тестирование",
                    By.cssSelector(".sc-s2pydo-3 > p:nth-child(1)"),
                    "Обучение затрагивает все аспекты нагрузочного тестирования: составляйте методику НТ," +
                            " разрабатывайте скрипты, запускайте тесты и настраивайте мониторинг",
                    By.xpath("//div[@class='sc-3cb1l3-3 jeNzke']/descendant::p[position()=2]"),
                    "3 месяца",
                    By.xpath("//div[@class='sc-3cb1l3-3 jeNzke']/descendant::p[position()=3]"),
                    "Онлайн"
            )
    );

    public static CourseData getCourseData(int index) {
        return COURSES.get(index);
    }
}
