Feature: validate response

  Background:
#    * def baseUrl = (typeof baseUrl !== 'undefined' ? baseUrl : occiautoApiBaseUrl)
#    * def path = (typeof path !== 'undefined' ? path : '/parameters')
    * def file = (typeof file !== 'undefined' ? file : 'classpath:schemas/occiauto/controllers/parameters/get/get_parameters/get-parameters-response-schema.json')
    * def statusCode = (typeof statusCode !== 'undefined' ? statusCode : 200)

  Scenario: validate
#    Given url baseUrl
#    Given path path
#    When method get
#    Then status 200
    And def structure = read (file)
    Then match responseStatus == statusCode
    And match response == structure
