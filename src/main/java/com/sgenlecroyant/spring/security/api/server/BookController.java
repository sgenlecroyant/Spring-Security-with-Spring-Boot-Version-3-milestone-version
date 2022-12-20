package com.sgenlecroyant.spring.security.api.server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgenlecroyant.spring.security.api.request.BookRequest;
import com.sgenlecroyant.spring.security.api.response.BookResponse;
import com.sgenlecroyant.spring.security.service.BookService;

@RestController
@RequestMapping(path = "/api/v1")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping(path = "/books/{id}")
	public ResponseEntity<BookResponse> fetchBookById(@PathVariable Integer id) {
		BookResponse bookResponse = this.bookService.fetchBookById(id);
		return new ResponseEntity<BookResponse>(bookResponse, HttpStatus.OK);
	}

	@PostMapping(path = "/books")
	public ResponseEntity<BookResponse> saveBook(@RequestBody BookRequest bookRequest) {
		BookResponse bookResponse = this.bookService.saveBook(bookRequest);
		return ResponseEntity.<BookResponse>ok(bookResponse);
	}

}
