Feature: post path authorized

  Background:
    * def id = read('classpath:scripts/random_id.js')
    * def baseUrl = (typeof baseUrl !== 'undefined' ? baseUrl : castlemockApiBaseUrl)
    * def path = (typeof path !== 'undefined' ? path : '/api/rest/core/project/rest/import')
    * def identification = (typeof identification !== 'undefined' ? identification : id(100000,999999999))
    * def parameters = { identification: '#(identification)' }
    * def token = (typeof token !== 'undefined' ? token : castlemockToken)
    * def authType = (typeof authType !== 'undefined' ? authType : 'Basic')
    * def multipartFile = { read: #(file)}
    * def multipart = { value: #(value)}
    * def multipart = (typeof value !== 'undefined' ? multipart : multipartFile )
    * def operation = 'POST'

  Scenario: send
    Given url baseUrl
    And header Authorization = authType + ' ' + token
    And path path
    And multipart file file = multipart
    When method post
    Then status 200
    * call read('classpath:com/peterland/karate/api/model/templates/print/print_request/print_request.feature') { baseUrl: '#(baseUrl)', path: '#(path)', operation: '#(operation)', body: '#(body)', response: '#(response)'}

