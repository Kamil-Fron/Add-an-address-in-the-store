package shop;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/add-address.feature", plugin = {"pretty", "html:out.html"})
public class ShopTest {
}
