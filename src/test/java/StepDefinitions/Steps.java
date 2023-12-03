package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class Steps {

    DialogContent dc = new DialogContent();




    @Given("Navigate to Enuygun Website")
    public void navigateToEnuygunWebsite() {
        GWD.getDriver().get("https://www.enuygun.com/");
        GWD.getDriver().manage().window().maximize();
    }

    @And("Click on desired flight trip on the screen")
    public void clickOnDesiredFlightTripOnTheScreen() {
        dc.findAndClick("gidisDonus");

    }

    @And("Click on the departure flight picker")
    public void clickOnTheDepartureFlightPicker() {
        dc.findAndClick("departureFlight");
    }

    @And("Parametrically Select a City For Departure")
    public void parametricallySelectACityForDeparture(DataTable elements) throws InterruptedException {
        List<List<String>> listElement = elements.asLists(String.class);

        for(int i=0;i<listElement.size();i++)
            dc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));
        Actions action = new Actions(GWD.getDriver());
        action.sendKeys(Keys.ENTER).build().perform();

    }


    @And("Parametrically Select a City For Arrival")
    public void parametricallySelectACityForArrival(DataTable elements) throws InterruptedException {
        List<List<String>> listElement = elements.asLists(String.class);

        for(int i=0;i<listElement.size();i++)
            dc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));
        Actions action = new Actions(GWD.getDriver());
        action.sendKeys(Keys.ENTER).build().perform();

    }

    @And("Select number of adult passengers")
    public void selectNumberOfAdultPassengers(int number) {
        dc.selectPassengersAmount(number);

    }

    @And("Click on number of passengers and flight class selector")
    public void clickOnNumberOfPassengersAndFlightClassSelector() {
        dc.findAndClick("passengerSelector");
    }

    @And("Click on the arrival flight picker")
    public void clickOnTheArrivalFlightPicker() {
        dc.findAndClick("arrivalFlight");
    }

    @And("Click on departure date picker")
    public void clickOnDepartureDatePicker() {
        dc.findAndClick("departureDate");
    }

    @FindBy(css = "[data-testid=\"datepicker-active-day\"]")
    public List<WebElement> datePicker;


    @And("Parametrically Select a Departure Date")
    public void parametricallySelectADepartureDate(int number) {
        dc.parametricallySelectADepartureDate(number);
    }

    @And("Parametrically Select a Arrival Date")
    public void parametricallySelectAArrivalDate(int number) {
        dc.parametricallySelectAArrivalDate(number);
    }

    @And("Click on arrival date picker")
    public void clickOnArrivalDatePicker() {
        dc.findAndClick("arrivalDate");
    }

    @When("Click on Submit Button")
    public void clickOnSubmitButton() {
        dc.findAndClick("submitBtn");
    }

    @And("Click on direct flight CheckBox")
    public void clickOnDirectFlightCheckBox() {
        dc.findAndClick("directFlights");
    }


    @And("Select number of child passengers")
    public void selectNumberOfChildPassengers(int number) {
        dc.selectChildPassengersAmount(number);
    }

    @And("Select number of infant passengers")
    public void selectNumberOfInfantPassengers(int number) {
        dc.selectInfantPassengersAmount(number);
    }

    @And("Select flight class")
    public void selectFlightClass(String flightClass) {
        dc.findAndClick(flightClass);

    }

    @Then("Validate User should be able to see all flight")
    public void validateUserShouldBeAbleToSeeAllFlight() {
        dc.findAndContainsText("validation", "tanesi gösteriliyor.");
    }
}




