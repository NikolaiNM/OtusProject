package enums;

import org.openqa.selenium.By;

public enum ForTestingCourse {
    COURSE1(
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
            )
    ),
    COURSE2(
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
            )
    ),
    COURSE3(
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
            )
    ),
    COURSE4(
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

    private CourseData courseData;

    ForTestingCourse(CourseData courseData) {
        this.courseData = courseData;
    }

    public CourseData getCourseData() {
        return courseData;
    }

    public static class CourseData {
        private By nameSelector;
        private String name;
        private By descriptionSelector;
        private String description;
        private By durationSelector;
        private String duration;
        private By formatSelector;
        private String format;

        public CourseData(By nameSelector, String name, By descriptionSelector, String description,
                          By durationSelector, String duration, By formatSelector, String format) {
            this.nameSelector = nameSelector;
            this.name = name;
            this.descriptionSelector = descriptionSelector;
            this.description = description;
            this.durationSelector = durationSelector;
            this.duration = duration;
            this.formatSelector = formatSelector;
            this.format = format;
        }

        public By getNameSelector() {
            return nameSelector;
        }

        public String getName() {
            return name;
        }

        public By getDescriptionSelector() {
            return descriptionSelector;
        }

        public String getDescription() {
            return description;
        }

        public By getDurationSelector() {
            return durationSelector;
        }

        public String getDuration() {
            return duration;
        }

        public By getFormatSelector() {
            return formatSelector;
        }

        public String getFormat() {
            return format;
        }
    }
}
