Feature: View statistic

  Scenario: Start view statistic over button
    Given The user is on the "MainStage"
    When The user presses the button "Statitik" on the "MainStage"
    Then The "StatisticStage" will open in a new Window
    
  Scenario: Start view statistic over menu-item
    Given The user is on the "MainStage"
    When The user presses on the menu-item "Statistik" on the menu "Spiel"
    Then The "StatisticStage" will open in a new Window

  Scenario: Close the statistic-window
    Given The user is on the "StatisticStage"
    When The user presses the "Close" button in the window-title-bar
    Then The "StatisticStage" will be closed

