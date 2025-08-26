package cucumberOptions;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;

import commons.GlobalConstants;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.safari.SafariDriver;

public class Hooks {
    // Run for many thread
    private static WebDriver driver;
    private static final Logger log = Logger.getLogger(Hooks.class.getName());

    @Before // synchronized = handle đồng bộ
    public synchronized static WebDriver openAndQuitBrowser() {
        // Run by Maven command line
        String browser = System.getProperty("BROWSER");
        System.out.println("Browser name run by command line = " + browser);

        // Check driver đã được khởi tạo hay chưa?
        if (driver == null) {

            // Happy path case
            try {
                // Kiem tra BROWSER = null -> gan = chrome/ firefox (browser default for project)
                if (browser == null) {
                    // Get browser name from Environment Variable in OS
                    browser = System.getenv("BROWSER");
                    if (browser == null) {
                        // Set default browser
                        browser = "chrome";
                    }
                }

                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.setExperimentalOption("useAutomationExtension", false);
                        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                        options.addArguments("--disable-notifications");
                        options.addArguments("--disable-geolocation");

                        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                        chromePrefs.put("profile.default_content_settings.popups", 0);
                        // Disable "Save password" prompt
                        chromePrefs.put("credentials_enable_service", false);
                        chromePrefs.put("profile.password_manager_enabled", false);
                        // Disable payment method autofill
                        chromePrefs.put("autofill.credit_card_enabled", false);
                        // Disable address autofill
                        chromePrefs.put("autofill.profile_enabled", false);

                        options.setExperimentalOption("prefs", chromePrefs);
                        System.setProperty("webdriver.chrome.args", "--disable-logging");
                        System.setProperty("webdriver.chrome.silentOutput", "true");
                        driver = new ChromeDriver(options);
                        break;
                    case "hchrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless=new");
                        chromeOptions.addArguments("window-size=1920x1080");
                        driver = new ChromeDriver(chromeOptions);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "hfirefox":
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--headless=new");
                        driver = new FirefoxDriver(firefoxOptions);
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    case "safari":
                        WebDriverManager.safaridriver().setup();
                        driver = new SafariDriver();
                        break;
                    default:
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                }
                // Browser crash/ stop
            } catch (UnreachableBrowserException e) {
                driver = new ChromeDriver();
                // Driver crash
            } catch (WebDriverException e) {
                driver = new ChromeDriver();
            }
            // Code này luôn luôn được chạy dù pass hay fail
            finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }

            driver.get(GlobalConstants.LIVE_USER_URL);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
            log.info("------------- Started the browser -------------");
        }
        return driver;
    }

    public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
                log.info("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Can not close the browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

}
