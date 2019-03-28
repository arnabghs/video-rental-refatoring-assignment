package com.twu.refactor;

public class Rental {

  private Movie movie;
  private int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  String getMovieTitle() {
    return movie.getTitle();
  }

  double getRentForEachMovie() {
    double initialAmount = movie.getCategory().getInitialAmount();
    int baseDays = movie.getCategory().getBaseDays();
    double extraCharge = movie.getCategory().getExtraCharge();
    return calculateRent(initialAmount, baseDays, extraCharge);
  }

  private double chargeForExtraDays(int baseDays, double ratePerDay) {
    if (daysRented > baseDays) {
      return (daysRented - baseDays) * ratePerDay;
    }
    return 0;
  }

  private double calculateRent(double initialAmount, int baseDays, double extraCharge) {
    double chargeForExtraDays = chargeForExtraDays(baseDays, extraCharge);
    return initialAmount + chargeForExtraDays;
  }

  int updateFrequentRenterPoints() {
    if ((this.movie.getCategory() == MovieCategories.NEW_RELEASE) && this.daysRented > 1) {
      return 2;
    }
    return 1;
  }
}