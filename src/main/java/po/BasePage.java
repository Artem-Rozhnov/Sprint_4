package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;
    public int standardWaitTime = 10;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    //кнопки
    public By orderButtonTop = By.xpath(".//button[@class='Button_Button__ra12g']");
    public By orderButtonBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

}
