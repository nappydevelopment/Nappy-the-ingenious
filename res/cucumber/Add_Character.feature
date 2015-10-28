Feature: Add a Character

  Scenario: Start Add_Character / Wiki
    Given The user is on the "Wiki Screen"
    When The user presses the button "Add_Character" on the "Wiki Screen"
    Then The "Add_Character Screen" will open in a new Window

  Scenario: Not all information filled
    Given At least 1 field is empty
    When The user presses the "Submit" button
    Then An Error Message is displayed because of missing information

  Scenario: Character already exists
    Given All information are filled in and the character already exists
    When The user presses the "Submit" button
    Then An Error Message is displayed because character does exist

  Scenario: Adding successful
    Given All information are filled in and the character does not exist
    When The user presses the "Submit" button
    Then The character is added to the database and a success-message is displayed