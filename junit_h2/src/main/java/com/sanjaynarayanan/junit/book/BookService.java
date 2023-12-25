package com.sanjaynarayanan.junit.book;

import java.util.List;

public interface BookService {

	public List<Book> getAll();

	public Book findByBookId(Long bookId);

	public String save(Book book);
	
	public String update(Book book) throws Exception;

	public String delete(Long bookId);

}
