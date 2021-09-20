package com.lection1.senenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkTest {

    //locators for 'dragAndDropActionTest' and 'dragAndDropTest'
    private SelenideElement figureA = $(By.xpath("//*[@id='column-a']"));
    private SelenideElement figureB = $(By.xpath("//*[@id='column-b']"));

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @AfterAll
    static void endTests() {
        closeWebDriver();
    }

    @Test
    public void githubSelenideTest() {
        open("https://github.com/selenide/selenide");
        $x("//span[@data-content='Wiki']").click();
        $x("//*[@id='wiki-pages-filter']").click();
        $x("//*[@id='wiki-pages-filter']").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();
        $x("//*[contains(text(),'Using JUnit5 extend test class:')]").shouldBe(visible);
    }

    @Disabled
    @Test()
    public void dragAndDropActionTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().dragAndDrop(figureA, figureB).release().build().perform();
    }

    @Test
    public void dragAndDropTest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $(figureA).dragAndDropTo(figureB);
        $(figureA).shouldHave(text("B"));
        $(figureB).shouldHave(text("A"));
        $(figureA).dragAndDropTo(figureB);
        $(figureA).shouldHave(text("A"));
        $(figureB).shouldHave(text("B"));
    }

}
