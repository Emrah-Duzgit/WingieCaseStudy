package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }


    @FindBy(css = "[aria-describedby=\"Gidiş-dönüş\"]")
    private WebElement gidisDonus;

    @FindBy(css = "[data-testid=\"flight-origin-label\"]")
    private WebElement departureFlight;

    @FindBy(css = "[data-testid=\"endesign-flight-origin-autosuggestion-input\"]")
    private WebElement selectDepartureFlight;

    @FindBy(css = "[data-testid=\"flight-destination-label\"]")
    private WebElement arrivalFlight;

    @FindBy(css = "[data-testid=\"endesign-flight-destination-autosuggestion-input\"]")
    private WebElement selectArrivalFlight;

    @FindBy(css = "[data-testid=\"enuygun-homepage-flight-departureDate-datepicker-input\"]")
    private WebElement departureDate;

    @FindBy(css = "[data-testid=\"enuygun-homepage-flight-returnDate-label\"]")
    private WebElement arrivalDate;

    @FindBy(css = "[data-testid=\"datepicker-active-day\"]")
    private List<WebElement> departureDatePicker;

    @FindBy(css = "[data-testid=\"datepicker-active-day\"]")
    private List<WebElement> arrivalDatePicker;

    @FindBy(css = "[data-testid=\"enuygun-homepage-flight-submitButton\"]")
    private WebElement submitBtn;

    @FindBy(css = "[data-testid=\"flight-oneWayCheckbox-text\"]")
    private WebElement directFlights;

    @FindBy(css = "[data-testid=\"undefined-popover-button\"]")
    private WebElement passengerSelector;

    @FindBy(css = "[data-testid=\"flight-adult-counter-plus-button\"]")
    private WebElement adultPlusBtn;

    @FindBy(css = "[data-testid=\"flight-child-counter-plus-button\"]")
    private WebElement childPlusBtn;
    @FindBy(css = "[data-testid=\"flight-infant-counter-plus-button\"]")
    private WebElement infantPlusBtn;

    @FindBy(css = "[data-testid=\"enuygun-homepage-flight-ekonomiCabin\"]")
    private WebElement economy;

    @FindBy(css = "[data-testid=\"enuygun-homepage-flight-businessCabin\"]")
    private WebElement business;

    @FindBy(xpath = "//div[@class='header-summary']")
    private WebElement validation;

    WebElement myElement;




    public void findAndClick(String strElement) {
        switch (strElement) {
            case "gidisDonus":
                myElement = gidisDonus;
                break;
            case "departureFlight":
                myElement = departureFlight;
                break;
            case "arrivalFlight":
                myElement = arrivalFlight;
                break;
            case "departureDate":
                myElement = departureDate;
                break;
            case "arrivalDate":
                myElement = arrivalDate;
                break;
            case "submitBtn":
                myElement = submitBtn;
                break;
            case "directFlights":
                myElement = directFlights;
                break;
            case "passengerSelector":
                myElement = passengerSelector;
                break;
            case "business":
                myElement = business;
                break;
            case "economy":
                myElement = economy;
                break;
        }

        clickFunction(myElement);
    }


    public void findAndContainsText(String strElement, String text){  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement)
        {
            case "validation" : myElement =validation; break;

        }

        verifyContainsText(myElement,text);
    }


    public void findAndSend(String strElement, String value) {
        switch (strElement) {
            case "selectDepartureFlight":
                myElement = selectDepartureFlight;
                break;
            case "selectArrivalFlight":
                myElement = selectArrivalFlight;
                break;

        }

        sendKeysFunction(myElement, value);


    }

    public void parametricallySelectADepartureDate(int number) {

        waitUntilClickable(departureDatePicker.get(number));
        if (!departureDatePicker.get(number).isDisplayed()) {
            scrollToElement(departureDatePicker.get(number));
        }
        departureDatePicker.get(number).click();


    }

    public void selectPassengersAmount(int number) {
        waitUntilClickable(adultPlusBtn);
        if (!adultPlusBtn.isDisplayed()) {
            scrollToElement(adultPlusBtn);
        }
        for (int i = 0; i < number; i++) {
            adultPlusBtn.click();
        }

    }


    public void parametricallySelectAArrivalDate(int number) {
        waitUntilClickable(arrivalDatePicker.get(number));
        if (!arrivalDatePicker.get(number).isDisplayed()) {
            scrollToElement(arrivalDatePicker.get(number));
        }
        arrivalDatePicker.get(number).click();
    }

    public void selectChildPassengersAmount(int number) {
        waitUntilClickable(childPlusBtn);
        if (!childPlusBtn.isDisplayed()) {
            scrollToElement(childPlusBtn);
        }
        for (int i = 0; i < number; i++) {
            childPlusBtn.click();
        }

    }

    public void selectInfantPassengersAmount(int number) {
        waitUntilClickable(infantPlusBtn);
        if (!infantPlusBtn.isDisplayed()) {
            scrollToElement(infantPlusBtn);
        }
        for (int i = 0; i < number; i++) {
            infantPlusBtn.click();
        }
    }
}
