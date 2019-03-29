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
    double totalAmount = calculateTotalAmount();
    int frequentRenterPoints = calculateTotalFrequencyPoints();
    return Statement.generateStatement(name, totalAmount, frequentRenterPoints, rentalList);
  }

  String htmlStatement() {
    double totalAmount = calculateTotalAmount();
    int frequentRenterPoints = calculateTotalFrequencyPoints();
    return Statement.generateHTMLStatement( name, rentalList, totalAmount,frequentRenterPoints);
  }

  private double calculateTotalAmount() {
    return rentalList.stream().mapToDouble(Rental::getRentForEachMovie).sum();
  }

  private int calculateTotalFrequencyPoints() {
    return rentalList.stream().mapToInt(Rental::updateFrequentRenterPoints).sum();
  }
}