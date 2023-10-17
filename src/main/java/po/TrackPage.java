package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TrackPage extends BasePage {

    // Картинка заказ не найден
    private final By notFoundImg = By.cssSelector("div.Track_NotFound__6oaoY >img");

    public TrackPage(WebDriver driver) {
        super(driver);
    }


}
