package com.twu.refactor;

public class Rental {

  private Movie movie;
  private int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  String getMovieTitle() {
    return movie.getTitle();
  }

  double getRentForEachMovie() {
    return movie.getRent(daysRented);
  }

  int updateFrequentRenterPoints() {
    if ((this.movie.getCategory() == MovieCategories.NEW_RELEASE) && this.daysRented > 1) {
      return 2;
    }
    return 1;
  }
}