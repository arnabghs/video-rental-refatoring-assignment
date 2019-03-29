package com.twu.refactor;

import java.util.List;

class Statement {

  static String generateStatement(String name, double totalAmount, int frequentRenterPoints, List<Rental> rentalList) {
    StringBuilder result = new StringBuilder(generateTitleLine(name));
    for (Rental rental : rentalList) {
      String movieName = rental.getMovieTitle();
      double movieRent = rental.getRentForEachMovie();
      result.append(appendEachMovieDetails(movieName, movieRent));
    }
    result.append(generateFooterLines(totalAmount, frequentRenterPoints));
    return result.toString();
  }

  private static String generateTitleLine(String name) {
    return "Rental Record for " + name + "\n";
  }

  private static String generateFooterLines(double totalAmount, int frequentRenterPoints) {
    return "Amount owed is " + totalAmount + "\nYou earned " + frequentRenterPoints + " frequent renter points";
  }

  private static String appendEachMovieDetails(String movieName, double thisAmount) {
    return "\t" + movieName + "\t" + thisAmount + "\n";
  }
}