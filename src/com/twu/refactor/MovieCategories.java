package com.twu.refactor;

public enum MovieCategories {
  CHILDRENS(2,1.5, 3, 1.5),
  REGULAR(0,2,2,1.5),
  NEW_RELEASE(1,0,0,3);

   final int priceCode;
  private final double initialAmount;
  private final int baseDays;
  private final double extraCharge;

  MovieCategories(int priceCode, double initialAmount, int baseDays, double extraCharge) {
    this.priceCode = priceCode;
    this.initialAmount = initialAmount;
    this.baseDays = baseDays;
    this.extraCharge = extraCharge;
  }

  public double getInitialAmount() {
    return initialAmount;
  }

  public int getBaseDays() {
    return baseDays;
  }

  public double getExtraCharge() {
    return extraCharge;
  }
}
