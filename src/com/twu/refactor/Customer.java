package com.twu.refactor;

import java.util.ArrayList;

class Customer {

  private String name;
  private ArrayList<Rental> rentalList = new ArrayList<>();

  Customer(String name) {
    this.name = name;
  }

  void addRental(Rental arg) {
    rentalList.add(arg);
  }

  String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    StringBuilder result = new StringBuilder("Rental Record for " + this.name + "\n");

    for (Rental rental : rentalList) {
      String movieName = rental.getMovieTitle();
      double movieRent = rental.getRentForEachMovie();

      result.append(appendEachMovieDetails(movieName, movieRent));
      frequentRenterPoints += rental.updateFrequentRenterPoints();
      totalAmount += movieRent;
    }
    result.append(appendFooterLines(totalAmount, frequentRenterPoints));
    return result.toString();
  }

  private String appendFooterLines(double totalAmount, int frequentRenterPoints) {
    return "Amount owed is " + totalAmount + "\nYou earned " + frequentRenterPoints + " frequent renter points";
  }

  private String appendEachMovieDetails(String movieName, double thisAmount) {
    return "\t" + movieName + "\t" + thisAmount + "\n";
  }
}