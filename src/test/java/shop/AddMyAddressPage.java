package shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMyAddressPage {
    private final WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-id_state")
    private WebElement stateInput;

    @FindBy(name = "postcode")
    private WebElement zipInput;

    @FindBy(name = "id_country")
    private WebElement countryInput;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(css = "button[type='submit']")
    private WebElement saveBtn;

    public AddMyAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterNewAddressData(String alias, String address, String city, String state, String zip, String country, String phone) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        stateInput.click();
        stateInput.sendKeys(state);

        zipInput.clear();
        zipInput.sendKeys(zip);

        countryInput.click();
        countryInput.sendKeys(country);

        phoneInput.clear();
        phoneInput.sendKeys(phone);

        saveBtn.click();

    }
}
