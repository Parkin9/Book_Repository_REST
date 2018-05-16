package pl.coderslab.services;

import java.util.List;

import pl.coderslab.models.Book;

public interface BookService {
	List<Book> getList();
	void setList(List<Book> bookList);
	Book getById(long id);
	void addNew(Book newBook);
	boolean update(long id, Book newBook);
	boolean delete(long id);
}
