package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTestng {
    private Browser browser;
    private Page page;

    @Test
    public void loginLogoutTest() {
        browser = Playwright.create().chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000)
        );
        page = browser.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");

        // Validate page title
        Assert.assertEquals(page.title(), "Learn Automation Courses");

        page.locator("#email1").fill("admin@email.com");
        page.getByPlaceholder("Enter Password").fill("admin@123");
        page.waitForTimeout(3000);
        page.getByRole(AriaRole.BUTTON).getByText("Sign in").click();

        // Validate Cart is visible
        Assert.assertTrue(page.getByText("Cart").first().isVisible());

        page.waitForTimeout(5000);
    }

    @AfterMethod
    public void tearDown() {
        if (page != null) page.close();
        if (browser != null) browser.close();
    }
}
