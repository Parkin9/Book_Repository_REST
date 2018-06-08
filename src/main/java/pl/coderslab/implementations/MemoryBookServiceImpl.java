package pl.coderslab.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.coderslab.models.Book;
import pl.coderslab.services.BookService;

@Component
public class MemoryBookServiceImpl implements BookService {
	private List<Book> bookList;

	public MemoryBookServiceImpl() {
		bookList = new ArrayList<>();
		bookList.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
		bookList.add(new Book(2L, "9788324627738", "Rusz glowa,	Java.", "Sierra	Kathy, Bates Bert", "Helion", "programming"));
		bookList.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
	}

	public List<Book> getList() {
		return this.bookList;
	}

	public void setList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Book getById(long id) {
		for(Book book : bookList) {
			if(book.getId() == id) {
				return book;
			}
		}
		return null;
	}
	
	public void addNew(Book newBook) {
		bookList.add(newBook);
	}
	
	public boolean update(long id, Book newBook) {
		for(Book book : bookList) {
			if(book.getId() == id) {
				bookList.remove(getById(id));
				newBook.setId(id);
				bookList.add(newBook);
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(long id) {
		for(Book book : bookList) {
			if(book.getId() == id) {
				bookList.remove(getById(id));
				return true;
			}
		}
		return false;
	}
	
}
