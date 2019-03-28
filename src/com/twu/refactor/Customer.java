package com.twu.refactor;

import java.util.ArrayList;

public class Customer {

  private String name;
  private ArrayList<Rental> rentalList = new ArrayList<Rental>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentalList.add(arg);
  }

  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    StringBuilder result = new StringBuilder("Rental Record for " + this.name + "\n");

    for (Rental rental : rentalList) {
      int daysRented = rental.getDaysRented();
      Movie movie = rental.getMovie();

      double initialAmount = movie.getCategory().getInitialAmount();
      int baseDays = movie.getCategory().getBaseDays();
      double extraCharge = movie.getCategory().getExtraCharge();
      double thisAmount = calculateRent(initialAmount, daysRented, baseDays, extraCharge);

      result.append(appendEachMovieDetails(rental.getMovie(), thisAmount));
      frequentRenterPoints += updateFrequentRenterPoints(rental.getMovie(), daysRented);
      totalAmount += thisAmount;
    }

    result.append(appendFooterLines(totalAmount, frequentRenterPoints));
    return result.toString();
  }

  private String appendFooterLines(double totalAmount, int frequentRenterPoints) {
    return "Amount owed is " + totalAmount + "\nYou earned " + frequentRenterPoints + " frequent renter points";
  }

  private String appendEachMovieDetails(Movie movie, double thisAmount) {
    return "\t" + movie.getTitle() + "\t" + thisAmount + "\n";
  }

  private double chargeForExtraDays(int daysRented, int baseDays, double ratePerDay) {
    if (daysRented > baseDays) {
      return (daysRented - baseDays) * ratePerDay;
    }
    return 0;
  }

  private double calculateRent(double initialAmount, int daysRented, int baseDays, double extraCharge) {
    double chargeForExtraDays = chargeForExtraDays(daysRented, baseDays, extraCharge);
    return initialAmount + chargeForExtraDays;
  }

  private int updateFrequentRenterPoints(Movie movie, int daysRented) {
    if ((movie.getCategory() == MovieCategories.NEW_RELEASE) && daysRented > 1) {
      return 2;
    }
    return 1;
  }
}