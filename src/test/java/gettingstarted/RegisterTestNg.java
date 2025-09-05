package gettingstarted;

import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.Test;

public class RegisterTestNg {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        Page page = browser.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        page.getByText("New user? Signup").click();
        PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isDisabled();

        page.locator("#name").fill(faker.name().fullName());
        page.locator("#email").fill(faker.name().username() + "@email.com");
        page.locator("#password").fill("Test@1234");
//        page.locator("#confirmPassword").fill("Test@1234");

        String seleniumCheckbox = "xpath=//label[text()='Selenium']//preceding::input[1]";
        PlaywrightAssertions.assertThat(page.locator(seleniumCheckbox)).not().isChecked();
        page.locator(seleniumCheckbox).click();
        PlaywrightAssertions.assertThat(page.locator(seleniumCheckbox)).isChecked();

        String femaleRadio = ".gender2";
        page.locator(femaleRadio).check();
        PlaywrightAssertions.assertThat(page.locator(femaleRadio)).isChecked();


    }

}
