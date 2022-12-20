package com.sgenlecroyant.spring.security.service;

import com.sgenlecroyant.spring.security.api.request.BookRequest;
import com.sgenlecroyant.spring.security.api.response.BookResponse;

public interface BookService {
	
	public BookResponse fetchBookById(Integer id);
	public BookResponse saveBook(BookRequest bookRequest);

}
