package com.sanjaynarayanan.junit.book;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public List<Book> getBooks() {
		return bookService.getAll();
	}

	@GetMapping("{bookId}")
	public Book getBooksById(@PathVariable Long bookId) {
		return bookService.findByBookId(bookId);
	}

	@PostMapping
	public String saveBooks(@RequestBody Book book) {
		return bookService.save(book);
	}

	@PutMapping
	public String updateBooks(@RequestBody Book book) throws Exception {
		
		return bookService.update(book);
	}
}
