package com.data.research.resource;

import com.data.research.model.FilmDocument;
import com.data.research.service.FilmDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class FilmDocumentController {
    @Autowired
    private FilmDocumentService service;

    @GetMapping("/photo/{id}")
    public String getFilmDocument(
            @PathVariable(name = "id")String id,
            Model model
    ){
        FilmDocument filmDocument = service.getFilmDocument(id);
        model.addAttribute("title", filmDocument.getTitle());
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(filmDocument.getImage().getData()));
        return "photo";
    }
}
