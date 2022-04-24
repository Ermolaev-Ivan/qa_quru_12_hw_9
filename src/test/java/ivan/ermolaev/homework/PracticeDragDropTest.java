package ivan.ermolaev.homework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeDragDropTest  {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void dragDrpoTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement elemFirst = $("#column-a");
        SelenideElement elemSecond = $("#column-b");

// Проверяем что все на находиться на своих местах
        elemFirst.$("header").shouldBe(text("A"));
        elemSecond.$("header").shouldBe(text("B"));

// Перетаскиваем элементы
        elemFirst.dragAndDropTo(elemSecond);

// Проверяем что перетаскивание сработало
        elemFirst.$("header").shouldBe(text("B"));
        elemSecond.$("header").shouldBe(text("A"));
    }
}
