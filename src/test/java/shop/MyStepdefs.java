package shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MyStepdefs {
    private WebDriver driver;
    AddMyAddressPage addMyAddressPage;

    @Given("I am logged in as {string} with password {string}")
    public void iAmLoggedInAsWithPassword(String email, String password) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @When("I go to the Addresses page")
    public void iGoToTheAddressesPage() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToAddresses();
    }

    @And("I click on Create new address button")
    public void iClickOnCreateNewAddressButton() {
        AddressPage addressPage= new AddressPage(driver);
        addressPage.addNewAddress();
    }

    @And("I fill in the new address form with {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void iFillInTheNewAddressFormWithAnd(String alias, String address, String city, String state, String zip, String country, String phone) {
        AddMyAddressPage addMyAddressPage = new AddMyAddressPage(driver);
        addMyAddressPage.enterNewAddressData(alias, address, city, state, zip, country, phone);
    }

    @Then("I should see the new address on the Addresses page")
    public void iShouldSeeTheNewAddressOnTheAddressesPage() {
        AddressPage addressPage = new AddressPage(driver);
        Assertions.assertTrue(addressPage.addressIsVisible(), "Adres nie został poprawnie zapisany");
    }

    @And("I click on Delete button for address")
    public void iClickOnDeleteButtonForAddress() {
        AddressPage addressPage = new AddressPage(driver);
        addressPage.deleteAddress();
    }

    @Then("I should not see an additional address on the Addresses page")
    public void iShouldNotSeeTheAddressOnTheAddressesPage() {
        AddressPage addressPage = new AddressPage(driver);
        Assertions.assertTrue(!addressPage.addressIsVisible(),"Adresy dodatkowe nie zostały usunięte");
    }
}
