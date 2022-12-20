package com.sgenlecroyant.spring.security.builder;

import java.util.Date;

import com.sgenlecroyant.spring.security.entity.Book;

public class BookBuilder {

	private String title;
	private String author;
	private Date editionDate;

	public BookBuilder() {
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Date getEditionDate() {
		return editionDate;
	}

	public BookBuilder title(String title) {
		this.title = title;
		return this;
	}

	public BookBuilder author(String author) {
		this.author = author;
		return this;
	}

	public BookBuilder editionDate(Date editionDate) {
		this.editionDate = editionDate;
		return this;
	}

	public Book build() {
		return new Book();
	}

}
