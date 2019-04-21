@ignore
Feature: Get parameters

  Background:
    Given url 'http://www.google.com'

  Scenario: Get parameters verify response structure

    When method get
    And print response
    Then status 200
