Feature: Craftsman Plan

  @foo
  Scenario: Print my appointments
  The list should be printed in chronological order of the item beginning

    Given an appointments list:
      | city          | customer       |    datebeginning    |  timebeginning        |
      | Montagny      | albert         |    02-12-13         |       11:00           |
      | Craponne      | joe            |    02-12-13         |       12:00           |
      | St-Etienne    | besson         |    02-12-13         |       14:00           |
    When I print that list
    Then it should look like:
      """
      albert Montagny
      joe Craponne
      besson St-Etienne

      """
