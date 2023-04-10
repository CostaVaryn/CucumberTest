package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;

public class ApiSteps {
    private String var;

    public String getVar() {
        return var;
    }

    @When("^отправили запрос на ресурс \"([^\"]*)\"$")
    public void sendRequest(String url) {
        Selenide.open(url);
        var = String.valueOf(RestAssured.given().get(url).statusCode());
    }

    @When("^проверили, значение переменной равно 200$")
    public void checkStatus200() {
        Assertions.assertEquals("200", getVar());
    }

    @When("^проверили, значение переменной равно 400$")
    public void checkStatus400() {
        Assertions.assertEquals("400", getVar());
    }
}
