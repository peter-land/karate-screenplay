Feature: combine two json

  Background:
#    * def jsonStrA = (typeof jsonA !== 'undefined' ? jsonA : '{ "name":{"first":"juan", "last":"perez"} }')
#    * def jsonStrB = (typeof jsonB !== 'undefined' ? jsonB : '{ "name":{ "last":"lopez" } }')

  Scenario: combine
    * def jsonA = karate.toBean(jsonStrA, 'net.minidev.json.JSONObject')
    * def jsonB = karate.toBean(jsonStrB, 'net.minidev.json.JSONObject')
#    * def jsonA = { a: { b: 1, c: 2 , a: { b: 4 } }, d: 3}
#    * def jsonB = { a: { b: 4 , a: { b: 5 } }, b: 4}
#    * def jsonA = { name: { first: juan, last: perez }}
#    * def jsonB = { name: { last: lopez }}
    * print jsonA
    * print jsonB
    * def jsonMix = karate.combine(jsonA, jsonB)
    * print jsonMix
