Feature: Проверка функционала формы регистрации

  Background:
    When открыт сайт "http://demo.guru99.com/V1/index.php"

  Scenario: Проверяем валидные значения логина и пароля в "Gtpl Bank"
    And в поле "Login" ввели значение "mngr320665"
    And в поле "Password" ввели значение "barEgum"
    And нажать кнопку "btnLogin"
    # User is not valid!
    Then адрес сайта равен "http://demo.guru99.com/V1/html/Managerhomepage.php"

  Scenario: Проверяем ввод значений логина и пароля в "Gtpl Bank"
    And в поле "Login" ввели значение "12345678"
    And в поле "Password" ввели значение "12345678"
    And нажать кнопку "btnReset"
    And проверяем пустоту полей

  Scenario: Проверяем ввод валидных значений в "Guru99 Bank"
    When открыт сайт "https://demo.guru99.com/Agile_Project/Agi_V1/"
    And в поле "Login" ввели значение "1303"
    And в поле "Password" ввели значение "Guru99"
    And нажать кнопку "btnLogin"
    Then адрес сайта равен "https://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php"
