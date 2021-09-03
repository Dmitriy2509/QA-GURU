import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationTest {

    public static final String URL_REGISTRATION = "https://demoqa.com/automation-practice-form";
    private By firstNameField = By.cssSelector("#firstName");
    private By lastNameField = By.cssSelector("#lastName");
    private By emailField = By.cssSelector("#userEmail");
    private By mobileNumberField = By.cssSelector("#userNumber");
    private By genderMaleRadioBtn = By.xpath("//*[contains(text(), 'Male')]");
    private By dateOfBirthField = By.cssSelector("#dateOfBirthInput");
    private By chooseMonth = By.cssSelector(".react-datepicker__month-select");
    private By chooseYear = By.className("react-datepicker__year-select");
    private By date = By.xpath("//*[text() = '25']");
    private By subjectsField = By.cssSelector("#subjectsInput");
    private By sportCheckbox= By.xpath("//label[@class = 'custom-control-label'] [contains(text(), 'Sports')]");
    private By readingCheckbox= By.xpath("//label[@class = 'custom-control-label'] [contains(text(), 'Reading')]");
    private By currentAddressField = By.cssSelector("#currentAddress");
    private By selectStateDropdownMenu = By.cssSelector("#stateCity-wrapper #state .css-1wa3eu0-placeholder");
    private By optionNcr = By.xpath("//div[contains(@class, ' css-11unzgr')]//div[contains(text(), 'NCR')]");
    private By selectCityDropdownMenu = By.cssSelector("#city");
    private By optionDelhi = By.xpath("//div[contains(@class, 'css-11unzgr')]//div[contains(text(), 'Delhi')]");
    private By submitBtn = By.cssSelector("#submit");
    private By nameOnTheForm = By.xpath("//tr/td[text()='Student Name']/following-sibling::td[contains(text(), 'Dmitriy Qwerty')]");


    private String firstName = "Dmitriy";
    private String lastName = "Qwerty";
    private String email = "somemail@gmail.com";
    private String mobilePhone = "380954436790";
    private String monthOfBirth = "September";
    private String year = "1988";
    private String subjects = "Computer Science";
    private String currentAddress = "Some address";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void studentRegistrationTest() {
        open(URL_REGISTRATION);
        $(firstNameField).setValue(firstName);
        $(lastNameField).setValue(lastName);
        $(emailField).setValue(email);
        $(genderMaleRadioBtn).click();
        $(mobileNumberField).setValue(mobilePhone);
        $(dateOfBirthField).click();
        $(chooseMonth).click();
        $(chooseMonth).selectOption(monthOfBirth);
        $(chooseYear).click();
        $(chooseYear).selectOption(year);
        $(date).click();
        $(subjectsField).click();
        $(subjectsField).sendKeys(subjects);
        $(subjectsField).pressEnter();
        $(sportCheckbox).click();
        $(readingCheckbox).click();
        $(currentAddressField).setValue(currentAddress);
        $(selectStateDropdownMenu).scrollIntoView(true);
        $(selectStateDropdownMenu).click();
        $(optionNcr).click();
        $(selectCityDropdownMenu).click();
        $(optionDelhi).click();
        $(submitBtn).click();
        $(nameOnTheForm).shouldBe(Condition.visible);
    }
}
