package com.twu.refactor;

class Movie {
  private String title;
  private MovieCategories category;

  Movie(String title, MovieCategories category) {
    this.title = title;
    this.category = category;
  }

  void setCategory(MovieCategories category) {
    this.category = category;
  }

  String getTitle() {
    return title;
  }

  double getRent(int daysRented) {
    return this.category.calculateRent(daysRented);
  }

  boolean isNewlyReleased() {
    return category.isNewlyReleased();
  }
}