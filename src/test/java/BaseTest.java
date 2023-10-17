import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import po.BasePage;


public class BaseTest {
    public static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    protected WebDriver driver;

    @Before
    public void setUp() {
        setUpDriver("chrome"); // chrome OR firefox
        driver.manage().window().maximize();
        driver.get(MAIN_PAGE_URL);
        // Закрывать блок cookies внизу страницы
        BasePage basePage = new BasePage(driver);
        basePage.closedCookies();

    }

    private void setUpDriver(String browser) {
        if ("chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}