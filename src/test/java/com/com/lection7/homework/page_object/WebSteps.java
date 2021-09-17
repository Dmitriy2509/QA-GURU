package com.com.lection7.homework.page_object;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public WebSteps openPage() {
        open("https://github.com/");
        return this;
    }

    @Step("Ищем репозиторий: {repository}")
    public WebSteps searchRepository(String repository){
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository);
        $(".header-search-input").submit();
        return this;
    }

    @Step("Переходим в репозиторий: {repository}")
    public WebSteps openRepository(String repository) {
        $(linkText(repository)).click();
        return this;
    }

    @Step("Открываем раздел: {section}")
    public WebSteps openTab(String section) {
        $(partialLinkText(section)).click();
        return this;
    }

    @Step("Проверяем наличие Issues с номером")
    public WebSteps checkIssueIsDisplayed (String numberIssue) {
        $(By.xpath("//*[contains(text(),'" + numberIssue + "')]")).shouldBe(Condition.visible);
        return this;
    }
}
