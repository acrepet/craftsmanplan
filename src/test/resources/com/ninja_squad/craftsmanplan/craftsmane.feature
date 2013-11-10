Feature: Craftsman Plan

  @foo
  Scenario: Print my appointments
  The list should be printed in chronological order of the item beginning

    Given an appointments list:
      | city          | customer       |    datebeginning                         |
      | Montagny      | albert         |    2013-10-28T16:08:13.324+01:00         |
      | Craponne      | joe            |    2013-10-28T16:10:13.324+01:00         |
      | St-Etienne    | besson         |    2013-10-28T16:14:13.324+01:00         |
    When I print that list
    Then it should look like:
      """
      albert Montagny 2013-10-28T16:08:13.324+01:00
      joe Craponne 2013-10-28T16:10:13.324+01:00
      besson St-Etienne 2013-10-28T16:14:13.324+01:00

      """
