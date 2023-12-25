package com.sanjaynarayanan.junit.book;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepo;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepo = bookRepository;
	}

	@Override
	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	@Override
	public Book findByBookId(Long bookId) {
		return bookRepo.findById(bookId).get();
	}

	@Override
	public String save(Book book) {
		bookRepo.save(book);
		return "Success";
	}

	@Override
	public String update(Book book) throws Exception {
		if (book == null || book.getBookId() == null) {
			throw new Exception("Book id must be not null");
		}
		Optional<Book> bookDetail = bookRepo.findById(book.getBookId());
		if (!bookDetail.isPresent()) {
			throw new Exception("Book details does not exists");
		}
		Book existBook = bookDetail.get();
		existBook.setName(book.getName());
		existBook.setSummary(book.getSummary());
		bookRepo.save(book);
		return "Books updated successfully";
	}

	@Override
	public String delete(Long bookId) {
		bookRepo.deleteById(bookId);
		return "Success";
	}

}
