Feature: delete path

  Background:
    * def baseUrl = (typeof baseUrl !== 'undefined' ? baseUrl : castlemockApiBaseUrl)
    * def path = (typeof path !== 'undefined' ? path : '/parameters')
    * def token = (typeof token !== 'undefined' ? token : castlemockToken)
    * def authType = (typeof authType !== 'undefined' ? authType : 'Basic')
    * def body = (typeof body !== 'undefined' ? body : {})
    * def operation = 'DELETE'

  Scenario: send
    Given url baseUrl
    And header Authorization = authType + ' ' + token
    And path path
    When method delete
#    Then status 200
    * call read('classpath:com/peterland/karate/api/model/templates/print/print_request/print_request.feature') { baseUrl: '#(baseUrl)', path: '#(path)', operation: '#(operation)', body: '#(body)', response: '#(response)'}
