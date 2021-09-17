package com.com.lection7.homework;

import com.com.lection7.homework.page_object.WebSteps;
import com.selenide.registaration_test_page_object.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AllureStepTest extends TestBase {

    @Test
    public void stepIssueTest() {

        WebSteps webSteps = new WebSteps();

        webSteps
                .openPage()
                .searchRepository("eroshenkoam/allure-example")
                .openRepository("eroshenkoam/allure-example")
                .openTab("Issues")
                .checkIssueIsDisplayed("68");
    }
}
