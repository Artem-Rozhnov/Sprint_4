package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage {
    public static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    public int standardWaitTime = 10;
    //кнопки
    public By orderButtonTop = By.xpath(".//button[@class='Button_Button__ra12g']");
    public By orderButtonBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    public By cookiesButton = By.xpath(".//button[@id='rcc-confirm-button']");
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void closedCookies() {
        WebElement acceptCookiesButton = driver.findElement(cookiesButton);
        acceptCookiesButton.click();
    }

}
