Feature: AppliFashion Homepage

  @run
  Scenario: Cross-Device Elements Test
    Given I am at AppliFashion Homepage for Task 1 test
    When I do nothing
    Then Page should be displayed correctly for step Cross-Device Elements Test

  @run
  Scenario: Shopping Experience Test
    Given I am at AppliFashion Homepage for Task 2 test
    When I apply filter for black shoes
    Then Page should be displayed correctly for step Filter Results

  @run
  Scenario: Product Details Test
    Given I am at AppliFashion Homepage for Task 3 test
    When I click on first black shoe and product details page is displayed
    Then Page should be displayed correctly for step Product Details test