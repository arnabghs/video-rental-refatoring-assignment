package com.twu.refactor;

public enum MovieCategories {
  CHILDRENS(1.5, 3, 1.5),
  REGULAR(2, 2, 1.5),
  NEW_RELEASE(0, 0, 3);

  private final double initialAmount;
  private final int baseDays;
  private final double extraCharge;

  MovieCategories(double initialAmount, int baseDays, double extraCharge) {
    this.initialAmount = initialAmount;
    this.baseDays = baseDays;
    this.extraCharge = extraCharge;
  }

  double calculateRent(int daysRented) {
    double chargeForExtraDays = chargeForExtraDays(daysRented);
    return this.initialAmount + chargeForExtraDays;
  }

  private double chargeForExtraDays(int daysRented) {
    if (daysRented > this.baseDays) {
      return (daysRented - this.baseDays) * this.extraCharge;
    }
    return 0;
  }
}