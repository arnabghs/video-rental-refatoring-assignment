package com.twu.refactor;

public class TextFormat implements StatementGenerator {
  @Override
  public String getTitleLine(String name) {
    return "Rental Record for " + name + "\n";
  }

  @Override
  public String getMovieDetails(String movieName, Double movieRent) {
    return "\t" + movieName + "\t" + movieRent + "\n";
  }

  @Override
  public String getFooterLines(Double totalAmount, int frequentRenterPoints) {
    return "Amount owed is " + totalAmount + "\nYou earned " + frequentRenterPoints + " frequent renter points";
  }
}