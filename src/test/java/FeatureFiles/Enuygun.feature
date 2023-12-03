Feature: Enuygun Test Case

  Scenario: Buying a airplane ticket

    Given Navigate to Enuygun Website
    And Click on desired flight trip on the screen
    And Click on the departure flight picker
    And Parametrically Select a City For Departure
    #You can change it with typing new valid city name
      | selectDepartureFlight | Istanbul |
    And Click on the arrival flight picker
    And Parametrically Select a City For Arrival
    #You can change it with typing new valid city name
      | selectArrivalFlight | Ankara |
    And Click on departure date picker
    And Parametrically Select a Departure Date
      | 18 |
    And Click on arrival date picker
    And Parametrically Select a Arrival Date
      | 21 |
    And Click on direct flight CheckBox
    And Click on number of passengers and flight class selector
    And Select number of adult passengers
      | 3 |
    And Select number of child passengers
      | 2 |
    And Select number of infant passengers
      | 4 |
    And Select flight class
    #You can change it just typing -economy-
      | business |
    When Click on Submit Button
    Then Validate User should be able to see all flight

