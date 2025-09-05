package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstPlaywrightTest {

    public static void main(String[] args) {
        try {
            Playwright pw = Playwright.create();
            BrowserType browserType = pw.chromium();
           // Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

            Page page = browser.newPage();

            page.navigate("https://automationexercise.com/");
            System.out.println("Title is  :" + page.title());

            page.close();
            browser.close();
            pw.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
