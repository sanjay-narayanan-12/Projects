package com.sanjaynarayanan.junit.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BookServiceImplTest {

	@Mock
	private BookRepository bookRepository;

	private BookService bookService;

	AutoCloseable autoCloseable;

	Book book;

	@BeforeEach
	void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		bookService = new BookServiceImpl(bookRepository);
		book = new Book(1L, "Demo", "Summary");
	}

	@Test
	void getAll_Test() {

	}

	@Test
	void findByBookId_Test() {
		mock(Book.class);
		mock(BookRepository.class);
		when(bookRepository.findById(1L)).thenReturn(Optional.ofNullable(book));
		assertThat(bookService.findByBookId(1L).getName()).isEqualTo(book.getName());
	}

	@Test
	void save_Test() {
		mock(Book.class);
		mock(BookRepository.class);
		when(bookRepository.save(book)).thenReturn(book);
		assertThat(bookService.save(book)).isEqualTo("Success");
	}

	@Test
	void update_Test() throws Exception {
		mock(Book.class);
		mock(BookRepository.class);
		when(bookRepository.save(book)).thenReturn(book);
		assertThat(bookService.update(book)).isEqualTo("Books updated successfully");
	}

	@Test
	void delete_Test() {
		mock(Book.class);
		mock(BookRepository.class, Mockito.CALLS_REAL_METHODS);
//		doAnswer(Answers.CALLS_REAL_METHODS).when(bookRepository.deleteById(any()));
		assertThat(bookService.delete(1L)).isEqualTo("Success");
	}

	@AfterEach
	void tearsDown() throws Exception {
		autoCloseable.close();
	}
}
