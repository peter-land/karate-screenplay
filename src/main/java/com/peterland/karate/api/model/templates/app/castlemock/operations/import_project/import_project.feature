Feature: import project

  Scenario Outline: import project
    * def type = (typeof type !== 'undefined' ? type : '<Type>')
    * def file = (typeof file !== 'undefined' ? file : '<File>')
    * def projectId = (typeof projectId !== 'undefined' ? projectId : '<ProjectId>')
    * def baseUrl = (typeof baseUrl !== 'undefined' ? baseUrl : castlemockApiBaseUrl)

    Given call read('classpath:co/bocc/occiauto/qa/api/model/karate/castlemock/controllers/core/project/delete/delete_project/delete_project.feature') { baseUrl: '#(baseUrl)', type: '#(type)', projectId: '#(projectId)' }
    When call read('classpath:co/bocc/occiauto/qa/api/model/karate/castlemock/controllers/core/project/post/post_project_import/post_project_import.feature') { baseUrl: '#(baseUrl)', type: '#(type)', file: '#(file)'}

    Examples:
      | Type | ProjectId | File                                         |
      | soap | 3cxIcN    | classpath:schemas/castlemock/soi/no-data.xml |
