package gettingstarted;

import com.microsoft.playwright.*;

public class HandleNewTab {

    public static void main(String[] args) {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        Page facebookPage = context.waitForPage(() -> {
            page.locator("xpath=//a[contains(@href,'facebook')]").first().click();
        });

        facebookPage.locator("//input[@name='email']").last().fill("myfbemail.com");

        page.bringToFront();
        page.fill("xpath=//input[@id='email1']", "myemail.com");

    }
}
