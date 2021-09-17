package com.com.lection7.homework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.selenide.registaration_test_page_object.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AllureSimpleTest extends TestBase {

    @Test
    public void simpleIssueTest() {
        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example");
        $(".header-search-input").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();
        $(By.xpath("//*[contains(text(), '68')]")).shouldBe(Condition.visible);
    }
}
