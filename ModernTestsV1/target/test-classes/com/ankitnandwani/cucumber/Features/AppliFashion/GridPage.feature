Feature: AppliFashion Homepage


  Scenario: Cross-Device Elements Test
    Given I am at AppliFashion Homepage for Task 1 test
    When I do nothing
    Then Page should be displayed correctly for step Cross-Device Elements Test


  Scenario: Shopping Experience Test
    Given I am at AppliFashion Homepage for Task 2 test
    When I apply filter for black shoes
    Then Page should be displayed correctly for step Filter Results
    #Then verify there are 2 black shoes and everything works and looks good

  @test
  Scenario: Product Details Test
    Given I am at AppliFashion Homepage for Task 3 test
    When I click on first black shoe and product details page is displayed
    Then Page should be displayed correctly for step Product Details test