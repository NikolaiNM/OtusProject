package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class NewPage extends AbsBasePage{



    public NewPage(WebDriver driver) {
        super(driver);
    }

    public List<String> extractTextsByTraversal(String parentLocator) {
        List<String> courseNames = new ArrayList<>(); // Список для хранения названий курсов

        // Ищем родительские элементы по локатору
        List<WebElement> parentElements = driver.findElements(By.cssSelector(parentLocator));

        System.out.println("Найдено родительских элементов: " + parentElements.size());

        // Проходим по каждому родительскому элементу
        for (int i = 0; i < parentElements.size(); i++) {
            WebElement parent = parentElements.get(i);
            System.out.println("Обработка родительского элемента №" + (i + 1));

            // Ищем вложенные элементы, содержащие текст курсов
            try {
                WebElement courseElement = parent.findElement(By.cssSelector("h6 .sc-hrqzy3-1.jEGzDf")); // Локатор для названия курса
                String courseName = courseElement.getText();
                System.out.println("Текст найденного элемента: " + courseName);

                if (!courseName.isEmpty()) {
                    courseNames.add(courseName); // Добавляем текст в список
                }
            } catch (NoSuchElementException e) {
                System.out.println("Вложенный элемент не найден в родительском элементе №" + (i + 1));
            }
        }

        System.out.println("Общее количество найденных текстов: " + courseNames.size());
        return courseNames; // Возвращаем список текстов
    }


}
