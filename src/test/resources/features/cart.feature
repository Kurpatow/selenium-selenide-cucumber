Feature: Корзина

  Scenario: Добавление товара в корзину
    Given пользователь авторизован
    When пользователь добавляет товар "Sauce Labs Backpack" в корзину
    And пользователь открывает корзину
    Then корзина содержит товар "Sauce Labs Backpack"

  Scenario: Добавление нескольких товаров в корзину
    Given пользователь авторизован
    When пользователь добавляет товар "Sauce Labs Backpack" в корзину
    And пользователь добавляет товар "Sauce Labs Bike Light" в корзину
    And пользователь открывает корзину
    Then корзина содержит товар "Sauce Labs Backpack"
    And корзина содержит товар "Sauce Labs Bike Light"