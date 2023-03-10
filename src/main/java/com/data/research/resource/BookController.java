package com.data.research.resource;

import com.data.research.model.Book;
import com.data.research.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository repository;

    @GetMapping("/book")
    public List<Book> findAll(){
        return repository.findAll();
    }

    @GetMapping("/book/{id}")
    public Book findBookById(@PathVariable(name = "id")int id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book newBook){
        return repository.save(newBook);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable(name = "id")int id){
        repository.deleteById(id);
        return("the book was deleted successfully");
    }
}
