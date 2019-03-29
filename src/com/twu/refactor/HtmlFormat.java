package com.twu.refactor;

public class HtmlFormat implements StatementGenerator {
  @Override
  public String getTitleLine(String name) {
  return "<H1>Rentals for <EM>" + name + "</EM></H1><P>";
  }

  @Override
  public String getMovieDetails(String movieName, Double movieRent) {
    return movieName + ": " + movieRent + "<BR>";
  }

  @Override
  public String getFooterLines(Double totalAmount, int frequentRenterPoints) {
    return "<P>You owe <EM>" + totalAmount + "</EM><P>On this rental you earned <EM>" +
            frequentRenterPoints + "</EM> frequent renter points<P>";
  }
}