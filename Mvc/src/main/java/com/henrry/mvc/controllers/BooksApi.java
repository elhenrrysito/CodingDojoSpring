package com.henrry.mvc.controllers;

import com.henrry.mvc.models.Book;
import com.henrry.mvc.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksApi {
    private final BookService bookService;

    public BooksApi(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();

    }

    @RequestMapping(value="/api/books", method= RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title,
                       @RequestParam(value="description") String desc,
                       @RequestParam(value="language") String lang,
                       @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        System.out.println("Libro Creado");
        return bookService.createBook(book);
    }

    @RequestMapping(value="/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        System.out.println("Hola");
        Book book = bookService.findBook(id);
        return book;
    }

    @RequestMapping(value="/api/books/{id}", method = RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id,
                       @RequestParam(value="title") String title,
                       @RequestParam(value="description") String description,
                       @RequestParam(value="language") String language,
                       @RequestParam(value="pages") Integer pages) {

        Book book = bookService.findBook(id);
        book.setTitle(title);
        book.setDescription(description);
        book.setLanguage(language);
        book.setNumberOfPages(pages);


        return bookService.updateBook(book);
    }

    @RequestMapping(value="/api/books/{id}", method= RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
