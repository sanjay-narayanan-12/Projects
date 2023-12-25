package com.sanjaynarayanan.junit.book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;

	Book book;
	List<Book> bookList;

	@BeforeEach
	void setUp() {
//		bookList = new ArrayList<>();
		book = new Book(1L, "Demo", "Summary");
		bookRepository.save(book);
//		bookList.add(book);
//		book = new Book(2L, "Demo1", "Summary1");
//		bookList.add(book);
//		bookRepository.saveAll(bookList);
	}

	@Test
	void testFindByName_Test() {
		Book bookTest = bookRepository.findByName("Demo");
		assertNotNull(bookTest);
		assertEquals("Summary", bookTest.getSummary());
	}

	@Test
	void testFindAll_Test() {
//		List<Book> bookList = bookRepository.findAll();
//		Assertions.assertThat(bookList.isEmpty()).isTrue();
		Book book = bookRepository.findByName("Demo12");
		assertNull(book);
//		System.out.println(bookList);
//		assertEquals(2, bookList.size());
	}

	@AfterEach
	void tearDown() {
		book = null;
		bookList = null;
		bookRepository.deleteAll();
	}
}
