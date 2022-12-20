package com.sgenlecroyant.spring.security.api.response;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sgenlecroyant.spring.security.entity.Book;
import com.sgenlecroyant.spring.security.util.DateSerializer;

public class BookResponse {

	private String title;
	private String author;
	@JsonSerialize(using = DateSerializer.class)
	private Date editionDate;

	private BookResponse(String title, String author, Date editionDate) {
		this.title = title;
		this.author = author;
		this.editionDate = editionDate;
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

	public static BookResponse fromBook(Book book) {
		return new BookResponse(book.getTitle(), book.getAuthor(), book.getEditionDate());
	}

}
