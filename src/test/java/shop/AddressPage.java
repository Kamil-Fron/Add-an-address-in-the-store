package shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressPage {

    private final WebDriver driver;
    String id;
    //public String deleteBtn = "article.address#address-" + id + " a[data-link-action='delete-address']";


    @FindBy(css = "a[data-link-action='add-address']")
    private WebElement createNewAddressBtn;

    @FindBy(css = "article[data-alert='success'] li")
    private WebElement successAlert;

    @FindBy(css = "article.address")
    private List<WebElement> addresses;


    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddMyAddressPage addNewAddress() {
        createNewAddressBtn.click();
        return new AddMyAddressPage(driver);
    }

    public boolean addressIsVisible() {
        return addresses.size() > 1;
    }

    public String getIdOfAddresses() {
        WebElement firstAddress = addresses.get(1);
        return firstAddress.getAttribute("data-id-address");
    }


    public void deleteAddress() {
        this.id = getIdOfAddresses();
        WebElement deleteBtn = driver.findElement(By.cssSelector("article.address#address-" + this.id + " a[data-link-action='delete-address']"));
        deleteBtn.click();
    }

}
