package com.twu.refactor;

class Movie {
  private String title;
  private MovieCategories category;

  Movie(String title, MovieCategories category) {
    this.title = title;
    this.category = category;
  }

  MovieCategories getCategory() {
    return category;
  }

  void setCategory(MovieCategories category) {
    this.category = category;
  }

  String getTitle() {
    return title;
  }
}

