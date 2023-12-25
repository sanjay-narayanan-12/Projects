package com.sanjaynarayanan.junit.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

	Book findByName(String name);
}
