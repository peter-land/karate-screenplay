Feature: post project import

  Scenario Outline: post project import
    * def type = (typeof type !== 'undefined' ? type : '<Type>')
    * def file = (typeof file !== 'undefined' ? file : '<File>')
    * def path = '<Path>/' + type +'/import'
    * def baseUrl = (typeof baseUrl !== 'undefined' ? baseUrl : castlemockApiBaseUrl)

    When call read('classpath:com/peterland/karate/api/model/templates/post/post_path_authorized_multipart/post_path_authorized_multipart.feature') { baseUrl: '#(baseUrl)', path: '#(path)', file: '#(file)'}
    And xml responseXml = response

    Examples:
      | Path                   | Type | File                                         |
      | /api/rest/core/project | soap | classpath:schemas/castlemock/soi/no-data.xml |
