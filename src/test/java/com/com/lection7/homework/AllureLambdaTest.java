package com.com.lection7.homework;

import com.codeborne.selenide.Condition;
import com.selenide.registaration_test_page_object.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AllureLambdaTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "68";

    @Test
    public void lambdaIssueTest() {

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем раздел Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем наличие Issues с номером " + ISSUE_NUMBER , () -> {
            $(By.xpath("//*[contains(text(),'" + ISSUE_NUMBER + "')]")).shouldBe(Condition.visible);
        });
    }
}
