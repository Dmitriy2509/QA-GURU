package com.selenide.registaration_test_page_object;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
}
