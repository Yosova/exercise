Feature: Prices
  Scenario Outline: Get available price

    When Request filter data <brandId>, <applicationDate>, <productId>

    Then Respond a available <price> from prices

    Examples:
      | brandId | applicationDate         | productId | price |
      | 1       | "2020-06-14T10:00:00"   | 35455     | 35.5  |
      | 1       | "2020-06-14T16:00:00"   | 35455     | 25.45 |
      | 1       | "2020-06-14T21:00:00"   | 35455     | 35.5  |
      | 1       | "2020-06-15T10:00:00"   | 35455     | 30.5  |
      | 1       | "2020-06-16T21:00:00"   | 35455     | 38.95 |