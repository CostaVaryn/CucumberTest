Feature: Bot for the site klavogonki.ru

  # Нахожусь на главной странице сайта
  Background: Finding on the main page of the site
    # Открываем сайт
    Given Opening the site "https://klavogonki.ru/go?type=normal"

    # Бот запускает игру и вводит слова
  Scenario: The bot starts the game and enters the words
    # Начинается игра
    When Start the game
    # Ожидание начала игры
    And Waiting for the game to start
    # Ввод подсвеченного слова в цикле
    And Enter the highlighted word in a loop
    # Фиксируем, что игра завершилась и кол-во символов в минуту больше чем 1500
    Then We fix that the game is over and there are more than 1500 symbols per minutes