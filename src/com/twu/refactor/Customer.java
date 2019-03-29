package com.twu.refactor;

import java.util.ArrayList;

class Customer {
  private String name;
  private AllRentals rentalList = new AllRentals(new ArrayList<>());

  Customer(String name) {
    this.name = name;
  }

  void addRental(Rental arg) {
    rentalList.addRental(arg);
  }

  String statement() {
    return rentalList.generateStatement(new TextFormat(), name);
  }

  String htmlStatement() {
    return rentalList.generateStatement(new HtmlFormat(), name);
  }
}