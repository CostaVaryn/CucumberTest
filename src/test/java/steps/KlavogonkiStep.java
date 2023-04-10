package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KlavogonkiStep {
    private final SelenideElement closeWinButton = $x("//input[@value='Закрыть']");
    private final SelenideElement startGameButton = $x("//a[@id='host_start']");
    private final SelenideElement highlightWord = $x("//span[@id='typefocus']");
    private final SelenideElement inputField = $x("//input[@id='inputtext']");
    private final SelenideElement afterFocusWord = $x("//span[@id='afterfocus']");
    private final SelenideElement resultText = $x("//td[text()='Это вы']//ancestor-or-self::div//div[@class='stats']//div[2]/span/span");

    private String getCurrentWord() {
        return highlightWord.getText()
                .replaceAll("c", "с")
                .replaceAll("o", "о");
    }

    @When("Start the game")
    public void startTheGame() {
        closeWinButton.click();
        if (startGameButton.isDisplayed()) {
            startGameButton.click();
        }
    }

    @And("Waiting for the game to start")
    public void waitForGameStart() {
        highlightWord.click();
    }

    @And("Enter the highlighted word in a loop")
    public void enterWord() {
        while (true) {
            String currentWord = getCurrentWord();
            String afterFocusSymbol = afterFocusWord.getText();
            inputField.sendKeys(currentWord);
            if (afterFocusSymbol.equals(".")) {
                inputField.sendKeys(".");
                break;
            }
            inputField.sendKeys(Keys.SPACE);
        }
    }

    @Then("We fix that the game is over and there are more than {int} symbols per minutes")
    public void endGame(int minValue) {
        String result = resultText.getText();
        int resultNumber = Integer.parseInt(result);
        System.out.println("Number of characters per minute: " + resultNumber);
        assertTrue(resultNumber > minValue, "The current result was: " + resultNumber);
    }
}
