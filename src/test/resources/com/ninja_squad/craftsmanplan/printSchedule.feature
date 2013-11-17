Feature: Print a Schedule
  As a craftsman
  In order to go to work
  I want to print my schedule

  Scenario: Print my appointments
  The list should be printed in chronological order by item beginning

    Given an appointments list:
      | city          | customer       |    beginning           | travelduration |       end             |    travelkm     |
      | Montagny      | albert         |    28/10/2013 10:00:00 |    1000        |   28/10/2013 10:30:00 |     12          |
      | Craponne      | lacote         |    28/10/2013 08:00:00 |    2000        |   28/10/2013 08:30:00 |     14          |
      | St-Etienne    | besson         |    28/10/2013 14:00:00 |    1000        |   28/10/2013 14:30:00 |     20          |
    When I print that list
    Then it should look like:
      """
      lacote Craponne 28/10/2013 08:00:00
      albert Montagny 28/10/2013 10:00:00
      besson St-Etienne 28/10/2013 14:00:00

      """