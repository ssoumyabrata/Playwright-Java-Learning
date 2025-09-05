package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class LoginLogout {
    static Browser browser = null;
    static Page page = null;

    public static void main(String[] args) {

        try {
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            page = browser.newPage();
            page.navigate("https://freelance-learn-automation.vercel.app/login");
            PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");

            page.locator("#email1").fill("admin@email.com");
            //page.locator("xpath=//input[@name='email1]'").fill("admin@email.com");
            page.getByPlaceholder("Enter Password").fill("admin@123");
            page.waitForTimeout(3000);
            page.getByRole(AriaRole.BUTTON).getByText("Sign in").click();
            PlaywrightAssertions.assertThat(page.getByText("Cart").first()).isVisible();

            page.waitForTimeout(5000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            page.close();
            browser.close();
        }

    }
}
