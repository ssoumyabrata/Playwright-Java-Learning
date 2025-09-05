package gettingstarted;

import com.microsoft.playwright.*;

import java.util.List;

public class HandleMultiWindows {

    public static void main(String[] args) throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        Locator links = page.locator("//div[@class='social']//a");
        links.all().forEach(link -> link.click());
        List<Page> allPages = context.pages();
        for (Page p : allPages) {

            if (p.title().contains("Facebook")) {
                p.bringToFront();
                System.out.println("Found Facebook page: " + p.title());
                break;
            }
        }

    }

}
