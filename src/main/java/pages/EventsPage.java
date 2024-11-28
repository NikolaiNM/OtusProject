package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EventsPage extends AbsBasePage {

    private final String PAGE_URL = "";

    private final String allTypes = "span.dod_new-events-dropdown__input-selected";
    private final String typeEvents = "a.dod_new-events-dropdown__list-item[title='Открытый вебинар']";
    private final String calendarOfEvents = "a[href='https://otus.ru/events/near']";
    private final String buttonMenu = "button.sc-5n5sda-0.exrzoV";
    private final String typeVibinar = "Открытый вебинар";
    private final String checkingTypeOfVibinar = "//div[@class='dod_new-type__text']";
    private final String checkingDateOfVibinar = "//span[@class='dod_new-event__date-text']";

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        open(PAGE_URL);
    }

    public void clickButtonMenu() {
        clickButton(buttonMenu);
    }

    public void clickCalendarOfEvents() {
        clickButton(calendarOfEvents);
    }

    public void selectEventType() {
        clickButton(allTypes);
        clickButton(typeEvents);
    }


    public void scrollToEnd() {
        long previousHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
        while (true) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            try {
                Thread.sleep(500);  // Задержка между прокрутками
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.info("Поток был прерван при ожидании задержки.");
                break;
            }
            long currentHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
            if (currentHeight == previousHeight) {
                logger.info("Достигнут конец страницы.");
                break;
            }
            previousHeight = currentHeight;
        }
    }

    public void checkTextInElements() {
        List<WebElement> webinarElements = driver.findElements(By.xpath(checkingTypeOfVibinar));
        for (int i = 0; i < webinarElements.size(); i++) {
            WebElement element = webinarElements.get(i);
            String text = element.getText().trim();

            if (!text.equals(typeVibinar)) {
                logger.info("Ошибка: Элемент с индексом " + (i + 1) + " не содержит текст '" + typeVibinar + "'. Фактический текст: '" + text + "'");
                Assertions.fail("Текст элемента на индексе " + (i + 1) + " не совпадает с ожидаемым: '" + typeVibinar + "'. Фактический текст: '" + text + "'");
            }
        }
        logger.info("Все элементы содержат правильный текст '" + typeVibinar + "'");
    }

    public void checkDatesInElements() {
        List<WebElement> dateElements = driver.findElements(By.xpath(checkingDateOfVibinar));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy");// Формат: "25 ноября 2024"
        LocalDate currentDate = LocalDate.now();// Получаем текущую дату
        logger.info("Текущая дата: " + currentDate);

        for (int i = 0; i < dateElements.size(); i += 2) {
            WebElement dateElement = dateElements.get(i);
            String dateText = dateElement.getText().trim();// Получаем только дату
            LocalDate eventDate = parseDate(dateText, dateFormatter);// Преобразуем в формат d MMMM yyyy
            if (eventDate == null || eventDate.isBefore(currentDate)) {
                logger.info("Ошибка: Элемент с индексом " + (i + 1) + " содержит дату '" + dateText + "', которая раньше сегодняшней: '" + currentDate + "'.");
                Assertions.fail("Дата элемента на индексе " + (i + 1) + " '" + dateText + "' меньше текущей даты '" + currentDate + "'.");
            }
        }
        logger.info("Все даты на плитках не старше сегодняшней.");
    }

    private LocalDate parseDate(String dateText, DateTimeFormatter formatter) {
        try {
            int currentYear = LocalDate.now().getYear();// Получаем текущий год
            String fullDateText = dateText + " " + currentYear;// Добавляем год к дате
            LocalDate parsedDate = LocalDate.parse(fullDateText, formatter);// Парсим в гггг-мм-дд
            return parsedDate;
        } catch (Exception e) {
            logger.info("Ошибка при парсинге даты: " + dateText);
            return null;
        }
    }

}
