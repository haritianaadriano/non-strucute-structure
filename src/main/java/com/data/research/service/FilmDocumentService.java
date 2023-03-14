package com.data.research.service;

import com.data.research.model.FilmDocument;
import com.data.research.repository.FilmDocumentRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FilmDocumentService {
    @Autowired
    private FilmDocumentRepository repository;

    //SAVE image
    public String insertFilmDocument(String title, MultipartFile file) throws IOException {
        FilmDocument newFilmDocument = new FilmDocument();
        newFilmDocument.setTitle(title);
        newFilmDocument.setImage(
                new Binary(
                BsonBinarySubType.BINARY,
                file.getBytes())
        );
        newFilmDocument = repository.insert(newFilmDocument);
        return("the file with id#"+newFilmDocument.get_id()+" was store successfully");
    }

    //GET image
    public FilmDocument getFilmDocument(String id){
        return repository.findById(id).get();
    }
}
