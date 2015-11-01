Feature: Change the program settings

  Scenario: Start change settings
    Given The user is on the "MainStage"
    When The user presses on the menu-item "Einstellungen" on the menu "Spiel"
    Then The "SettingsStage" will open in a new Window

  Scenario: Change the language setting to English
    Given The user is on the "SettingsStage" And The toggle-button "German" is activated
    When The user presses the "English" toggle-button
    Then The change is saved
    
  Scenario: Change the language setting to German
    Given The user is on the "SettingsStage" And The toggle-button "English" is activated
    When The user presses the "German" toggle-button
    Then The change is saved
    
  Scenario: Change the color-theme setting to dark
    Given The user is on the "SettingsStage" And The toggle-button "Bright" is activated
    When The user presses the "Dark" toggle-button
    Then The change is saved

  Scenario: Change the color-theme setting to bright
    Given The user is on the "SettingsStage" And The toggle-button "Dark" is activated
    When The user presses the "Bright" toggle-button
    Then The change is saved

  Scenario: Change the game-mode setting to only-nappy-guess
    Given The user is on the "SettingsStage" And The toggle-button "Complete" is activated
    When The user presses the "Only_Nappy_Guess" toggle-button
    Then The change is saved
    
  Scenario: Change the game-mode setting to complete
    Given The user is on the "SettingsStage" And The toggle-button "Only_Nappy_Guess" is activated
    When The user presses the "Complete" toggle-button
    Then The change is saved
    
    