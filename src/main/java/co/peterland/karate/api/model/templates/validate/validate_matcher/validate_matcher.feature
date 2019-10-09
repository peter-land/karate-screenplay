Feature: validate response with matcher

  Background:
    * json response = (typeof response !== 'undefined' ? response : '{"approved": true,"approvalId": 383172,"approvalState": "APROBADO","versionLegalText": "Ver004"}')
    * json expected = (typeof expected !== 'undefined' ? expected : '{approvalState: APROBADO , approved: true}')
    * def matcher = (typeof matcher !== 'undefined' ? matcher : '#(^expected)')

  Scenario: validate
    And match response == matcher
