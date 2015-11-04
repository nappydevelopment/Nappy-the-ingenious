Feature: Play Gamemode 2
  as a User
  The User will play the first gamemode.

  Scenario: Start Gamemode 2
    Given The user finished "Gamemode 1"
    And The user accepted to play "Gamemode 2" in the end of "Gamemode 1"
    And In the settings is "Gamemode 2" active
    When "Nappy" chose a character
    Then The user is on the gamescreen of "Gamemode 2"

  Scenario: Play Gamemode 2
    Given The user is on the gamescreen of "Gamemode 2"
    When The user asks "Nappy" questions
    Then "Nappy" answers with "Yes" or "No"

  Scenario: Finish Gamemode 2
    Given The user knows the putative character
    When The user clicks the button "I know your character" and chooses a character from a list
    Then "Nappy" answers with "Yes" or "No"
    And "Nappy" shows the gameresult