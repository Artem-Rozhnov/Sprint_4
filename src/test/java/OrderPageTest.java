import org.junit.Test;
import po.MainPage;
import po.OrderPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class OrderPageTest extends BaseTest{

    private OrderPage orderPage;
    private MainPage mainPage;
    private String orderCompletedSuccess = "Заказ оформлен";

    @Test
    public void testFillOderViaButtonTop() {
        orderPage = new OrderPage(driver);
        orderPage.clickOrderButtonTop();
        orderPage.fillNameFieldInput("Олег");
        orderPage.fillSurnameFieldInput("Смирнов");
        orderPage.fillAddressFieldInput("ул. Калиновская, 20, Москва");
        orderPage.selectSubwayStation("Сокол");
        orderPage.fillPhoneFieldInput("79996461111");
        orderPage.clickButtonNext();
        orderPage.selectDeliveryDate("11.10.2023");
        orderPage.selectRentLength("двое суток");
        orderPage.selectColorBlack();
        orderPage.fillCommentsForDeliveryGuy ("Быстрее");
        orderPage.pressSubmitButton();
        orderPage.pressYesButton();
        orderPage.popupMessage();
        String popupMessage = orderPage.popupMessage();
        assertTrue(popupMessage.contains(orderCompletedSuccess));

    }
    @Test
    public void testFillOderViaButtonBottom() {
        orderPage = new OrderPage(driver);
        mainPage = new MainPage(driver);
        mainPage.clickOrderButtonBottom();
        orderPage.fillNameFieldInput("Олег");
        orderPage.fillSurnameFieldInput("Смирнов");
        orderPage.fillAddressFieldInput("ул. Калиновская, 20, Москва");
        orderPage.selectSubwayStation("Сокол");
        orderPage.fillPhoneFieldInput("79996461111");
        orderPage.clickButtonNext();
        orderPage.selectDeliveryDate("11.12.2023");
        orderPage.selectRentLength("двое суток");
        orderPage.selectColorGrey();
        orderPage.fillCommentsForDeliveryGuy ("Быстрее");
        orderPage.pressSubmitButton();
        orderPage.pressYesButton();
        orderPage.popupMessage();
        String popupMessage = orderPage.popupMessage();
        assertTrue(popupMessage.contains(orderCompletedSuccess));

    }
    @Test
    public void testEmptyPhoneNumberError() {
        orderPage = new OrderPage(driver);
        orderPage.clickOrderButtonTop();
        orderPage.fillNameFieldInput("Олег");
        orderPage.fillSurnameFieldInput("Смирнов");
        orderPage.fillAddressFieldInput("ул. Калиновская, 20, Москва");
        orderPage.selectSubwayStation("Сокол");
        orderPage.pressSubmitButton();
        String errorMessagePhoneNumber = orderPage.getPhoneNumberFieldError();
        assertEquals("Введите корректный номер", errorMessagePhoneNumber);
    }
    @Test
    public void testEmptySubwayStationError() {
        orderPage = new OrderPage(driver);
        orderPage.clickOrderButtonTop();
        orderPage.fillNameFieldInput("Олег");
        orderPage.fillSurnameFieldInput("Смирнов");
        orderPage.fillAddressFieldInput("ул. Калиновская, 20, Москва");
        orderPage.pressSubmitButton();
        String errorSubwayStationError = orderPage.getSubwayStationError();
        assertEquals("Выберите станцию",errorSubwayStationError );
    }
    @Test
    public void testEmptyNameFieldError(){
        orderPage = new OrderPage(driver);
        orderPage.clickOrderButtonTop();
        orderPage.fillNameFieldInput("");
        orderPage.pressSubmitButton();
        String errorMessageName = orderPage.getEmptyNameFieldErrorMessage();
        assertEquals("Введите корректное имя", errorMessageName);

    }
    @Test
    public void testEmptySurnameFieldError(){
        orderPage = new OrderPage(driver);
        orderPage.clickOrderButtonTop();
        orderPage.fillNameFieldInput("Олег");
        orderPage.fillSurnameFieldInput("");
        orderPage.pressSubmitButton();
        String errorMessageSurname = orderPage.getSurnameFieldError();
        assertEquals("Введите корректную фамилию",errorMessageSurname);
    }
    @Test
    public void testEmptyAddressFieldError() {
        orderPage = new OrderPage(driver);
        orderPage.clickOrderButtonTop();
        orderPage.fillNameFieldInput("Олег");
        orderPage.fillSurnameFieldInput("Смирнов");
        orderPage.fillAddressFieldInput("0");
        orderPage.pressSubmitButton();
        String errorAddressField = orderPage.getAddressFieldError();
        assertEquals("Введите корректный адрес", errorAddressField);
    }

    @Test
    public void testEmptyCommentsDeliveryField() {
        orderPage = new OrderPage(driver);
        orderPage.clickOrderButtonTop();
        orderPage.fillNameFieldInput("Олег");
        orderPage.fillSurnameFieldInput("Смирнов");
        orderPage.fillAddressFieldInput("ул. Калиновская, 20, Москва");
        orderPage.selectSubwayStation("Сокол");
        orderPage.fillPhoneFieldInput("79996461111");
        orderPage.clickButtonNext();
        orderPage.selectDeliveryDate("11.10.2023");
        orderPage.selectRentLength("двое суток");
        orderPage.selectColorBlack();
        orderPage.fillCommentsForDeliveryGuy ("");
        orderPage.pressSubmitButton();
        String errorCommentsDeliveryField = orderPage.getCommentsDeliveryFieldError();
        assertEquals("Тут что-то не так", errorCommentsDeliveryField);
    }

}