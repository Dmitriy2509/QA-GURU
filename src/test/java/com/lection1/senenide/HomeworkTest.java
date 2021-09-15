package com.lection1.senenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkTest {

    public static final String BASE_URL_GITHUB_SELENIDE = "https://github.com/selenide/selenide";
    public static final String BASE_URL_DRAG_AND_DROP_TEST = "https://the-internet.herokuapp.com/drag_and_drop";

    private By wikiTab = By.cssSelector("span[data-content='Wiki']");
    private By softAssertionLink = By.xpath("//div[@id='wiki-body']//a[contains(text(), 'Soft assertions')]");
    private By softAssertinPage = By.xpath("//div[@id='wiki-body']");
    SelenideElement figureA = $(By.xpath("//*[@id='column-a']"));
    SelenideElement figureB = $(By.xpath("//*[@id='column-b']"));

    private String junit = "JUnit5";
    private String exampleCodeFirst = "$(\"#first\").should(visible).click();";
    private String exampleCodeSecond = "$(\"#second\").should(visible).click();";
    private String locationA = "A";
    private String locationB = "B";

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
        open(BASE_URL_GITHUB_SELENIDE);
        $(wikiTab).shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        $(softAssertionLink).shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        $(softAssertinPage).shouldHave(text(junit), text(exampleCodeFirst), text(exampleCodeSecond));
    }

    @Disabled
    @Test()
    public void dragAndDropActionTest() {
        open(BASE_URL_DRAG_AND_DROP_TEST);
        actions().dragAndDrop(figureA, figureB).release().build().perform();
    }

    @Test
    public void dragAndDropTest() {
        open(BASE_URL_DRAG_AND_DROP_TEST);
        $(figureA).dragAndDropTo(figureB);
        $(figureA).shouldHave(text(locationB));
        $(figureB).shouldHave(text(locationA));
        $(figureA).dragAndDropTo(figureB);
        $(figureA).shouldHave(text(locationA));
        $(figureB).shouldHave(text(locationB));
    }

}
