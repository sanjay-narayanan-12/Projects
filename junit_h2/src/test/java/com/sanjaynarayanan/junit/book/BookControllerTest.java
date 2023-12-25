package com.sanjaynarayanan.junit.book;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookController.class)
class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	Book book1;
	Book book2;
	List<Book> bookList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		book1 = new Book(1L, "Demo1", "Summary1");
		book2 = new Book(2L, "Demo2", "Summary2");
		bookList.add(book1);
		bookList.add(book2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetBooks() throws Exception {
		when(bookService.getAll()).thenReturn(bookList);
		this.mockMvc//
		.perform(get("/books").header("", "").param("", ""))//
		.andDo(print())//
		.andExpect(status().isOk());
	}

	@Test
	void testGetBooksById() {
	}

	@Test
	void testSaveBooks() {
	}

	@Test
	void testUpdateBooks() {
	}

}
