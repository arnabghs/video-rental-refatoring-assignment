package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

  private String name;
  private ArrayList<Rental> rentalList = new ArrayList<Rental>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentalList.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;

    int daysRented = 0;
    int baseDays;
    double extraCharge;
    double initialAmount;

    Iterator<Rental> rentals = rentalList.iterator();
    StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

    while (rentals.hasNext()) {
      double thisAmount = 0;
      Rental each = rentals.next();

      switch (each.getMovie().getPriceCode()) {
        case Movie.REGULAR:
          initialAmount = 2;
          daysRented = each.getDaysRented();
          baseDays = 2;
          extraCharge = 1.5;

          thisAmount = calculateRent(initialAmount, daysRented, baseDays, extraCharge);
          break;

        case Movie.NEW_RELEASE:
          daysRented = each.getDaysRented();
          initialAmount = 0;
          baseDays = 0;
          extraCharge = 3;
          thisAmount = calculateRent(initialAmount, daysRented, baseDays, extraCharge);
          break;

        case Movie.CHILDRENS:
          initialAmount = 1.5;
          daysRented = each.getDaysRented();
          baseDays = 3;
          extraCharge = 1.5;

          thisAmount = calculateRent(initialAmount, daysRented, baseDays, extraCharge);
          break;
      }
      frequentRenterPoints += updateFrequentRenterPoints(each.getMovie(), daysRented);
      result.append(appendEachMovieDetails(each.getMovie(), thisAmount));
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
    if ((movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
      return 2;
    }
    return 1;
  }

}


