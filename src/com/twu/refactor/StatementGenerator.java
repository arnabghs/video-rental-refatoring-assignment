package com.twu.refactor;

interface StatementGenerator {
  String getTitleLine(String name);

  String getMovieDetails(String movieName, Double movieRent);

  String getFooterLines(Double totalAmount, int frequentRenterPoints);
}