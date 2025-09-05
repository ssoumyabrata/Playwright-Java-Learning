package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAlert {

    public static void main(String[] args) {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onDialog(dialog -> {
            System.out.println(dialog.message());
            page.waitForTimeout(3000);
            dialog.accept("Hi I am text");
        });
        page.locator("xpath=//button[text()='Click for JS Prompt']").click();
        page.waitForTimeout(3000);
    }
}
