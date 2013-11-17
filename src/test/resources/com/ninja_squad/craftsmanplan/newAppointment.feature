Feature: Schedule a new appointment
  As a craftsman
  In order to fix a new appointment
  I want to check my availability schedule

  Scenario: Schedule a possible appointment with a list of existing appointments

    Given an appointments list:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Montagny      | albert         |    28/10/2013 10:00:00                   |    1000        |   28/10/2013 10:30:00                 |
      | Craponne      | lacote         |    28/10/2013 08:00:00                   |    2000        |   28/10/2013 08:30:00                 |
      | St-Etienne    | besson         |    28/10/2013 14:00:00                   |    1000        |   28/10/2013 14:30:00                 |
    And a new proposal for appointment:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Ecully        | leroux         |    28/10/2013 15:00:00                   |    1000        |   28/10/2013 15:30:00                 |
    When I want to check my availability schedule to confirm the new proposal for appointment
    Then it should look like:
    """
    lacote Craponne 28/10/2013 08:00:00
    albert Montagny 28/10/2013 10:00:00
    besson St-Etienne 28/10/2013 14:00:00
    leroux Ecully 28/10/2013 15:00:00

    """

  Scenario: Schedule a possible appointment without any other appointment

    Given an appointments list:
      | city          | customer       |    beginning                             | travelduration |       end                             |
    And a new proposal for appointment:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Ecully        | leroux         |    28/10/2013 15:00:00                   |    6000        |   28/10/2013 15:30:00                 |
    When I want to check my availability schedule to confirm the new proposal for appointment
    Then it should look like:
    """
    leroux Ecully 28/10/2013 15:00:00

    """
  Scenario: Schedule a possible appointment AFTER a single existing appointment

    Given an appointments list:
      | city          | customer       |    beginning                             | travelduration   |       end                           |
      | Montagny      | albert         |    28/10/2013 10:00:00                   |    1000          |   28/10/2013 10:30:00               |
    And a new proposal for appointment:
      | city          | customer       |    beginning                             | travelduration   |       end                           |
      | Ecully        | leroux         |    28/10/2013 15:00:00                   |    1000          |   28/10/2013 15:30:00               |
    When I want to check my availability schedule to confirm the new proposal for appointment
    Then it should look like:
    """
    albert Montagny 28/10/2013 10:00:00
    leroux Ecully 28/10/2013 15:00:00

    """
  Scenario: Schedule a possible appointment BEFORE a single existing appointment

    Given an appointments list:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Montagny      | albert         |    28/10/2013 15:00:00                   |    1000        |   28/10/2013 15:30:00                 |
    And a new proposal for appointment:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Ecully        | leroux         |    28/10/2013 10:00:00                   |    1000        |   28/10/2013 10:30:00                 |
    When I want to check my availability schedule to confirm the new proposal for appointment
    Then it should look like:
    """
    leroux Ecully 28/10/2013 10:00:00
    albert Montagny 28/10/2013 15:00:00

    """

  Scenario: Schedule a possible appointment with a conflict with an existing appointment

    Given an appointments list:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Montagny      | albert         |    28/10/2013 10:00:00                   |    700         |   28/10/2013 10:30:00                 |
    And a new proposal for appointment:
      | city          | customer       |    beginning                             | travelduration |       end                             |
      | Brignais      | brun           |    28/10/2013 10:10:00                   |    1000        |   28/10/2013 15:30:00                 |
    When I want to check my availability schedule to confirm the new proposal for appointment
    Then it should look like:
    """
    albert Montagny 28/10/2013 10:00:00

    """