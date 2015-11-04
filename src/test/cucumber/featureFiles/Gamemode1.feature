Feature: Gamemode 1
  as a User
  The User will play the first gamemode.

  Scenario: Start Gamemode 1 / Mainscreen
    Given The user is on the "Mainscreen"
    When The user presses the button "New Game" on the "Mainscreen"
    Then A new game will start with the "Gamemode 1"

  Scenario: Start Gamemode 1 / Menu
    Given There is not a active game
    When The user presses the button "New Game" on the menu "Spiel"
    Then A new game will start with "Gamemode 1"

  Scenario: Play Gamemode 1
    Given There is a active game
    When "Nappy" asks questions to guess the character
    Then The user answers the questions with "Yes", "No" or "I dont know"

  Scenario: Finish Gamemode 1
    Given "Nappy" knows to 90% the character
    When "Nappy" shows the putative character
    Then The user answers question with "Yes" or "No"