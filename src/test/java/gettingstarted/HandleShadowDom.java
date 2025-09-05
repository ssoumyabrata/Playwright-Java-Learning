package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class HandleShadowDom {

    public static void main(String[] args) {

        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practise-page/");
        // Xpath does not work for shadow DOM. Only CSS Selector works.
        // Another way to write = page.locator("#username).locator("#kils").fill("Joy Name");
        page.locator("#username #kils").fill("Joy Name");

    }
}
