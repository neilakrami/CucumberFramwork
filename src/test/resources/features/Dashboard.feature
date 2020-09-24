Feature: Dashboard Functionality

  @dash
  Scenario: Dashboard tab verification
    When Login with valid credentials
    Then Verfiy the following dashboard tabs
      | Admin | PIM | Leave | Time | Recruitment | Performance | Dashboard | Directory |
   
   
    #Then click on checkboxes
      #| Tester    |
      #| PO        |
      #| Developer |
      #| Security  |
