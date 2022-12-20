package com.sgenlecroyant.spring.security.entity;

import java.util.Date;

import com.sgenlecroyant.spring.security.api.request.BookRequest;
import com.sgenlecroyant.spring.security.builder.BookBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "books")
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String author;
	private Date editionDate;

	public Book() {
	}

	public Book(BookBuilder builder) {
		this.title = builder.getTitle();
		this.author = builder.getAuthor();
		this.editionDate = builder.getEditionDate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public static BookBuilder newBuilder(BookRequest bookRequest) {
		return new BookBuilder(bookRequest);
	}

}
