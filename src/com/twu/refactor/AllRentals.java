package com.twu.refactor;

import java.util.ArrayList;

class AllRentals {
  private ArrayList<Rental> rentalList;

  AllRentals(ArrayList<Rental> rentalList) {
    this.rentalList = rentalList;
  }

  void addRental(Rental arg) {
    rentalList.add(arg);
  }

  String generateStatement(StatementGenerator generator, String name) {
    Double totalRent = calculateTotalAmount();
    int totalFrequencyRenterPoints = calculateTotalFrequencyPoints();

    StringBuilder result = new StringBuilder();
    result.append(generator.getTitleLine(name));

    for (Rental rental : rentalList) {
      String movieName = rental.getMovieTitle();
      double movieRent = rental.getRentForEachMovie();
      result.append(generator.getMovieDetails(movieName, movieRent));
    }

    result.append(generator.getFooterLines(totalRent, totalFrequencyRenterPoints));
    return result.toString();
  }

  private double calculateTotalAmount() {
    return rentalList.stream().mapToDouble(Rental::getRentForEachMovie).sum();
  }

  private int calculateTotalFrequencyPoints() {
    return rentalList.stream().mapToInt(Rental::updateFrequentRenterPoints).sum();
  }
}