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

    StringBuilder result = new StringBuilder(generator.getTitleLine(name));
    for (Rental rental : rentalList) {
      result.append(generator.getMovieDetails(rental.getMovieTitle(), rental.getRent()));
    }
    result.append(generator.getFooterLines(totalRent, totalFrequencyRenterPoints));
    return result.toString();
  }

  private double calculateTotalAmount() {
    return rentalList.stream().mapToDouble(Rental::getRent).sum();
  }

  private int calculateTotalFrequencyPoints() {
    return rentalList.stream().mapToInt(Rental::updateFrequentRenterPoints).sum();
  }
}