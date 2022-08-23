Feature: Bot for the site klavogonki.ru

  Background: Finding on the main page of the site
    Given Opening the site "https://klavogonki.ru/go?type=normal"

  Scenario: The bot starts the game and enters the words
    When Start the game
    And Waiting for the game to start
    And Enter the highlighted word in a loop
    Then We fix that the game is over and there are more than 1500 symbols per minutes