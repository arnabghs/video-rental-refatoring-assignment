package com.twu.refactor;

public class Movie {
	private String title;
	private MovieCategories category;

	public Movie(String title, MovieCategories category) {
		this.title = title;
		this.category = category;
	}

	public void setCategory(MovieCategories category){
		this.category = category;
	}

	public MovieCategories getCategory() {
		return category;
	}

	public String getTitle () {
		return title;
	}
}

