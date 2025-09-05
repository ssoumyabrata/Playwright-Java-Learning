package gettingstarted;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.Base64;
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

            if (p.title().toLowerCase().contains("youtube")) {
                p.bringToFront();
                System.out.println("Found youtube page: " + p.title());
                page = p;
                break;
            }
        }


        byte[] arr1 = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot1.png")).setFullPage(true));
        byte[] arr2 = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot2.png")).setFullPage(false));
        System.out.println(Base64.getEncoder().encodeToString(arr1));
        page.close();
        browser.close();
    }





}
