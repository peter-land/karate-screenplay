Feature: get path authorized

  Background:
    * def getToken = read('classpath:scripts/get_token.js')
    * def baseUrl = (typeof baseUrl !== 'undefined' ? baseUrl : occiautoApiBaseUrl)
    * def path = (typeof path !== 'undefined' ? path : '/currencies')
    * def token = (typeof token !== 'undefined' ? token : getToken())
    * def body = (typeof body !== 'undefined' ? body : {})
    * def operation = 'GET'

  Scenario: send
    Given url baseUrl
    And header Authorization = 'Bearer ' + token
    And path path
    When method get
    Then status 200
    * call read('classpath:com/peterland/karate/api/model/templates/print/print_request/print_request.feature') { baseUrl: '#(baseUrl)', path: '#(path)', operation: '#(operation)', body: '#(body)', response: '#(response)'}
