Feature: Craftsman Plan

  @foo
  Scenario: Print my appointments
  The list should be printed in chronological order of the item beginning

    Given an appointments list:
      | city          | customer       |
      | Montagny      | albert         |
      | Craponne      | joe            |
      | St-Etienne    | besson         |
    When I print that list
    Then it should look like:
      """
      albert Montagny
      joe Craponne
      besson St-Etienne

      """
