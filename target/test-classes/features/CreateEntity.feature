Feature: Create Entity View And Upload functionality

  @CreateEntitys
  Scenario Outline: To verify search product data from shipping page
    Given User is on Home Page "<TestCaseName>" and "<TestSheetName>"
    When User Login with "DO+DP+DU" Credentials
    Then user Enter product in search details page
    Then user verify search result displayed in list and click the search data
    Then user checkout the selected item from checkout page
    #Then user enter delivery details in delivery page
    #And user verify the Delivery date and time on the Review and pay page.
    #And quit from the application

    Examples: 
      | TestCaseName | TestSheetName |
      | SearchData   | UATSanity     |
 
 
 @CreateEntitys
  Scenario Outline: To verify invalid Login scenario
  
   Given User is on Home Page "<TestCaseName>" and "<TestSheetName>"
   When User Login with invalid Credentials 
   Then User validate invalid workflow
   When User Login with "DO+DP+DU" Credentials
   Then user Enter product in search details page
    And user compare the price product
  
   Examples: 
      | TestCaseName | TestSheetName |
      | InvalidLogin   | UATSanity     |
 
 
 @CreateEntity
  Scenario Outline: Compare price scenario
  
   Given User is on Home Page "<TestCaseName>" and "<TestSheetName>"
    And user compare the price product
  
   Examples: 
      | TestCaseName | TestSheetName |
      | InvalidLogin   | UATSanity     |
  