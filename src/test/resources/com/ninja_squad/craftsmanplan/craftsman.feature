Feature: Craftsman Plan

  @foo
  Scenario: Print my appointments
  The list should be printed in chronological order of the item beginning

    Given an appointments list:
      | city          | customer       |    datebeginning                         |
      | Montagny      | albert         |    2013-10-28T10:00:00.000+01:00         |
      | Craponne      | lacote            |    2013-10-28T08:00:00.000+01:00         |
      | St-Etienne    | besson         |    2013-10-28T14:00:00.000+01:00         |
    When I print that list
    Then it should look like:
      """
      lacote Craponne 2013-10-28T08:00:00.000+01:00
      albert Montagny 2013-10-28T10:00:00.000+01:00
      besson St-Etienne 2013-10-28T14:00:00.000+01:00

      """
