Feature: Schedule a new appointment
  As a craftsman
  In order to fix a new appointment
  I want to check my availability schedule

  Scenario: Fix a possible appointment with a list of existing appointments

    Given an appointments list:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Montagny      | albert         |    2013-10-28T10:00:00.000+01:00         |    1000        |   2013-10-28T10:30:00.000+01:00       |
      | Craponne      | lacote         |    2013-10-28T08:00:00.000+01:00         |    2000        |   2013-10-28T08:30:00.000+01:00       |
      | St-Etienne    | besson         |    2013-10-28T14:00:00.000+01:00         |    1000        |   2013-10-28T14:30:00.000+01:00       |
    And a new proposal for appointment:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Ecully        | leroux         |    2013-10-28T15:00:00.000+01:00         |    1000        |   2013-10-28T15:30:00.000+01:00       |
    When I want to check my availability schedule to confirm the new proposal for appointment
    Then it should look like:
    """
    lacote Craponne 2013-10-28T08:00:00.000+01:00
    albert Montagny 2013-10-28T10:00:00.000+01:00
    besson St-Etienne 2013-10-28T14:00:00.000+01:00
    leroux Ecully 2013-10-28T15:00:00.000+01:00

    """

  Scenario: Fix a possible appointment without any other appointment

    Given an appointments list:
      | city          | customer       |    beginning                             | travelduration |       end                             |
    And a new proposal for appointment:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Ecully        | leroux         |    2013-10-28T15:00:00.000+01:00         |    6000        |   2013-10-28T15:30:00.000+01:00       |
    When I want to check my availability schedule to confirm the new proposal for appointment
    Then it should look like:
    """
    leroux Ecully 2013-10-28T15:00:00.000+01:00

    """
  Scenario: Fix a possible appointment with only one existing appointment

    Given an appointments list:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Montagny      | albert         |    2013-10-28T10:00:00.000+01:00         |    1000          |   2013-10-28T10:30:00.000+01:00       |
    And a new proposal for appointment:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Ecully        | leroux         |    2013-10-28T15:00:00.000+01:00         |    1000          |   2013-10-28T15:30:00.000+01:00       |
    When I want to check my availability schedule to confirm the new proposal for appointment
    Then it should look like:
    """
    albert Montagny 2013-10-28T10:00:00.000+01:00
    leroux Ecully 2013-10-28T15:00:00.000+01:00

    """
  Scenario: Fix a possible appointment with a conflict with an existing appointment

    Given an appointments list:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Montagny      | albert         |    2013-10-28T10:00:00.000+01:00         |    700        |   2013-10-28T10:30:00.000+01:00       |
    And a new proposal for appointment:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Brignais      | brun           |    2013-10-28T10:10:00.000+01:00         |    1000        |   2013-10-28T10:30:00.000+01:00       |
    When I want to check my availability schedule to confirm the new proposal for appointment
    Then it should look like:
    """
    albert Montagny 2013-10-28T10:00:00.000+01:00

    """