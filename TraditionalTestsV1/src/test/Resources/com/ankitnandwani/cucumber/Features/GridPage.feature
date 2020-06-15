Feature: AppliFashion Homepage

  @run
  Scenario Outline: Cross-Device Elements Test
    Given I run the test on <browser> with <width> and <height>
    And I am at AppliFashion Homepage for Task 1 test in <mode>
    When I do nothing
    Then SearchBar should be displayed correctly

    Examples:
      | browser | width | height | mode   |
      | chrome  | 1200  | 700    | laptop |
      | firefox | 1200  | 700    | laptop |
      | edge    | 1200  | 700    | laptop |
      | chrome  | 768   | 700    | tablet |
      | firefox | 768   | 700    | tablet |
      | edge    | 768   | 700    | tablet |
      | chrome  | 500   | 700    | mobile |

  @run
  Scenario Outline: Cross-Device Elements Test
    Given I run the test on <browser> with <width> and <height>
    And I am at AppliFashion Homepage for Task 1 test in <mode>
    When I do nothing
    Then Magnifying glass should be displayed correctly

    Examples:
      | browser | width | height | mode   |
      | chrome  | 1200  | 700    | laptop |
      | firefox | 1200  | 700    | laptop |
      | edge    | 1200  | 700    | laptop |
      | chrome  | 768   | 700    | tablet |
      | firefox | 768   | 700    | tablet |
      | edge    | 768   | 700    | tablet |
      | chrome  | 500   | 700    | mobile |

  @run
  Scenario Outline: Cross-Device Elements Test
    Given I run the test on <browser> with <width> and <height>
    And I am at AppliFashion Homepage for Task 1 test in <mode>
    When I click the white filter
    Then only white shoes should be displayed

    Examples:
      | browser | width | height | mode   |
      | chrome  | 1200  | 700    | laptop |
      | firefox | 1200  | 700    | laptop |
      | edge    | 1200  | 700    | laptop |
      | chrome  | 768   | 700    | tablet |
      | firefox | 768   | 700    | tablet |
      | edge    | 768   | 700    | tablet |
      | chrome  | 500   | 700    | mobile |
