package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin("http://localhost:4200/")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable("id") int id){
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
    }
    @GetMapping("/getall")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
