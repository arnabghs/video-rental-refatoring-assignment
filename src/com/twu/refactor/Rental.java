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
    boolean isNewlyReleased = this.movie.isNewlyReleased();
    return (isNewlyReleased && this.daysRented > 1) ? 2 : 1;
  }
}