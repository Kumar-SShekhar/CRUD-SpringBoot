package com.librarymanagementsystem.LibraryManagementSystem.controller;


import com.librarymanagementsystem.LibraryManagementSystem.model.Book;
import com.librarymanagementsystem.LibraryManagementSystem.repository.BookRepository;
import com.librarymanagementsystem.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

//    @GetMapping("/getAllBooks")
//    public ResponseEntity<List<Book>> getAllBooks(){
//        List<Book> bookList= new ArrayList<>();
//        bookRepo.findAll().forEach(bookList::add);
//        return new ResponseEntity<>(bookList, HttpStatus.OK);
////        return bookList;
//    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping("/borrowBook/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/returnBook/{bookId}")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
//            return ResponseEntity.ok(returnedBook);
            return new ResponseEntity<>(returnedBook, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}










//@RestController
//@RequestMapping("/book")
//
//public class BookController {
//
//    @Autowired
//    private BookRepository bookRepo;
//
//    @GetMapping("/getAllBooks")
//    public ResponseEntity<List<Book>> getAllBooks(){
//        List<Book> bookList= new ArrayList<>();
//        bookRepo.findAll().forEach(bookList::add);
//        return new ResponseEntity<>(bookList, HttpStatus.OK);
////        return bookList;
//    }
//
//    @GetMapping("/getBookById/{id}")
//    public Book getBookById(@PathVariable Long Id){
//        Optional<Book> bookData=bookRepo.findById(Id);
//        return bookData.get();
//    }
//
//    @PostMapping("/addBook")
//    public Book addBook(@RequestBody Book book){
//        Book bookObj=bookRepo.save(book);
//        return bookObj;
//    }
//
//
//}
