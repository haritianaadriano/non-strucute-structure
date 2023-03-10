package com.data.research.repository;

import com.data.research.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository <Book, Integer> {
}
