package com.librarymanagementsystem.LibraryManagementSystem.repository;

import com.librarymanagementsystem.LibraryManagementSystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
