package stepDefinition;

import Pages.Locators.RentCar;
import Pages.base.Base_PO;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class RentalCar_Steps extends Base_PO {

    private WebDriver driver = getDriver();

    private RentCar rentCar;

    public RentalCar_Steps(RentCar rentCar){
        this.rentCar = rentCar;
    }


    @Given("I enter a Miles car rental page")
    public void i_enter_a_miles_car_rental_page() {
        rentCar.navigate_to_milesPage();
    }
    @When("I enter  a place when pick up the car")
    public void i_enter_a_place_when_pick_up_the_car() {
       rentCar.setPickupLocate();
    }
    @When("I select the start day")
    public void i_select_the_start_day() {
        rentCar.setCalendar();
    }
    @When("serch the car")
    public void serch_the_car() {
      rentCar.clickSearch();
    }
    @When("I select the second car")
    public void i_select_the_second_car() {
       rentCar.setSelect_car();
    }
    @When("I enter a full name")
    public void i_enter_a_full_name() {
        rentCar.setName();
    }
    @When("I enter a phone number")
    public void i_enter_a_phone_number() {
       rentCar.setPhone();
    }
    @When("I enter a email")
    public void i_enter_a_email() {
       rentCar.setEmail();
    }
    @When("I made click in next button")
    public void i_made_click_in_next_button() {
      rentCar.setBtnNext();
    }
    @Then("Validate the method pay")
    public void validate_the_method_pay() {
        rentCar.assertText();
    }
}
