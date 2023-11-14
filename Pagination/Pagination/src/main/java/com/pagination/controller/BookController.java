package com.pagination.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.entity.Books;
import com.pagination.service.BookService;


@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
    private BookService bookService;

    @PostMapping("/save")
    public Books addBook(@RequestBody Books book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/findById/{id}")
    public Books findBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @GetMapping("/findAll")
    public Page<Books> findAllBooks(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    ) {
        return bookService.findAllBooks(page, size);
    }

    @PutMapping("/update/{id}")
    public Books updateBook(@PathVariable Long id, @RequestBody Books book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        return bookService.deleteById(id);
    }
}


