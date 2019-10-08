Feature: print request

  Background:
    * def baseUrl = (typeof baseUrl !== 'undefined' ? baseUrl : occiautoApiBaseUrl)
    * def path = (typeof path !== 'undefined' ? path : '/parameters')
    * def operation = (typeof operation !== 'undefined' ? operation : 'GET')
    * def body = (typeof body !== 'undefined' ? body : '{}')
    * def response = (typeof response !== 'undefined' ? response : '{code=400, errors=["personalInfo.email: must match"]}')

  Scenario: print
    * def pretty_response = karate.pretty(response)
    * def pretty_body = karate.pretty(body)
    * print 'OPERATION:' , operation
    * print 'URL:' , baseUrl + path
    * print 'BODY:' , pretty_body
    * print 'RESPONSE:' , pretty_response
