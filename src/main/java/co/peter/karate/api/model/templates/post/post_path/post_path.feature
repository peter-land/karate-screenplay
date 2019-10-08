Feature: post path

  Background:
    * def baseUrl = (typeof baseUrl !== 'undefined' ? baseUrl : occiautoApiBaseUrl)
    * def path = (typeof path !== 'undefined' ? path : '/customer/validate')
    * def bodyStr = (typeof bodyStr !== 'undefined' ? bodyStr : '{}')
    * def body = (typeof body !== 'undefined' ? body : karate.toBean(bodyStr, 'net.minidev.json.JSONObject'))
    * def operation = 'POST'

  Scenario: send
    Given url baseUrl
    And path path
    And request body
    When method post
#    Then status 200
    * call read('classpath:co/peter/karate/api/model/templates/print/print_request/print_request.feature') { baseUrl: '#(baseUrl)', path: '#(path)', operation: '#(operation)', body: '#(body)', response: '#(response)'}
