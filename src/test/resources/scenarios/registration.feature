Feature: Проверка функционала формы регистрации

  Background:
    When открыт сайт "http://demo.guru99.com/V1/index.php"

  Scenario: Проверяем валидные значения логина и пароля
    And в поле "Login" ввели значение "mngr320665"
    And в поле "Password" ввели значение "barEgum"
    And нажать кнопку "btnLogin"
    # User is not valid!
    Then адрес сайта равен "http://demo.guru99.com/V1/html/Managerhomepage.php"

  Scenario: Проверяем валидные значения логина и пароля
    And в поле "Login" ввели значение "12345678"
    And в поле "Password" ввели значение "12345678"
    And нажать кнопку "btnReset"
    And проверяем пустоту полей
