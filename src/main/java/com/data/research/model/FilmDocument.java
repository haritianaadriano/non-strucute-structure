package com.data.research.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@Document(collection = "Film")
public class FilmDocument {
    @Id
    private String _id;
    private String title;
    private Binary image;
}
