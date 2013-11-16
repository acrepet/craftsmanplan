Feature: Print a Schedule
  As a craftsman
  In order to go to work
  I want to print my schedule

  Scenario: Print my appointments
  The list should be printed in chronological order by item beginning

    Given an appointments list:
      | city          | customer       |    beginning                         | travelduration |       end                             |
      | Montagny      | albert         |    2013-10-28T10:00:00.000+01:00     |    60          |   2013-10-28T10:30:00.000+01:00       |
      | Craponne      | lacote         |    2013-10-28T08:00:00.000+01:00     |    60          |   2013-10-28T08:30:00.000+01:00       |
      | St-Etienne    | besson         |    2013-10-28T14:00:00.000+01:00     |    60          |   2013-10-28T14:30:00.000+01:00       |
    When I print that list
    Then it should look like:
      """
      lacote Craponne 2013-10-28T08:00:00.000+01:00
      albert Montagny 2013-10-28T10:00:00.000+01:00
      besson St-Etienne 2013-10-28T14:00:00.000+01:00

      """