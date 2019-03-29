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

  static String generateHTMLStatement(String name, List<Rental> rentalList, double totalAmount, int frequentRenterPoints) {
    StringBuilder result = new StringBuilder();
    result.append(generateHTMLTitleLine(name)).append("<P>");

    for (Rental rental : rentalList) {
      String movieName = rental.getMovieTitle();
      double movieRent = rental.getRentForEachMovie();
      result.append(appendEachMovieDetailsInHTML(movieName, movieRent));
    }
    result.append("<P>").append(generateFooterLinesInHTML(totalAmount, frequentRenterPoints));
    return result.toString();
  }

  private static String generateFooterLinesInHTML(double totalAmount, int frequentRenterPoints) {
    return "You owe <EM>" + totalAmount + "</EM><P>On this rental you earned <EM>" + frequentRenterPoints + "</EM> frequent renter points<P>";
  }

  private static String appendEachMovieDetailsInHTML(String movieName, double movieRent) {
    return movieName + ": " + movieRent + "<BR>";
  }

  private static String generateHTMLTitleLine(String name) {
    return "<H1>Rentals for <EM>" + name + "</EM></H1>";
  }

  private static String generateTitleLine(String name) {
    return "Rental Record for " + name + "\n";
  }

  private static String generateFooterLines(double totalAmount, int frequentRenterPoints) {
    return "Amount owed is " + totalAmount + "\nYou earned " + frequentRenterPoints + " frequent renter points";
  }

  private static String appendEachMovieDetails(String movieName, double movieRent) {
    return "\t" + movieName + "\t" + movieRent + "\n";
  }
}