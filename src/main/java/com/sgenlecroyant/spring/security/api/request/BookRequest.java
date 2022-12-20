package com.sgenlecroyant.spring.security.api.request;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sgenlecroyant.spring.security.util.DateSerializer;

public class BookRequest {

	private String title;
	private String author;
	@JsonSerialize(using = DateSerializer.class)
	private Date editionDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getEditionDate() {
		return editionDate;
	}

	public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}

}
