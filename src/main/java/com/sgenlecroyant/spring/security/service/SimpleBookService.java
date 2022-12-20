package com.sgenlecroyant.spring.security.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sgenlecroyant.spring.security.api.request.BookRequest;
import com.sgenlecroyant.spring.security.api.response.BookResponse;
import com.sgenlecroyant.spring.security.entity.Book;
import com.sgenlecroyant.spring.security.repository.BookRepository;

@Service
public class SimpleBookService implements BookService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private final BookRepository bookRepository;

	public SimpleBookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public BookResponse fetchBookById(Integer id) {
		return this.bookRepository.findById(id).map((book) -> BookResponse.fromBook(book))
				.orElseThrow(() -> new RuntimeException("No Such a Book with id: " + id));
	}

	@Override
	public BookResponse saveBook(BookRequest bookRequest) {
		Book book = Book.newBuilder(bookRequest).editionDate(new Date()).build();

		Book savedBook = this.bookRepository.save(book);
		this.logger.info("Book Id before persistence: " + book.getId());
		this.logger.info("Book Id after persistence: " + savedBook.getId());
		return BookResponse.fromBook(savedBook);
	}

}
