Feature: Address management

  As a registered user
  I want to add and delete addresses
  So that I can manage my delivery options

  Scenario Outline: Add a new address and then delete it
    Given I am logged in as "nvmbxlntxynutmcgfa@tcwlx.com" with password "mybestpassword"
    When I go to the Addresses page
    And I click on Create new address button
    And I fill in the new address form with "<alias>", "<address>", "<city>", "<state>", "<zip>", "<country>" and "<phone>"
    Then I should see the new address on the Addresses page
    And I click on Delete button for address
    Then I should not see an additional address on the Addresses page
    Examples:
      | alias | address        | city   | state  | zip   | country       | phone        |
      | Home  | 1234 Main St    | Denver | Nevada | 80014 | United States | 191-222-3333 |
      | Work  | 456 Office Ave | Boston | Maine  | 02115 | United States | 444-505-6666 |