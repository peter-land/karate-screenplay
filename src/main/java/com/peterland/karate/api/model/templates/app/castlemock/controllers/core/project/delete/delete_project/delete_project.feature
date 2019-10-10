Feature: delete project

  Scenario Outline: delete project
    * def type = (typeof type !== 'undefined' ? type : '<Type>')
    * def projectId = (typeof projectId !== 'undefined' ? projectId : '<ProjectId>')
    * def path = '<Path>/' + type + '/' + projectId
    * def baseUrl = (typeof baseUrl !== 'undefined' ? baseUrl : castlemockApiBaseUrl)

    When call read('classpath:com/peterland/karate/api/model/templates/delete/delete_path/delete_path.feature') { baseUrl: '#(baseUrl)', path: '#(path)'}

    Examples:
      | Path                   | Type | ProjectId |
      | /api/rest/core/project | soap | FF8UaC    |
