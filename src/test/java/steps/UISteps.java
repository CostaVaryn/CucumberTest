package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UISteps {

    @When("^открыт сайт \"([^\"]*)\"$")
    public void openUrl(String url) {
        Selenide.open(url);
    }

    @When("^в поле \"([^\"]*)\" ввели значение \"([^\"]*)\"$")
    public void inputValue(String fieldName, String fieldValue) throws InterruptedException {
        String name;
        if (fieldName.equals("Login")) {
            name = "uid";
        } else {
            name = "password";
        }
        WebDriverRunner.getWebDriver().findElement(By.name(name)).sendKeys(fieldValue);
        // Thread.sleep(3000);
    }

    @When("^нажать кнопку \"([^\"]*)\"$")
    public void clickButton(String buttonName) {
        WebDriverRunner.getWebDriver().findElement(By.name(buttonName)).click();
    }

    @When("^адрес сайта равен \"([^\"]*)\"$")
    public void checkUrl(String url) {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(currentUrl, url);
    }

    @When("^проверяем пустоту полей$")
    public void checkResetEmpty() {
        String login = WebDriverRunner.getWebDriver().findElement(By.name("uid")).getText();
        String password = WebDriverRunner.getWebDriver().findElement(By.name("password")).getText();
        assertEquals("", login);
        assertEquals("", password);
    }
}
