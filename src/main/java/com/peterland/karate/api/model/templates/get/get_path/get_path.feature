Feature: get path

  Background:
    * def baseUrl = (typeof baseUrl !== 'undefined' ? baseUrl : occiautoApiBaseUrl)
    * def path = (typeof path !== 'undefined' ? path : '/parameters')
    * def body = (typeof body !== 'undefined' ? body : {})
    * def operation = 'GET'

  Scenario: send
    Given url baseUrl
    And path path
    When method get
    Then status 200
    * call read('classpath:com/peterland/karate/api/model/templates/print/print_request/print_request.feature') { baseUrl: '#(baseUrl)', path: '#(path)', operation: '#(operation)', body: '#(body)', response: '#(response)'}
