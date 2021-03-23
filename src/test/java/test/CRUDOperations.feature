Feature: Perform CRUD Operations

  Scenario Outline: To Perform the GET Operation on Employe DB
    Given The "<Base_URI>" for Get Operation
    When User perform the Get Operation
    Then Response should not be null
    And "<Response_Code>" should be as expected

    Examples: 
      | Base_URI                        | Response_Code |
      | http://localhost:8088/employees |           200 |

  Scenario Outline: To Perform the GET Operation on GitHUb
    Given The "<Base_URI>" for Get Operation
    When User perform the Get Operation
    Then Response should not be null
    And "<Response_Code>" should be as expected

    Examples: 
      | Base_URI                                    | Response_Code |
      | https://api.github.com/users/nicks204/repos |           200 |

  Scenario Outline: To Perform the Post Operation on GitHUb
    Given The "<Base_URI>" for Post Operation and token is "<Token>"
    When User perform the Post Operation
    Then Response should not be null
    And "<Response_Code>" should be as expected

    Examples: 
      | Base_URI                          | Response_Code | Token                                    |
      | https://api.github.com/user/repos |           201 | 278918f831fb274b8fc49b7ce62828e491af9146 |
      

  Scenario Outline: To Perform the Patch Operation on GitHUb
    Given The "<Base_URI>" for Patch Operation and token is "<Token>"
    When User perform the Patch Operation
    Then Response should not be null
    And "<Response_Code>" should be as expected

    Examples: 
      | Base_URI                                       | Response_Code | Token                                    |
      | https://api.github.com/repos/nicks204/Postman3 |           200 | 278918f831fb274b8fc49b7ce62828e491af9146 |
