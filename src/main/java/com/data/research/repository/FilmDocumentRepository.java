package com.data.research.repository;

import com.data.research.model.FilmDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmDocumentRepository extends MongoRepository <FilmDocument, String>{
}
