package com.data.research.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@Document(collation = "Book")
public class Book {
    @Id
    private int id;
    private String bookName;
    private String author;
}
