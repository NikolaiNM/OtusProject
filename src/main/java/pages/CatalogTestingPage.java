package pages;

import enums.ForTestingCourse;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CatalogTestingPage extends AbsBasePage {

    private int numberOfCourses = 11;
    private String allCounts = "div.sc-18q05a6-1.bwGwUO [class^=\"sc-zzdkm7-0\"]";
    private String showMoreButton = "button.sc-mrx253-0.enxKCy.sc-prqxfo-0.cXVWAS";



    public CatalogTestingPage(WebDriver driver) {
        super(driver);
    }

    public void clickShowMoreButton() {
        By showMoreButtonLocator = By.cssSelector(showMoreButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            while (true) {
                WebElement showMoreButton = wait.until(ExpectedConditions.elementToBeClickable(showMoreButtonLocator));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreButton);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreButton);
                logger.info("Нажали на кнопку 'Показать еще' через JavaScript");

                Thread.sleep(1000);

                try {
                    WebElement refreshedButton = driver.findElement(showMoreButtonLocator);
                    if (!refreshedButton.isDisplayed()) {
                        logger.info("Кнопка больше не найдена.");
                        break;
                    }
                } catch (NoSuchElementException e) {

                    logger.info("Кнопка больше не найдена.");
                    break;
                }
            }
        } catch (TimeoutException e) {
            logger.info("Не удалось найти кнопку 'Показать еще' за 3 секунды.");
        } catch (Exception e) {
            logger.info("Ошибка: " + e.getMessage());
        }
    }

    public void assertCount(By locator, int count) {
        List<WebElement> countOfElements = findElements(locator);
        int expectedCount = countOfElements.size();
        Assertions.assertEquals(count, expectedCount);
    }

    public void countOfCourses() {
        assertCount(By.cssSelector(allCounts), numberOfCourses);
        logger.info("Количество курсов равно {} и соответствует ожидаемому", allCounts);
    }

    public void clickElementByIndex(int index) {
        // Используем переменную класса allCounts для локатора
        List<WebElement> elements = findElements(By.cssSelector(allCounts));

        // Проверяем, что индекс не выходит за пределы списка
        if (index >= 0 && index < elements.size()) {
            WebElement element = elements.get(index);

            // Скроллим к элементу
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

            // Кликаем по нужному элементу
            element.click();
        } else {
            logger.info("Некорректный индекс: " + index);
        }
    }

    public void checkText(By selector, String value) {
        // Ожидаем присутствие элемента в DOM
        WebElement element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(selector));

        // Ожидаем, что элемент будет видимым
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

        // Проверяем, что текст элемента совпадает с ожидаемым значением
        Assertions.assertEquals(value, element.getText().trim());

        // Логируем успешную проверку
        logger.info("Текст элемента соответствует ожидаемому значению \"{}\"", value);
    }

    public ForTestingCourse.CourseData getCourseData(int index) {
        // Получаем курс по индексу
        ForTestingCourse courseEnum = ForTestingCourse.values()[index];
        return courseEnum.getCourseData();
    }

    public WebElement getElement(By selector) {
        return driver.findElement(selector);
    }
}
