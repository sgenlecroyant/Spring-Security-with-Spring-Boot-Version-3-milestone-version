package com.sgenlecroyant.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgenlecroyant.spring.security.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
