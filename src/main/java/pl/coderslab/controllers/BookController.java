package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.models.Book;
import pl.coderslab.services.BookService;

import java.util.List;

@RestController //@ResponseBody + @Controller
public class BookController {

	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

/////////////////////////////////////////////////////////////////////////////

	@GetMapping("/books")
	public List<Book> showBookList() {
		List<Book> bookList = bookService.getList();
		return bookList;
	}
	
	@GetMapping("/books/{id}")
	public Book showBookById(@PathVariable long id) {
		Book book = bookService.getById(id);
		return book;
	}
	
	@PostMapping("/books")
	public String addBook(@RequestBody Book newBook) {
		bookService.addNew(newBook);
		return "Book has been added.";
	}
	
	@PutMapping("/books/{id}")
	public String updateBook(@PathVariable long id, @RequestBody Book newBook) {
		if(bookService.update(id, newBook)) {
			return "Book (ID: " + id + ") has been updated.";
		} else {
			return "Book (ID: " + id + ") doesn't exist.";
		}
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable long id) {
		if(bookService.delete(id)) {
			return "Book (ID: " + id + ") has been deleted.";
		} else {
			return "Book (ID: " + id + ") doesn't exist.";
		}
	}
}
