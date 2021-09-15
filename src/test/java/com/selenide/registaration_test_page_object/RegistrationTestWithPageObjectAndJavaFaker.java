package com.selenide.registaration_test_page_object;

import com.pageObjectPages.RegistrationPage;
import com.selenide.registaration_test_page_object.component.CalendarComponent;
import org.junit.jupiter.api.Test;

import static com.selenide.registaration_test_page_object.TestData.*;

public class RegistrationTestWithPageObjectAndJavaFaker extends TestBase {

    TestDataFaker testDataFaker = new TestDataFaker();
    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent calendarComponent = new CalendarComponent();

    @Test
    public void registrationWithPageObjectTest() {
        registrationPage
                .openPage()
                .setFirstName(testDataFaker.firstName)
                .setLastName(testDataFaker.lastName)
                .setEmail(testDataFaker.email)
                .clickMaleRadioBtn()
                .setMobilePhone(testDataFaker.mobilePhone);

        calendarComponent.setData("25", "September", "1988");
        registrationPage.setSubjectField(subjects)
                .clickSportCheckBoxField()
                .uploadPicture(pathFile)
                .setCurrentAddress(testDataFaker.currentAddress)
                .chooseNcrOption()
                .chooseDelhiOption()
                .clickSubmitBtn();
    }
}
